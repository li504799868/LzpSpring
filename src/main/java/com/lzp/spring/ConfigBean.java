package com.lzp.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过注解形式，配置bean， 此文件相当于beans.xml
 * */
@Configuration
public class ConfigBean {

    /**
     * 通过@Bean注解表示创建bean的方法，并且bean的id就是方法名
     * */
    @Bean
    public ConfigBeanO configBeanO(){
        return new ConfigBeanO();
    }


}
