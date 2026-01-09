package com.fyp.weathermonitor.interceptor;

import com.auth0.jwt.JWT;
import com.fyp.weathermonitor.entity.Constants;
import com.fyp.weathermonitor.entity.po.Users;
import com.fyp.weathermonitor.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fyp.weathermonitor.utils.TokenUtil;
@Component
public class authorizationInterceptor implements HandlerInterceptor {
    @Autowired
    private UsersService usersService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在请求处理之前执行
        String token = request.getHeader("Authorization");
        token = token.substring(7);
        String username = JWT.decode(token).getClaim("username").asString();
        Users userDb = usersService.getUsersByUsername(username);
        String userRole = userDb.getRole();
        if(!userRole.equals(Constants.ADMIN_VALUE)){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return false;
        }
        Integer isActive = userDb.getIsActive();
        if(isActive==null || isActive != Constants.ACTIVATED){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return false;
        }
        return true;
    }
}
