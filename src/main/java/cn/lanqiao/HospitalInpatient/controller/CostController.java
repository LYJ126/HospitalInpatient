package cn.lanqiao.HospitalInpatient.controller;

import cn.lanqiao.HospitalInpatient.service.CostService;
import cn.lanqiao.HospitalInpatient.utils.ResponseUtils;
import cn.lanqiao.HospitalInpatient.model.vo.CostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costs")
public class CostController {
    @Autowired
    private CostService costService;

    @GetMapping
    public ResponseUtils<List<CostVo>> selectAll(){
        try {
            List<CostVo> select = costService.selectAll();
            if (select == null || select.isEmpty()){
                // 增加空列表检查
                return new ResponseUtils<>(304,"暂无查询数据");
            }else {
                //查询成功
                return new ResponseUtils<>(200,"查询成功",select);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils<>(500,"查询收费信息失败：" + e.getMessage());
        }
    }

    @GetMapping("{name}")
    public ResponseUtils<List<CostVo>> select(@PathVariable String name){
        try {
            List<CostVo> select = costService.select(name);
            if (select == null || select.isEmpty()){
                // 增加空列表检查
                return new ResponseUtils<>(304,"暂无查询数据");
            }else {
                //查询成功
                return new ResponseUtils<>(200,"查询成功",select);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils<>(500,"查询收费信息失败：" + e.getMessage());
        }
    }

    @PostMapping
    public ResponseUtils<CostVo> insert(@RequestBody CostVo costVo){
        try {
            int insert = costService.insert(costVo);
            if (insert == 1){
                return new ResponseUtils<>(200,"添加成功");
            } else if (insert == 2) {
                return new ResponseUtils<>(304,"该收费信息已存在");
            } else {
                return new ResponseUtils<>(400,"添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils<>(500,"添加收费信息功能有误" + e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseUtils<CostVo> delete(@PathVariable int id){
        try {
            int delete = costService.delete(id);
            if (delete > 1){
                return new ResponseUtils<>(200,"删除成功");
            } else {
                return new ResponseUtils<>(400,"删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils<>(500,"删除收费信息功能有误" + e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseUtils<CostVo> update(@PathVariable int id){
        try {
            int delete = costService.delete(id);
            if (delete > 1){
                return new ResponseUtils<>(200,"删除成功");
            } else {
                return new ResponseUtils<>(400,"删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils<>(500,"删除收费信息功能有误" + e.getMessage());
        }
    }
}
