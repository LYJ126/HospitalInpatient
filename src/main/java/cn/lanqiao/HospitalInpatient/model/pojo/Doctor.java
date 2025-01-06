package cn.lanqiao.HospitalInpatient.model.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("doctor")
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

//    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("number")
    private String number;

    @TableField("name")
    private String name;

    @TableField("sex")
    private String sex;

    @TableField("zhicheng")
    private String zhicheng;

    @TableField("zhiwu")
    private String zhiwu;

    @TableField("kebie")
    private String kebie;

    @TableField("birthtime")
    private String birthtime;

    @TableField("worktime")
    private String worktime;


}
