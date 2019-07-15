package org.jit.sose.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.jit.sose.entity.People;
import org.jit.sose.mapper.PeopleMapper;
import org.jit.sose.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Dylan.W
 * @create: 2019-07-15 00:11:17
 */
@Slf4j
@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    PeopleMapper peopleMapper;

    @Override
    public void insert(People record) {
        peopleMapper.insert(record);
    }

    @Override
    public void delete(Integer id) {
        peopleMapper.delete(id);
    }

    @Override
    public Integer deleteSelection(List<Integer> idList) {
        return peopleMapper.deleteSelection(idList);
    }

    @Override
    public void deleteReal(Integer id) {
        peopleMapper.deleteReal(id);
    }

    @Override
    public void update(People record) {
        peopleMapper.update(record);
    }

    @Cacheable(cacheNames = "people") //指定存储缓存组件的名字
    @Override
    public People selectById(Integer id) {
        log.debug("缓存测试：" + id);
        return peopleMapper.selectById(id);
    }

    @Override
    public PageInfo<People> selectPageInfo(People people, Integer pageNum, Integer pageSize) {
        // 设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        // 查询集合
        List<People> peopleList = peopleMapper.listByPeople(people);
        PageInfo<People> pageInfo = new PageInfo<>(peopleList);
        return pageInfo;
    }
}
