package com.qinli.interceptor;

import com.qinli.util.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author supermantx
 * @time 2021/1/28 19:12
 * 拦截url请求
 */
public class TokenInterceptor implements HandlerInterceptor {
    /**
     * 过滤处login页面,判断提交时是否提供token
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        try {
            JWTUtils.verify(request.getHeader("token"));
        } catch (Exception e) {
            response.getWriter().write("{\"status\":\"400\"}");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }
}
