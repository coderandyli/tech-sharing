package com.eports.hashmap;

import com.google.common.collect.Maps;

import java.util.HashMap;

public class HashMapTest {


    public static void main(String[] args) {
        HashMap<String, Person> map = Maps.newHashMap();

        map.put("张三", new Person("张三", 15));
        map.put("李四", new Person("李四", 16));
        map.put("王五", new Person("王五", 17));
        map.put("赵六", new Person("赵六", 18));
        map.put("孙七", new Person("孙七", 19));
        map.put("周八", new Person("周八", 20));
        map.put("钱九", new Person("钱九", 21));
        map.put("吴十", new Person("吴十", 22));

        map.put("吴十1", new Person("吴十1", 22));
        map.put("吴十2", new Person("吴十2", 22));
        map.put("吴十3", new Person("吴十3", 22));
        map.put("吴十4", new Person("吴十4", 22));
        map.put("吴十5", new Person("吴十5", 22));


        System.out.println(map.size() + "==========" + map.toString());


        System.out.println(1 << 30);
        System.out.println(1 & 16);


    }




}
