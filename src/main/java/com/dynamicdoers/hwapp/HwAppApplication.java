package com.dynamicdoers.hwapp;

import com.dynamicdoers.hwapp.service.NotificationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@SpringBootApplication
public class HwAppApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ac = SpringApplication.run(HwAppApplication.class, args);
//		NotificationService.sendNotification("Application started at: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//		for(String name: ac.getBeanDefinitionNames()){
//			System.out.println(name);
//		}
	}
}
