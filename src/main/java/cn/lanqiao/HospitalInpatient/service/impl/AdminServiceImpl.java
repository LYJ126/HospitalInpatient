package cn.lanqiao.HospitalInpatient.service.impl;

import cn.lanqiao.HospitalInpatient.mapper.AdminMapper;
import cn.lanqiao.HospitalInpatient.model.dto.AdminDto;
import cn.lanqiao.HospitalInpatient.model.vo.AdminVo;
import cn.lanqiao.HospitalInpatient.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Boolean login(AdminVo adminVo) {
        Boolean login = adminMapper.login(adminVo);
        return login != null;
    }
}
