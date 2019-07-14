package org.jit.sose.service;

import com.github.pagehelper.PageInfo;
import org.jit.sose.entity.People;

import java.util.List;

/**
 * @author: Dylan.W
 * @create: 2019-07-15 00:08:36
 */
public interface PeopleService {

    void insert(People record);

    void delete(Integer id);

    Integer deleteSelection(List<Integer> idList);

    void deleteReal(Integer id);

    void update(People record);

    People selectById(Integer id);

    /**
     * 分页条件查询
     *
     * @param people   需要作为查询条件的People类
     * @param pageNum  当前页索引
     * @param pageSize 设置分页参数
     * @return PageInfo分页数据
     */
    PageInfo<People> selectPageInfo(People people, Integer pageNum, Integer pageSize);
}
