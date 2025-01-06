package cn.lanqiao.HospitalInpatient.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import cn.lanqiao.HospitalInpatient.pojo.Admin;
import cn.lanqiao.HospitalInpatient.service.AdminUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/adminUser")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/login")
    public String login(Admin admin, Model model, HttpSession session, HttpServletRequest request,
                        HttpServletResponse response) {

        // TODO 实现登录功能：
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("USERNAME",admin.getUsername());
        queryWrapper.eq("PASSWORD",admin.getPassword());
        Admin user = adminUserService.getOne(queryWrapper);

        System.out.println("查询中");
        if (user == null) {
            model.addAttribute("message", "账号或密码错误");
            return "redirect:/login.html";
        } else {
            session.setAttribute("user", user);

            log.info("用户登录成功，用户名: {}", user);
            // 设置Cookie
            Cookie usernameCookie = new Cookie("adminUsername", user.getUsername());
//            usernameCookie.setMaxAge(60 * 60 * 24); // 设置Cookie的过期时间为1天
            usernameCookie.setPath("/"); // 设置Cookie的路径为根路径
            response.addCookie(usernameCookie);

            return "redirect:/index.html";
        }
    }
}