package com.lzp.spring;

import com.lzp.spring.collection.MyCollection;
import com.lzp.spring.hello.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloProgram {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

//        HelloService helloService = (HelloService) applicationContext.getBean("helloService");
//        helloService.getHello().sayHello();

//        MyCollection myCollection = (MyCollection) applicationContext.getBean("myCollection");
//        System.out.println(myCollection.toString());

//        ((ClassPathXmlApplicationContext) applicationContext).registerShutdownHook();

//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ConfigBean.class);
//        ConfigBeanO configBean = annotationConfigApplicationContext.getBean(ConfigBeanO.class);
//        System.out.println(configBean.getName());

        applicationContext.start();
        applicationContext.stop();

    }
}
