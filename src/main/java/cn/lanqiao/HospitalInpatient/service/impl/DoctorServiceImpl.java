package cn.lanqiao.HospitalInpatient.service.impl;

import cn.lanqiao.HospitalInpatient.dto.DoctorDto;
import cn.lanqiao.HospitalInpatient.pojo.Doctor;
import cn.lanqiao.HospitalInpatient.mapper.DoctorMapper;
import cn.lanqiao.HospitalInpatient.result.PageResult;
import cn.lanqiao.HospitalInpatient.service.IDoctorService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements IDoctorService {


    }



