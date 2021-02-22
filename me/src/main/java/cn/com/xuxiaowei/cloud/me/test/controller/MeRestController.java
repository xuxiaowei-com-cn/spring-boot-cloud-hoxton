package cn.com.xuxiaowei.cloud.me.test.controller;


import cn.com.xuxiaowei.cloud.me.test.dto.MeDTO;
import cn.com.xuxiaowei.cloud.me.test.service.IMeService;
import cn.com.xuxiaowei.cloud.me.test.vo.MeVO;
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
@RequestMapping("/test/me")
public class MeRestController {

    private IMeService iMeService;

    @Autowired
    public void setiMeService(IMeService iMeService) {
        this.iMeService = iMeService;
    }

    /**
     * 测试 参数接收、保存数据
     *
     * @param request  请求
     * @param response 响应
     * @param session  session
     * @param meDTO    用户模块测试表
     * @return 返回 测试结果
     */
    @RequestMapping("/save")
    public Map<String, Object> save(HttpServletRequest request, HttpServletResponse response, HttpSession session,
                                    @RequestBody MeDTO meDTO) {

        Map<String, Object> map = new HashMap<>(4);
        Map<String, Object> data = new HashMap<>(4);
        map.put("data", data);

        meDTO.setCreateUsername("xxw");
        meDTO.setCreateIp(request.getRemoteHost());

        MeVO meVO = iMeService.saveSeata(meDTO);

        map.put("code", "00000");
        map.put("msg", "保存成功");
        map.put("Me Session ID", session.getId());
        data.put("meVO", meVO);

        return map;
    }

}

