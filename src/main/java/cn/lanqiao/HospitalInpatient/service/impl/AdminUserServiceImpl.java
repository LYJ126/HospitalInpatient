package cn.lanqiao.HospitalInpatient.service.impl;

import cn.lanqiao.HospitalInpatient.mapper.AdminUserMapper;
import cn.lanqiao.HospitalInpatient.model.pojo.Admin;
import cn.lanqiao.HospitalInpatient.service.AdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, Admin> implements AdminUserService {
}
