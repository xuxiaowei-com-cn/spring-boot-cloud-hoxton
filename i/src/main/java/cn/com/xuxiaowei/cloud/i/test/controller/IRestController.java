package cn.com.xuxiaowei.cloud.i.test.controller;


import cn.com.xuxiaowei.cloud.i.test.entity.I;
import cn.com.xuxiaowei.cloud.i.test.service.IIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户模块测试表 前端控制器
 * </p>
 *
 * @author 徐晓伟
 * @since 2021-02-21
 */
@RestController
@RequestMapping("/test/i")
public class IRestController {

    private IIService iiService;

    @Autowired
    public void setIiService(IIService iiService) {
        this.iiService = iiService;
    }

    /**
     * 测试 参数接收、保存数据
     *
     * @param request  请求
     * @param response 响应
     * @param session  session
     * @param i        用户模块测试表
     * @return 返回 测试结果
     */
    @RequestMapping("/save")
    public Map<String, Object> save(HttpServletRequest request, HttpServletResponse response, HttpSession session,
                                    @RequestBody I i) {

        Map<String, Object> map = new HashMap<>(4);
        Map<String, Object> data = new HashMap<>(4);
        map.put("data", data);

        i.setCreateUsername("xxw");
        i.setCreateIp(request.getRemoteHost());

        iiService.save(i);

        map.put("code", "00000");
        map.put("msg", "保存成功");
        map.put("I Session ID", session.getId());
        data.put("i", i);

        return map;
    }

}

