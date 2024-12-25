package cn.lanqiao.HospitalInpatient.service.impl;

import cn.lanqiao.HospitalInpatient.mapper.LoginUserMapper;
import cn.lanqiao.HospitalInpatient.pojo.Admin;
import cn.lanqiao.HospitalInpatient.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private LoginUserMapper loginUserMapper;

    @Override
    public Admin login(Admin admin) {
        Admin result = loginUserMapper.login(admin);
//        System.out.println(admin.getUsername());
//        System.out.println(admin.getPassword());
        if (result != null) {
            return result;
        }else {
            return null;
        }
    }
}
