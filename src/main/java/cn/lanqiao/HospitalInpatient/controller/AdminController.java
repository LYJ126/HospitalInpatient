package cn.lanqiao.HospitalInpatient.controller;

import cn.lanqiao.HospitalInpatient.model.vo.AdminVo;
import cn.lanqiao.HospitalInpatient.model.vo.CostVo;
import cn.lanqiao.HospitalInpatient.utils.ResponseUtils;
import org.springframework.stereotype.Controller;
import cn.lanqiao.HospitalInpatient.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseUtils<AdminVo> login(@RequestBody AdminVo adminVO){
        try {
            Boolean login = adminService.login(adminVO);
            if (login) {
                return new ResponseUtils<>(200,"登录成功");
            }else {
                return new ResponseUtils<>(304,"用户名或密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils<>(500,"登录异常" + e.getMessage());
        }
    }
}