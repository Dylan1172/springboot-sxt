package org.jit.sose.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.jit.sose.entity.People;
import org.jit.sose.service.PeopleService;
import org.jit.sose.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Dylan.W
 * @create: 2019-07-15 00:35:39
 */
@Slf4j
@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    PeopleService peopleService;

    @GetMapping("/log")
    public void log() {
        log.trace("***trace***");
        log.debug("***debug***");
        log.info("***info***");
        log.warn("***warn***");
        log.error("***error***");
    }

    @PostMapping("/insert")
    public void insert(@RequestBody People people) {
        peopleService.insert(people);
    }

    @PostMapping("/delete")
    public void insert(@RequestBody Integer id) {
        peopleService.delete(id);
    }

    @PostMapping("/deleteSelection")
    public Integer deleteSelection(@RequestBody List<Integer> idList) {
        return peopleService.deleteSelection(idList);
    }

    @PostMapping("/update")
    public void update(@RequestBody People people) {
        peopleService.update(people);
    }

    @PostMapping("/selectPageInfo")
    public PageInfo<People> selectPageInfo(@RequestBody String str) {
        // 使用fastjson转为json对象
        JSONObject strj = JSON.parseObject(str);
        People people = new People();

        // 过滤查询条件
        String name = strj.getString("name");
        String age = strj.getString("age");
        people.setName(StringUtil.isEmpty(name) ? null : name);
        people.setAge(StringUtil.isEmpty(age) ? null : strj.getIntValue("age"));

        // 当前页码
        int pageNum = strj.getIntValue("pageNum");
        // 页面大小
        int pageSize = strj.getIntValue("pageSize");
        return peopleService.selectPageInfo(people, pageNum, pageSize);
    }

    @PostMapping("/selectById")
    public People selectById(@RequestBody Integer id) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("msg", "query success");
//        map.put("obj", peopleService.selectById(id));
//        return map;
        return peopleService.selectById(id);
    }

}
