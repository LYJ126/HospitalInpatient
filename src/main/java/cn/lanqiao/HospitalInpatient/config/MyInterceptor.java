package cn.lanqiao.HospitalInpatient.config;

import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

public class MyInterceptor implements HandlerInterceptor {

    // 请求处理之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 如果是登录请求，直接放行
        if ("/adminUser/login".equals(request.getRequestURI())) {
            return true;
        }
        // 请求处理前的逻辑，例如权限验证
        // 如果不满足条件，重定向到指定页面
        if (!isAllowed(request)) {
            response.sendRedirect("/login.html");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 请求处理后，视图渲染前的逻辑
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 请求完成后的逻辑，例如记录日志
    }

    private boolean isAllowed(HttpServletRequest request) {
        // 实现具体的权限验证逻辑，例如检查用户是否登录
        // 简单示例：假设登录用户的信息存储在session中
        return request.getSession().getAttribute("user")!= null;
    }
}
