package cn.com.xuxiaowei.cloud.oauth2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 社交资源
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Controller
@RequestMapping("/sns")
public class SnsRestController {

    /**
     * 根据 scope 获取用户详细信息的资源
     *
     * @param oAuth2Authentication OAuth 2身份验证令牌可以包含两种身份验证：
     *                             一种用于客户端，一种用于用户。
     *                             由于某些OAuth授权授予不需要用户身份验证，因此用户身份验证可能为null。
     */
    @RequestMapping("/userinfo")
    public ResponseEntity<Map<String, Object>> userinfo(OAuth2Authentication oAuth2Authentication) {

        Map<String, Object> map = new HashMap<>(8);
        String username = oAuth2Authentication.getName();
        map.put("username", username);

        return ResponseEntity.ok(map);
    }

}
