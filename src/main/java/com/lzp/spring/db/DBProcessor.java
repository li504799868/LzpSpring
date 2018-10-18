package com.lzp.spring.db;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBProcessor {

    public static void main(String[] args){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("db.xml");

        DBUtils dbUtils = (DBUtils) applicationContext.getBean("dbUtils");
//        System.out.println(dbUtils.queryAddress("001").getLocation());
//        dbUtils.create();
        dbUtils.createByXml();
    }

}
