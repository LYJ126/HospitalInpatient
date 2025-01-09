package cn.lanqiao.HospitalInpatient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("cn.lanqiao.HospitalInpatient.mapper")
@ComponentScan(basePackages = {"cn.lanqiao.HospitalInpatient.config"})
public class HospitalInpatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalInpatientApplication.class, args);
    }

}