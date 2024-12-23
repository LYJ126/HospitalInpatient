package cn.lanqiao.HospitalInpatient.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("cost")
public class Cost {

  private long id;
  private String kebie;
  private String number;
  private String name;
  private String xiangmu;
  private String danjia;
  private String shuliang;
  private String jine;
  private String riqi;

}
