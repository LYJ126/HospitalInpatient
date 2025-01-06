package cn.lanqiao.HospitalInpatient.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
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
