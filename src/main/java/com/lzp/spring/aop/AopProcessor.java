package com.lzp.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopProcessor {

    public static void main(String[] args){

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("aopBeans.xml");

        Student student = (Student) applicationContext.getBean("student");
//        student.getAge();
        student.getName();
//        student.getName();
//        student.printThrowException();

    }
}
