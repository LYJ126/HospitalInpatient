package cn.lanqiao.HospitalInpatient.model.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author author
 * @since 2025-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("patient")
public class Patient implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  @TableField("kebie")
  private String kebie;

  @TableField("number")
  private String number;

  @TableField("name")
  private String name;

  @TableField("sex")
  private String sex;

  @TableField("age")
  private String age;

  @TableField("bingzheng")
  private String bingzheng;

  @TableField("doctor")
  private String doctor;

  @TableField("ruyuan")
  private String ruyuan;

  @TableField("chuyuan")
  private String chuyuan;


}
