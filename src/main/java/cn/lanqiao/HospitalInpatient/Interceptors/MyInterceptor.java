package cn.lanqiao.HospitalInpatient.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

    // 在请求处理之前被调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在此处进行预处理逻辑，例如身份验证、日志记录等
        System.out.println("preHandle: 在请求处理之前执行");
        // 返回true表示继续执行后续的处理器；返回false则中断请求处理
        return true;
    }

    // 在请求处理之后，视图渲染之前被调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView!= null) {
            System.out.println("postHandle: 在请求处理之后，视图渲染之前执行");
        }
    }

    // 在整个请求处理完成之后被调用，包括视图渲染完成后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion: 在整个请求处理完成之后执行");
    }
}