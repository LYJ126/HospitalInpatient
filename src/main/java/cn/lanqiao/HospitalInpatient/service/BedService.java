package cn.lanqiao.HospitalInpatient.service;

import cn.lanqiao.HospitalInpatient.model.pojo.Bed;

import java.util.List;

public interface BedService {
    //查询所有病床信息
    List<Bed> selectAll();

    //新增病床信息
    int addBed(Bed bed);

    //删除病床信息
    int deleteBed(int id);

    //修改病床信息
    int updateBed(Bed bed);
}
