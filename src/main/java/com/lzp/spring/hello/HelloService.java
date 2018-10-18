package com.lzp.spring.hello;

public class HelloService {

    private Hello hello;

    public HelloService() {
    }

    public HelloService(Hello hello) {
        this.hello = hello;
    }

    public Hello getHello() {
        return hello;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }
}
