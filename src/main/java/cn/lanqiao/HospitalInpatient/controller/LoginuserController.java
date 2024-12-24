package cn.lanqiao.HospitalInpatient.controller;

import cn.lanqiao.HospitalInpatient.service.LoginuserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginuserController {

    @Autowired
    private LoginuserService loginuserService;

    @PostMapping("/index")
    public String login() {
        return "index.html";
    }

}
