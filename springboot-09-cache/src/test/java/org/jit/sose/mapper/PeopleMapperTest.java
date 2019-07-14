package org.jit.sose.mapper;

import org.jit.sose.entity.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * PeopleMapper测试类
 *
 * @author: Dylan.W
 * @create: 2019-07-14 23:56:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PeopleMapperTest {

    @Autowired
    PeopleMapper peopleMapper;

    @Test
    public void selectById() {
        People people = peopleMapper.selectById(1);
        System.out.println(people);
    }

    @Test
    public void listByPeople() {
        List<People> peopleList = peopleMapper.listByPeople(new People(null, 16));
        for (People people : peopleList) {
            System.out.println(people);
        }
    }

}
