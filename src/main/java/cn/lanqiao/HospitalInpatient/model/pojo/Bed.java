package cn.lanqiao.HospitalInpatient.model.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("bed")
public class Bed {
  // ID
  private Integer id;
  // 科别
  private String kebie;
  // 病床号
  private String number;
  // 花销
  private String cost;
  // 使用状态
  private String state;
  private long isDelete;
}
