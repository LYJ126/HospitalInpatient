package cn.lanqiao.HospitalInpatient.service.impl;

import cn.lanqiao.HospitalInpatient.pojo.Loginuser;
import cn.lanqiao.HospitalInpatient.service.LoginuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginuserServiceImpl implements LoginuserService {

    @Autowired
    private LoginuserService loginuserService;


    @Override
    public Loginuser login(String username, String password) {
        return null;
    }
}
