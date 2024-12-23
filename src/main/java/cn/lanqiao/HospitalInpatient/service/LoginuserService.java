package cn.lanqiao.HospitalInpatient.service;

import cn.lanqiao.HospitalInpatient.pojo.Loginuser;

public interface LoginuserService {

    //根据用户名和密码查询用户信息
    Loginuser login(String username, String password);
}
