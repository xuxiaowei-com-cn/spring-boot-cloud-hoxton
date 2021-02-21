package cn.com.xuxiaowei.cloud.ui.ribbon;

import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 灰度 负载均衡路由
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Configuration
public class GrayLoadBalancerRule extends AbstractLoadBalancerRule {

    private final Random RANDOM = new Random();

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {

        // 是否调用灰度发布
        boolean grayInvocation;

        String gray = "gray";

        try {

            // 获取灰度发布
            String grayValue = RibbonRequestContextHolder.getCurrentContext().get(gray);

            // 服务器列表
            List<Server> serverList = getLoadBalancer().getReachableServers();
            int size = serverList.size();

            if (StringUtils.isEmpty(grayValue)) {
                // 未设置 灰度发布
                return serverList.get(RANDOM.nextInt(size));
            }

            // 灰度发布
            grayInvocation = Boolean.TRUE.toString().equals(grayValue);

            // 灰度服务器列表
            List<Server> grayServerList = new ArrayList<>();

            // 普通服务器列表
            List<Server> normalServerList = new ArrayList<>();

            // 灰度服务器 分离
            for (Server server : serverList) {
                NacosServer nacosServer = (NacosServer) server;
                Map<String, String> metadata = nacosServer.getMetadata();
                if (metadata.containsKey(gray) && Boolean.TRUE.toString().equals(metadata.get(gray))) {
                    grayServerList.add(server);
                } else {
                    normalServerList.add(server);
                }
            }

            if (grayInvocation) {
                // 调用 灰度服务器
                int graySize = grayServerList.size();
                if (graySize > 0) {
                    // 存在 灰度服务器
                    return grayServerList.get(RANDOM.nextInt(graySize));
                }
            } else {
                // 调用 普通服务器
                int normalSize = normalServerList.size();
                if (normalSize > 0) {
                    // 存在 普通服务器
                    return normalServerList.get(RANDOM.nextInt(normalSize));
                }
            }

            return serverList.get(RANDOM.nextInt(size));

        } finally {
            RibbonRequestContextHolder.clearContext();
        }

    }

}
