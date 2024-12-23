package cn.lanqiao.HospitalInpatient.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LYJ
 * @Date: 2020/12/3 10:41
 * 响应工具类
 */
@Data // get和 set方法
@AllArgsConstructor // 有参构造
@NoArgsConstructor // 无参构造
public class ResponseUtils<T> {
    private Integer code;
    private String message;
    private T data;

    public ResponseUtils(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseUtils(Integer code){
        this.code = code;
    }
}
