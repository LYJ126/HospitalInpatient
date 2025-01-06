package cn.lanqiao.HospitalInpatient.service;

import cn.lanqiao.HospitalInpatient.pojo.Bed;
import cn.lanqiao.HospitalInpatient.vo.CostVo;

import java.util.List;

public interface CostService {
    //查询所有病床信息
    List<CostVo> selectAll();

    //新增病床信息
    int insert(CostVo costVo);

    //删除病床信息
    int deleteBed(int id);

    //修改病床信息
    int updateBed(Bed bed);
}
