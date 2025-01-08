package cn.lanqiao.HospitalInpatient.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author: LYJ
 * @date: 2022/11/26 16:51
 * @description: 修改密码
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDto {
    private String username;
    private String originalPassword;
    private String newPassword;
}
