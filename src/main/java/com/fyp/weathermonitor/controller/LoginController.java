package com.fyp.weathermonitor.controller;

import com.fyp.weathermonitor.entity.po.Users;
import com.fyp.weathermonitor.entity.vo.ResponseVO;
import com.fyp.weathermonitor.service.UsersService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/")
public class LoginController extends ABaseController{

    @Resource
    private UsersService usersService;

    @RequestMapping("/login")
    public ResponseVO login(@RequestBody Users user) {
        Users loginUser = usersService.getUsersByUsername(user.getUsername());
        System.out.println(loginUser);
        return getSuccessResponseVO("111");
    }
}
