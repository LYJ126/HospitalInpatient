package cn.lanqiao.HospitalInpatient.controller;

import cn.lanqiao.HospitalInpatient.model.pojo.Bed;
import cn.lanqiao.HospitalInpatient.service.BedService;
import cn.lanqiao.HospitalInpatient.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bed")
@CrossOrigin  // 添加跨域注解
public class BedController {
    @Autowired
    private BedService bedService;
    //查询所有病床信息
    @GetMapping("/selectBed")
    public ResponseUtils select(){
        try {
            List<Bed> beds = bedService.selectAll();
            System.out.println(beds);
            if (beds == null || beds.isEmpty()){// 增加空列表检查
                //查询为空
                return new ResponseUtils(500,"查询失败");
            }else {
                //查询成功
                return new ResponseUtils(200,"查询成功",beds);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400,"查询病床信息失败：" + e.getMessage());
        }
    }

    //增加病床信息
    @PostMapping("/addBed")
    public ResponseUtils addBed(@RequestBody Bed bed){
        System.out.println(bed);
        try {
            int result = bedService.addBed(bed);
            if (result == 1){
                return new ResponseUtils(200,"新增成功");
            }else {
                return new ResponseUtils(500,"新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400,"新增异常"+ e.getMessage());
        }
    }

    //删除病床信息
    @DeleteMapping("/deleteBed/{id}")
    public ResponseUtils delete(@PathVariable Integer id){
        try {
            int result = bedService.deleteBed(id);
            if (result == 1){
                //删除成功
                return new ResponseUtils(200,"删除成功");
            }else {
                return new ResponseUtils(500,"删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400,"删除异常"+ e.getMessage());
        }
    }

    //修改病床信息
    @PostMapping("/updateBed")
    public ResponseUtils update(@RequestBody Bed bed){
        try {
            int result = bedService.updateBed(bed);
            if (result == 1){
                return new ResponseUtils(200,"修改成功");
            }else {
                return new ResponseUtils(500,"修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400,"修改异常");
        }
    }
}



































