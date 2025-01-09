package cn.lanqiao.HospitalInpatient.controller;


import cn.lanqiao.HospitalInpatient.model.dto.PatientDto;
import cn.lanqiao.HospitalInpatient.model.pojo.Patient;
import cn.lanqiao.HospitalInpatient.result.Result;
import cn.lanqiao.HospitalInpatient.service.IPatientService;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2025-01-04
 */
@RestController
@RequestMapping("/patient")
@Slf4j
public class PatientController {
    @Autowired
    private IPatientService patientService;

    /****
     * 查询病人信息
     * @param parientDto
     * @return
     */
    @GetMapping("/getAllPatients")
    public Result<List<Patient>> select(PatientDto parientDto) {
        log.info("参数{}", parientDto);
        List<Patient> list = patientService.lambdaQuery().eq(parientDto.getName()!=null, Patient::getName, parientDto.getName()).list();
        return Result.success(list);
    }


    /***
     * 添加病人信息
     */

    @PostMapping("/add")
    public Result<String> save(@RequestBody Patient patient){
        log.info("添加病人数据参数{}", patient);
        patientService.save(patient);
        return Result.success("添加成功");
    }

    /****
     * 删除病人信息
     * @param patientId
     * @return
     */

    @DeleteMapping("/delete/{patientId}")
    public Result delete (@PathVariable Integer patientId){
        log.info("根据id删除单个数据{}",patientId);
        boolean result = patientService.removeById(patientId);
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
    public Result<Patient> getById(@PathVariable Integer id){
        log.info("根据id查询回显{}",id);
        LambdaQueryChainWrapper<Patient> patient = patientService.lambdaQuery().eq(Patient::getId, id);
        return Result.success(patient.one());
    }


    /***
     * 修改病人信息
     * @param patient
     * @return
     */
    @PutMapping("/update")
    public  Result update(@RequestBody Patient patient){
        log.info("修改病人信息{}",patient);
        //根据id来修改数据
        boolean result = patientService.updateById(patient);
        if (result){
            return Result.success("修改成功");
        }else {
            return Result.error("修改失败");
        }
    }
}
