package cn.lanqiao.HospitalInpatient.mapper;

import cn.lanqiao.HospitalInpatient.model.vo.AdminVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {

    @Select("select * from admin where username = #{username} and password = #{password}")
    Boolean login(AdminVo adminVo);
}
