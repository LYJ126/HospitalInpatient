package cn.lanqiao.HospitalInpatient.service.impl;

import cn.lanqiao.HospitalInpatient.mapper.LoginuserMapper;
import cn.lanqiao.HospitalInpatient.pojo.Loginuser;
import cn.lanqiao.HospitalInpatient.service.LoginuserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LoginuserServiceImpl extends ServiceImpl<LoginuserMapper, Loginuser> implements LoginuserService {
}
