package com.qinli.interceptor;

import com.qinli.util.JWTUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author supermantx
 * @time 2021/1/28 19:12
 * 拦截url请求
 */

public class tokenInterceptor implements HandlerInterceptor {
    /**
     * 过滤处login页面,判断提交时是否提供token
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        // 首页的url地址
        String url = "https://www.baidu.com";
        try {
            JWTUtils.verify(token);
        }catch (Exception e){
            StringBuilder builder = new StringBuilder();
            builder.append("<script type=\"text/javascript\">");
            builder.append("alert('网页过期，请重新登录！');");
            builder.append("window.top.location.href='");
            builder.append(url);
            builder.append("';");
            builder.append("</script>");
            response.getWriter().print(builder.toString());

        }
        return false;
    }
}
