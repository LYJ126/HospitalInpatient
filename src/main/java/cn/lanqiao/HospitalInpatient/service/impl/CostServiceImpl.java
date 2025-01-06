package cn.lanqiao.HospitalInpatient.service.impl;

import cn.lanqiao.HospitalInpatient.mapper.CostMapper;
import cn.lanqiao.HospitalInpatient.pojo.Bed;
import cn.lanqiao.HospitalInpatient.service.CostService;
import cn.lanqiao.HospitalInpatient.vo.CostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostServiceImpl implements CostService {
    @Autowired
    private CostMapper costMapper;

    @Override
    public List<CostVo> selectAll() {
        return costMapper.selectAll();
    }

    @Override
    public int insert(CostVo costVo) {
        List<CostVo> costVos = costMapper.selectAll();
        for (CostVo vo : costVos) {
            if (vo.equals(costVo)) {
                return 2;
            }
        }
        return costMapper.insert(costVo);
    }

    @Override
    public int deleteBed(int id) {
        return 0;
    }

    @Override
    public int updateBed(Bed bed) {
        return 0;
    }
}
