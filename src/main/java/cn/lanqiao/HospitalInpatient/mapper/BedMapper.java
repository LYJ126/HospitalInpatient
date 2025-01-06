package cn.lanqiao.HospitalInpatient.mapper;

import cn.lanqiao.HospitalInpatient.pojo.Bed;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface BedMapper {
    //查询所有病床信息
    @Select("select * from bed where is_delete = 0")
    List<Bed> selectAll();
    //增加病床信息
    @Insert("insert into bed(kebie, number, cost, state,is_delete) values(#{kebie}, #{number}, #{cost}, #{state},0)")
    int addBed(Bed bed);

    //删除病床信息
    @Update("update bed set is_delete = 1 where id = #{id}")
    int deleteBed(int id);

    //修改病床信息
    @Update("update bed set  kebie = #{kebie} , number = #{number} , cost = #{cost},state = #{state} where id = #{id}")
    int updateBed(Bed bed);
}
