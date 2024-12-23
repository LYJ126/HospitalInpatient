package cn.lanqiao.HospitalInpatient.pojo;

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
  private String kebie;
  private String number;
  private String name;
  private String sex;
  private String age;
  private String bingzheng;
  private String doctor;
  private String ruyuan;
  private String chuyuan;

}
