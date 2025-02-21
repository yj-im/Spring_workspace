package org.iclass.demo;

import org.iclass.demo.autowire.UserController2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// 스프링 부트 프로젝트는 여기서 실행해야 합니다. Run As -> Spring Boot App
@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		ApplicationContext context = 
		SpringApplication.run(DemoApplication.class, args);
		
// 아래 설정은 수동이므로 스프링 부트에서는 사용하지 않음.		
//		AbstractApplicationContext context =
//				new AnnotationConfigApplicationContext("설정파일클래스이름");	
		
		System.out.println("[[[스프링 컨테이너에 저장된 스프링빈의 이름 확인]]]");
		String[] beans = context.getBeanDefinitionNames();
		for (String bean : beans) {
			System.out.println("    - 빈 이름 : " + bean);
		}
		//Bean 저장소(스프링 컨테이너)에서 UserController2 타입의 빈을 가져옵니다.
		UserController2 controller = context.getBean(UserController2.class);
		controller.test();
		
//		context.close();
	}
	

}
