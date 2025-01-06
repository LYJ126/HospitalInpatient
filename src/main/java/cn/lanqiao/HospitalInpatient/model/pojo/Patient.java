package cn.lanqiao.HospitalInpatient.model.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("t_cms_hotel")
public class Patient {

  private long id;
  // 科别
  private String kebie;
  // 病床号
  private String number;
  // 姓名
  private String name;
  // 性别
  private String sex;
  // 年龄
  private String age;
  // 病症
  private String bingzheng;
  // 主治医生
  private String doctor;
  // 入院日期
  private String ruyuan;
  // 出院日期
  private String chuyuan;

}
