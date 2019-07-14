package org.jit.sose.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class People {
    public People() {
    }

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private Integer id;

    private String name;

    private Integer age;

    private Double weight;

    private Date birthday;

    private BigDecimal price;

    private Timestamp lunchDate;

    private Date dinnerDate;

    private Boolean isDelete;

    private Timestamp updateDate;

    private Timestamp createdDate;

}