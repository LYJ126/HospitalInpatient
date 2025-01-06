package cn.lanqiao.HospitalInpatient.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CostVo {
    // 科别
    private String kebie;
    // 病床号
    private String number;
    // 姓名
    private String name;
    // 收费项目
    private String xiangmu;
    // 单价
    private String danjia;
    // 数量
    private String shuliang;
    // 花销
    private String jine;
    // 日期
    private String riqi;
}
