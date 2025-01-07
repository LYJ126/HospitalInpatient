package cn.lanqiao.HospitalInpatient.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorVO {
    private Integer id;
    private String number;
    private String name;
    private String sex;
    private String zhicheng;
    private String zhiwu;
    private String kebie;
    private String birthtime;
    private String worktime;
}
