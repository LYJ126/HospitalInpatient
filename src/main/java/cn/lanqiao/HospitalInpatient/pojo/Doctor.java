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
  private String number;
  private String name;
  private String sex;
  private String zhicheng;
  private String zhiwu;
  private String kebie;
  private String birthtime;
  private String worktime;

}
