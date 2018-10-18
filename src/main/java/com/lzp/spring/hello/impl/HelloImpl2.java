package com.lzp.spring.hello.impl;

import com.lzp.spring.hello.Hello;

public class HelloImpl2 implements Hello {

    public void sayHello() {
        System.out.println("HelloImpl2");
    }

    public void init(){
        System.out.println("init");
    }

    public void destroy(){
        System.out.println("destroy");
    }
}
