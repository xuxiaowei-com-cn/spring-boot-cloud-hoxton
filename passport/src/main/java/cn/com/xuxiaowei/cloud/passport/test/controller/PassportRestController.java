package cn.com.xuxiaowei.cloud.passport.test.controller;


import cn.com.xuxiaowei.cloud.passport.test.dto.PassportDTO;
import cn.com.xuxiaowei.cloud.passport.test.service.IPassportService;
import cn.com.xuxiaowei.cloud.passport.test.vo.PassportVO;
import cn.com.xuxiaowei.cloud.passport.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;
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
 * 登录模块测试表 前端控制器
 * </p>
 *
 * @author 徐晓伟
 * @since 2021-02-21
 */
@Slf4j
@RestController
@RequestMapping("/test/passport")
public class PassportRestController {

    private IPassportService passportService;

    @Autowired
    public void setPassportService(IPassportService passportService) {
        this.passportService = passportService;
    }

    /**
     * 测试 参数接收、保存数据
     *
     * @param request     请求
     * @param response    响应
     * @param session     session
     * @param passportDTO 登录模块测试表
     * @return 返回 测试结果
     */
    @RequestMapping("/save")
    public Map<String, Object> save(HttpServletRequest request, HttpServletResponse response, HttpSession session,
                                    @RequestBody PassportDTO passportDTO) {

        Map<String, String> headerMap = RequestUtils.getHeaderMap(request);
        log.info(String.valueOf(headerMap));

        Map<String, Object> map = new HashMap<>(4);
        Map<String, Object> data = new HashMap<>(4);
        map.put("data", data);

        passportDTO.setCreateUsername("xxw");
        passportDTO.setCreateIp(request.getRemoteHost());

        PassportVO passportVO = passportService.saveSeata(passportDTO);

        map.put("code", "00000");
        map.put("msg", "保存成功");
        map.put("Passport Session ID", session.getId());
        data.put("passportVO", passportVO);

        return map;
    }

}

