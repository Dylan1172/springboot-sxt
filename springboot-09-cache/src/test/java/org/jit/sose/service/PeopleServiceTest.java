package org.jit.sose.service;

import com.github.pagehelper.PageInfo;
import org.jit.sose.entity.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Dylan.W
 * @create: 2019-07-15 00:17:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PeopleServiceTest {

    @Autowired
    PeopleService peopleService;

    @Test
    public void listByPeople() {
        People condition = new People("test", null);
        PageInfo<People> pageInfo = peopleService.selectPageInfo(condition, 2, 5);
        System.out.println(pageInfo.getTotal());
        for (People people : pageInfo.getList()) {
            System.out.println(people);
        }
    }
}
