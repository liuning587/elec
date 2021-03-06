package com.telek.elec.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.telek.elec.netty.NettyStarter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * netty初始化
 */
@Component
public class NettyInit implements ApplicationListener<ContextRefreshedEvent> {
    private ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    @Value("${netty.port}")
    private int port;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        if (applicationContext.getParent() == null) {
            singleThreadExecutor.execute(new NettyStarter(port));
        }
    }
}
