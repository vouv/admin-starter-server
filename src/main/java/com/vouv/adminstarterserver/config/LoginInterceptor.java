package com.vouv.adminstarterserver.config;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.vouv.adminstarterserver.exception.UnAuthException;
import com.vouv.adminstarterserver.util.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    public static final String TOKEN_KEY = "X-Token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        if(!"/api/login".equals(requestURI)) {
            String token = request.getHeader(TOKEN_KEY);

            if(!StringUtils.hasLength(token)) {
                throw new UnAuthException();
            }
            try {
                DecodedJWT decodedJWT = JWTUtil.decode(token);
                Long userId = decodedJWT.getClaim("user_id").asLong();
                request.setAttribute("user_id", userId);
            }catch (Exception e) {
                throw new UnAuthException();
            }

        }
        return true;
    }
}
