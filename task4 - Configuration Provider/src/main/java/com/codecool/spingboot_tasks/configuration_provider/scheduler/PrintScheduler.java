package com.codecool.spingboot_tasks.configuration_provider.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PrintScheduler {

    private final Logger log = LoggerFactory.getLogger(PrintScheduler.class);

    @Scheduled(cron = "*/15 * * * * *")
    public void print(){
        log.info("Przetwarzanie");
    }
}
