package com.eports.hashmap.part1;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Company implements Serializable {

    private transient String name;

    private String desc;

    private String address;

    private Integer age;

}
