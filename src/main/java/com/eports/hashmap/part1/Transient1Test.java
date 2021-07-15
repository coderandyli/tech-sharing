package com.eports.hashmap.part1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *@author liang_shi
 *@date 2021/7/12 10:16
 *@description Company
 */
public class Transient1Test {

    public static void main(String[] args) throws Exception {
        Company company = new Company();
        company.setName("E-PORTS");
        company.setAddress("上海");
        company.setDesc("易船代");
        company.setAge(100);
        System.out.println(company);

        // 将company对象写入磁盘文件(序列化)
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D://company.txt"));
        oos.writeObject(company);
        oos.close();

        // 从磁盘文件读取student对象(反序列化)
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D://company.txt"));
        company = (Company) ois.readObject();
        System.out.println(company);

    }
}
