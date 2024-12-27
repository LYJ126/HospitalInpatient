package cn.lanqiao.HospitalInpatient.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {

  private long id;
  private String username;
  private String password;

}
