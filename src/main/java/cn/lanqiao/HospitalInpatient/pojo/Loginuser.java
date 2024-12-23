package cn.lanqiao.HospitalInpatient.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("loginuser")
public class Loginuser {

  private long id;
  private String loginname;
  private String loginpwd;

}
