package cn.lanqiao.HospitalInpatient.mapper;

import cn.lanqiao.HospitalInpatient.model.vo.CostVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CostMapper {
    //查询所有收费信息
    @Select("select * from cost")
    List<CostVo> selectAll();

    //查询指定收费信息
    @Select("select * from cost where name = #{name}")
    List<CostVo> select(String name);

    //增加收费信息
    @Insert("insert into cost values(null, #{kebie}, #{number}, #{name}, #{xiangmu}, #{danjia}, #{shuliang}, #{jine}, #{riqi})")
    int insert(CostVo costVo);

    //删除收费信息
    @Delete("delete from cost where id = #{id}")
    int delete(int id);

    //修改收费信息
    @Update("update cost set kebie = #{kebie}, number = #{number}, name = #{name}, xiangmu = #{xiangmu}, danjia = #{danjia}, shuliang = #{shuliang}, jine = #{jine}, riqi = #{riqi} where id = #{id}")
    int update(CostVo costVo);
}
