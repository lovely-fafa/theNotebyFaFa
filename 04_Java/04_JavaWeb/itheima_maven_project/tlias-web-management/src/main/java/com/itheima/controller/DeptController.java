package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

//    private static Logger log = LoggerFactory.getLogger(DeptController.class)

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门数据
     * @return
     */
    //@RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");
        List<Dept> dptList = deptService.list();
        return Result.success(dptList);
    }

    /**
     * 根据 id 删除部门
     * @param id
     * @return
     */
    @Log
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据 id 删除部门：{}", id);
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门：{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 修改部门
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门：{}", dept);
        deptService.update(dept);
        return Result.success();
    }

}




