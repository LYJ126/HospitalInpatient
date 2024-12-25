package cn.lanqiao.HospitalInpatient.controller;

import cn.lanqiao.HospitalInpatient.pojo.Admin;
import cn.lanqiao.HospitalInpatient.service.LoginUserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class LoginUserController {

    @Autowired
    private LoginUserService loginUserService;

    @PostMapping("/login")
    public void login(@RequestParam String username, @RequestParam String password, Admin admin, HttpServletResponse response) {
        try {
            admin.setUsername(username);
            admin.setPassword(password);
            Admin login = loginUserService.login(admin);
            if (login != null) {
                System.out.println("登录成功");
                response.sendRedirect("/index.html");
            }else {
                System.out.println("登录失败");
                response.sendRedirect("/login.html");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
