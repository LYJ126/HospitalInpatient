package cn.lanqiao.HospitalInpatient.service;

import cn.lanqiao.HospitalInpatient.model.vo.CostVo;

import java.util.List;

public interface CostService {
    //查询所有收费信息
    List<CostVo> selectAll();

    //查询指定收费信息
    List<CostVo> select(String name);

    //新增收费信息
    int insert(CostVo costVo);

    //删除收费信息
    int delete(int id);

    //修改收费信息
    int update(CostVo costVo);
}
