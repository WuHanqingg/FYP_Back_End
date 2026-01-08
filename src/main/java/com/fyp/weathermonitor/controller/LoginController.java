package com.fyp.weathermonitor.controller;

import com.fyp.weathermonitor.entity.enums.ResponseCodeEnum;
import com.fyp.weathermonitor.entity.po.Users;
import com.fyp.weathermonitor.entity.vo.ResponseVO;
import com.fyp.weathermonitor.entity.vo.tokenVO;
import com.fyp.weathermonitor.exception.BusinessException;
import com.fyp.weathermonitor.service.UsersService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fyp.weathermonitor.utils.TokenUtil;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class LoginController extends ABaseController{

    @Resource
    private UsersService usersService;

    @RequestMapping("/login")
    public ResponseVO login(@RequestBody Users user) {
        Users loginUser = usersService.getUsersByUsername(user.getUsername());
        if(loginUser == null || !loginUser.getPasswordHash().equals(user.getPasswordHash())){
            BusinessException exception = new BusinessException(ResponseCodeEnum.CODE_401);
            return getBusinessErrorResponseVO(exception,"用户名或密码错误");
        }
        tokenVO token = TokenUtil.createToken(loginUser.getUsername(),loginUser.getFullName());
        return getSuccessResponseVO(token);
    }

    @RequestMapping("/refreshToken")
    public ResponseVO refreshToken(HttpServletRequest request) {
        String refreshToken = request.getHeader("Authorization");
        tokenVO token = TokenUtil.refreshToken(refreshToken);
        if(token == null){
            BusinessException exception = new BusinessException(ResponseCodeEnum.CODE_401);
            return getBusinessErrorResponseVO(exception,"刷新token失败");
        }
        return getSuccessResponseVO(token);
    }

    @RequestMapping("/testLogin")
    public ResponseVO testLogin() {
        return getSuccessResponseVO("testLogin");
    }
}
