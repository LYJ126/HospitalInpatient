package cn.lanqiao.HospitalInpatient.service;

import cn.lanqiao.HospitalInpatient.model.pojo.Cost;
import cn.lanqiao.HospitalInpatient.model.vo.CostVo;

import java.util.List;

public interface CostService {
    //查询所有收费信息
    List<Cost> selectAll();

    //查询指定收费信息
    List<Cost> selectByName(String name);

    //新增收费信息
    int insert(CostVo costVo);

    //删除收费信息
    int delete(int id);

    //修改收费信息
    int update(Cost cost);
}
