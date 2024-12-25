package cn.lanqiao.HospitalInpatient.mapper;

import cn.lanqiao.HospitalInpatient.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginUserMapper {

    @Select("select * from admin where username = #{username} and password = #{password}")
    Admin login(Admin admin);
}
