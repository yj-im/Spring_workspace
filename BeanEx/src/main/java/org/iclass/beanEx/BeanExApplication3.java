package org.iclass.beanEx;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class BeanExApplication3 {
	
	public static void main(String[] args) {
		SpringApplication.run(BeanExApplication3.class, args);
		
		@SuppressWarnings("resource")
		ApplicationContext context =
				new AnnotationConfigApplicationContext(TestConfig.class);
		
//		List<String> temp =(List<String>) context.getBean("nuz");
		@SuppressWarnings("unchecked")
		List<String> temp =context.getBean(java.util.List.class);
		log.info("메소드로 만들어진 bean : {}, {}",temp, temp.getClass().getName());
		
		
		
	}

}
