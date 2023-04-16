package com.divya.springschedulerdemo;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class SpringSchedulerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSchedulerDemoApplication.class, args);
	}

}
