package org.iclass.beanEx;

import org.iclass.beanEx.setter.YourTestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeanExApplication2 {
// BeanExApplication 에서는 MyTestController 등 커스텀 생성자를 사용하여 객체 변수를 초기화
// 여기서 테스트하는 YourTestController 등 기본생성자를 사용했습니다.	
	public static void main(String[] args) {
		ApplicationContext  context =
		SpringApplication.run(BeanExApplication2.class, args);
		
		//사용자 요청은 컨트롤러가 처리하므로 MyTestController bean 만 가져와 메소드 실행
//		YourTestController controller =context.getBean(YourTestController.class);
		YourTestController controller 
				=(YourTestController) context.getBean("yourTestController");
		controller.test();
	}

}
