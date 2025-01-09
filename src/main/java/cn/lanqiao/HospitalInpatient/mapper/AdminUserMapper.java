package cn.lanqiao.HospitalInpatient.mapper;

import cn.lanqiao.HospitalInpatient.model.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminUserMapper extends BaseMapper<Admin> {
}
