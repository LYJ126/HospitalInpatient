package cn.lanqiao.HospitalInpatient.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("t_cms_hotel")
public class Doctor {

  private long id;
  // 编号
  private String number;
  // 姓名
  private String name;
  // 性别
  private String sex;
  // 职称
  private String zhicheng;
  // 职务
  private String zhiwu;
  // 科别
  private String kebie;
  // 出生日期
  private String birthtime;
  // 工作日期
  private String worktime;

}
