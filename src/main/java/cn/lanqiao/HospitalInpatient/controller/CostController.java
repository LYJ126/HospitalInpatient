package cn.lanqiao.HospitalInpatient.controller;

import cn.lanqiao.HospitalInpatient.service.CostService;
import cn.lanqiao.HospitalInpatient.utils.ResponseUtils;
import cn.lanqiao.HospitalInpatient.vo.CostVo;
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
            if (select == null || select.isEmpty()){// 增加空列表检查
                //查询为空
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
}
