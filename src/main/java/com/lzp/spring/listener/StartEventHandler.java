package com.lzp.spring.listener;

import com.sun.xml.internal.stream.events.StartElementEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * 监听ApplicationListener的start事件
 * */
public class StartEventHandler implements ApplicationListener<ContextStartedEvent> {

    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        System.out.println("ContextStartedEvent");
    }
}
