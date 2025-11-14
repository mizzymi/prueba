package com.reimii.prueba.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class StartupListener {

    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() {
        System.out.println("Application is ready");
        System.out.println("http://localhost:8080/");
    }
}
