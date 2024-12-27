package cn.lanqiao.HospitalInpatient.service.impl;


import cn.lanqiao.HospitalInpatient.mapper.BedMapper;
import cn.lanqiao.HospitalInpatient.pojo.Bed;
import cn.lanqiao.HospitalInpatient.service.BedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class bedServiceImpl implements BedService {
    @Autowired
    private BedMapper BedMapper;
    @Override
    public List<Bed> selectAll() {
        List<Bed> beds = BedMapper.selectAll();
        if (beds != null){
            return beds;
        }else {
            return null;
        }
    }

    //新增病床信息
    @Override
    public int addBed(Bed bed) {
            int result = BedMapper.addBed(bed);
            if (result > 0){
                //操作成功 result > 0
                return 1;
            }else {
                return 0;
            }
    }

    //删除病床信息
    @Override
    public int deleteBed(int id) {
        int result = BedMapper.deleteBed(id);
        if (result > 0) {
            //删除成功
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updateBed(Bed bed) {
        int result = BedMapper.updateBed(bed);
        if (result > 0){
            //操作成功 result > 0
            return 1;
        }else {
            return 0;
        }
    }
}
