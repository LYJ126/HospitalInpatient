package cn.lanqiao.HospitalInpatient.service;


import cn.lanqiao.HospitalInpatient.model.dto.AdminDto;
import cn.lanqiao.HospitalInpatient.model.pojo.Admin;
import cn.lanqiao.HospitalInpatient.model.vo.AdminVo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface AdminService {
    Boolean login(AdminVo adminVo);
}
