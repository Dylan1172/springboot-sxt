package org.jit.sose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    DataSource dataSource;

    /**
     * 测试druid数据源
     *
     * @throws Exception
     */
    @Test
    public void contextLoads() throws Exception {
        System.out.println("数据源：" + dataSource.getClass());
        // 获取sql连接
        Connection connection = dataSource.getConnection();
        System.out.println("数据库连接：" + connection);
        connection.close();
    }



}
