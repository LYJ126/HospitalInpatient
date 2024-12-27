package cn.lanqiao.HospitalInpatient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.lanqiao.HospitalInpatient.mapper")
//扫描mapper接口
public class HospitalInpatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalInpatientApplication.class, args);
    }

}