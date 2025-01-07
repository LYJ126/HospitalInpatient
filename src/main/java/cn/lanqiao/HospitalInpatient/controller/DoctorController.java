package cn.lanqiao.HospitalInpatient.controller;


import cn.lanqiao.HospitalInpatient.model.dto.DoctorDto;
import cn.lanqiao.HospitalInpatient.model.pojo.Doctor;
import cn.lanqiao.HospitalInpatient.result.Result;
import cn.lanqiao.HospitalInpatient.service.IDoctorService;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/doctor")
@Slf4j
public class DoctorController {


    @Autowired
    private IDoctorService iDoctorService;
    /***
     *数据查询
     */

    @GetMapping("/selectDoctor")
    public Result<List<Doctor>> select(DoctorDto doctorDto) {
        List<Doctor> list = iDoctorService.lambdaQuery().eq(doctorDto.getName()!=null,Doctor::getName, doctorDto.getName()).list();
        return Result.success(list);
    }


    /***
     * 添加数据
     */
    @PostMapping("/add")
    public Result<String> save(@RequestBody Doctor doctor){
        log.info("添加医生数据参数{}", doctor);
        iDoctorService.save(doctor);
        return Result.success("添加成功");
    }

    /***
     * 根据id删除数据
     */

    @DeleteMapping("/delete/{id}")
    public Result delete (@PathVariable Integer id){
        log.info("根据id删除单个数据{}",id);
        boolean result = iDoctorService.removeById(id);
        if (result){
            return Result.success("删除成功");
        }else {
            return Result.error("删除失败");
        }
    }


    /***
     * 查询回显
     */

    @GetMapping("/getById/{id}")
    public Result<Doctor> getById(@PathVariable Integer id){
        log.info("根据id查询回显{}",id);
        LambdaQueryChainWrapper<Doctor> doctor = iDoctorService.lambdaQuery().eq(Doctor::getId, id);
        return Result.success(doctor.one());
    }


    @PutMapping("/update")
    public  Result update(@RequestBody Doctor doctor){
        log.info("修改医生信息{}",doctor);
        //根据id来修改数据
        boolean result = iDoctorService.updateById(doctor);
        if (result){
            return Result.success("修改成功");
        }else {
            return Result.error("修改失败");
        }
    }
}
