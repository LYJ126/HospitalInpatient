package cn.lanqiao.HospitalInpatient.controller;

import cn.lanqiao.HospitalInpatient.service.LoginuserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class LoginuserController {

    @Autowired
    private LoginuserService loginuserService;
}
