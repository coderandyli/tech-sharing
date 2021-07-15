package com.eports.hashmap.part1;

import lombok.Data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@Data
public class Company2 implements Externalizable {

    private String name;

    private String desc;

    private String address;

    private Integer age;


    //自定义序列化字段
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
       // out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
       // name = (String) in.readObject();
    }
}
