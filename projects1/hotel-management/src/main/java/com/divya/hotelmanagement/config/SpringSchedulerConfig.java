package com.divya.hotelmanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SpringSchedulerConfig {

    //every day 3:16 pm
    @Scheduled(cron = "0 16 15 * * ?")
//    every day 3:00 am
//    @Scheduled(cron = "0 0 3 * * ?")
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
    }
}
