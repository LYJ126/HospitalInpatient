package cn.lanqiao.HospitalInpatient.service.impl;

import cn.lanqiao.HospitalInpatient.mapper.AdminUserMapper;
import cn.lanqiao.HospitalInpatient.pojo.Admin;
import cn.lanqiao.HospitalInpatient.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public Admin login(Admin admin) {
        Admin result = adminUserMapper.login(admin);
        if (result != null) {
            return result;
        }else {
            return null;
        }
    }
}
