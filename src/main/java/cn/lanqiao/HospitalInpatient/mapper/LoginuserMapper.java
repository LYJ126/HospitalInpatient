package cn.lanqiao.HospitalInpatient.mapper;

import cn.lanqiao.HospitalInpatient.pojo.Loginuser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginuserMapper extends BaseMapper<Loginuser> {
}
