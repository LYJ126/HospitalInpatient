package cn.lanqiao.HospitalInpatient.controller;

import cn.lanqiao.HospitalInpatient.model.dto.AdminDto;
import cn.lanqiao.HospitalInpatient.utils.ResponseUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import cn.lanqiao.HospitalInpatient.model.pojo.Admin;
import cn.lanqiao.HospitalInpatient.service.AdminUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/adminUser")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/login")
    public String login(Admin admin, Model model, HttpSession session, HttpServletRequest request,
                        HttpServletResponse response) {

        // TODO MyBatisPlus实现登录功能：
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("USERNAME",admin.getUsername());
        queryWrapper.eq("PASSWORD",admin.getPassword());
        Admin user = adminUserService.getOne(queryWrapper);

        System.out.println("查询中");
        if (user == null) {
            model.addAttribute("login", "账号或密码错误");
            return "redirect:/login.html";
        } else {
            session.setAttribute("user", user);

            log.info("用户登录成功，用户名: {}", user);
            // 设置Cookie
            Cookie usernameCookie = new Cookie("adminUsername", user.getUsername());
            usernameCookie.setPath("/"); // 设置Cookie的路径为根路径
//            usernameCookie.setMaxAge(60 * 60 * 24); // 设置Cookie的过期时间为1天
            response.addCookie(usernameCookie);

            return "redirect:/index.html";
        }
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseUtils update(@RequestBody AdminDto adminDto, HttpSession session){
        // 读取键值为user的session
        Admin admin = (Admin) session.getAttribute("user");
        // 判断密码是否正确
        if (admin.getPassword().equals(adminDto.getOriginalPassword())) {
            QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("USERNAME",adminDto.getUsername());
            // 设置新密码
            admin.setPassword(adminDto.getNewPassword());
            log.info("密码修改: {}", admin);
            boolean update = adminUserService.update(admin, queryWrapper);
            if (update){
                return new ResponseUtils(200,"true", "/login.html");
            }else {
                return new ResponseUtils(500,"false");
            }
        } else {
            System.out.println("密码不匹配");
            return new ResponseUtils(500,"false");
        }
    }
}