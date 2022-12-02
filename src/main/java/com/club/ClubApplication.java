package com.club;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubApplication.class, args);
		
		//스케줄러 
		Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
				System.out.println("Test Running: " + new java.util.Date());
            }
        }, 0, 10000);//10초마다
	}

}
