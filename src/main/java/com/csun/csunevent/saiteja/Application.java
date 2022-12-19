package com.csun.csunevent.saiteja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.csun.csunevent.saiteja")
public class Application {

	public static void main(String[] args) {
		//WebSocketConfiguration ws=new WebSocketConfiguration();
		SpringApplication.run(Application.class, args);

	}

}
