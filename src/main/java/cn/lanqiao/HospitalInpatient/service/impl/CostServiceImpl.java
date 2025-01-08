package cn.lanqiao.HospitalInpatient.service.impl;

import cn.lanqiao.HospitalInpatient.mapper.CostMapper;
import cn.lanqiao.HospitalInpatient.model.pojo.Cost;
import cn.lanqiao.HospitalInpatient.service.CostService;
import cn.lanqiao.HospitalInpatient.model.vo.CostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostServiceImpl implements CostService {
    @Autowired
    private CostMapper costMapper;

    @Override
    public List<Cost> selectAll() {
        return costMapper.selectAll();
    }

    @Override
    public List<Cost> selectByName(String name) {
        return costMapper.selectByName(name);
    }

    @Override
    public int insert(CostVo costVo) {
        List<CostVo> costVos = costMapper.selectNoId();
        for (CostVo vo : costVos) {
            if (vo.equals(costVo)) {
                return 2;
            }
        }
        return costMapper.insert(costVo);
    }

    @Override
    public int delete(int id) {
        return costMapper.delete(id);
    }

    @Override
    public int update(Cost cost) {
        return costMapper.update(cost);
    }

}
