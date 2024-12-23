package cn.lanqiao.HospitalInpatient.service.impl;

import cn.lanqiao.HospitalInpatient.mapper.BedMapper;
import cn.lanqiao.HospitalInpatient.pojo.Bed;
import cn.lanqiao.HospitalInpatient.service.BedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BedServiceImpl extends ServiceImpl<BedMapper, Bed> implements BedService {
}
