package org.iclass.beanEx;


import org.iclass.beanEx.constructor.MyTestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeanExApplication {

	public static void main(String[] args) {
		ApplicationContext  context =
		SpringApplication.run(BeanExApplication.class, args);
		
		//사용자 요청은 컨트롤러가 처리하므로 MyTestController bean 만 가져와 메소드 실행
		MyTestController controller =context.getBean(MyTestController.class);
		controller.test();
	}

}
