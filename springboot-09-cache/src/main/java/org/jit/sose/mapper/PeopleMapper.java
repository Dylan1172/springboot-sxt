package org.jit.sose.mapper;

import org.jit.sose.entity.People;

import java.util.List;

public interface PeopleMapper {

    void insert(People record);

    void delete(Integer id);

    Integer deleteSelection(List<Integer> idList);

    void deleteReal(Integer id);

    void update(People record);

    People selectById(Integer id);

    List<People> listByPeople(People people);

}