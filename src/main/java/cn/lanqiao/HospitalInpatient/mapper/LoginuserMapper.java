package cn.lanqiao.HospitalInpatient.mapper;

import cn.lanqiao.HospitalInpatient.pojo.Loginuser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginuserMapper {

    Loginuser selectAll();

}
