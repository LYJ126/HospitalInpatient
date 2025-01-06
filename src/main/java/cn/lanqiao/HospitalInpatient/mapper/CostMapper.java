package cn.lanqiao.HospitalInpatient.mapper;

import cn.lanqiao.HospitalInpatient.pojo.Bed;
import cn.lanqiao.HospitalInpatient.vo.CostVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CostMapper {
    //查询所有病床信息
    @Select("select * from cost")
    List<CostVo> selectAll();
    //增加病床信息
    @Insert("insert into cost values(#{kebie}, #{number}, #{name}, #{xiangmu}, #{danjia}, #{shuliang}, #{jine}, #{riqi})")
    int insert(CostVo costVo);

    //删除病床信息
    @Update("update bed set is_delete = 1 where id = #{id}")
    int deleteBed(int id);

    //修改病床信息
    @Update("update bed set  kebie = #{kebie} , number = #{number} , cost = #{cost},state = #{state} where id = #{id}")
    int updateBed(Bed bed);
}
