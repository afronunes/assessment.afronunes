package com.enterprisealumni.assessment.afronunes.controller.bootstrap;

import com.enterprisealumni.assessment.afronunes.controller.HostController;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class HostBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final HostController fileProcessController;

    public HostBootstrap(HostController fileProcessController) {
        this.fileProcessController = fileProcessController;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        System.out.println("aaaaaaaaaaaaaaaaa" + fileProcessController.getHostsFromFile("Coding_Demo_Data.txt"));

    }
}
