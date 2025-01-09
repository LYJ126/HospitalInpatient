package cn.lanqiao.HospitalInpatient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.lanqiao.HospitalInpatient.mapper")
public class HospitalInpatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalInpatientApplication.class, args);
    }

}