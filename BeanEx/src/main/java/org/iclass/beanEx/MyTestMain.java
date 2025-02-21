package org.iclass.beanEx;

import org.iclass.beanEx.constructor.MyTestController;
import org.iclass.beanEx.constructor.MyTestDao;
import org.iclass.beanEx.constructor.MyTestService;

// Java 의 기존 방식
// Run As -> Java Application
public class MyTestMain {

	public static void main(String[] args) {
		
		// 스프링 프레임웍이 자동으로 설정해 주는 의존관계입니다.
		MyTestDao dao = new MyTestDao();
		MyTestService service = new MyTestService(dao);
		MyTestController controller = new MyTestController(service);
		// 스프링 프레임웍에서는 필요한 빈(객체)을 '자동으로 주입한다' 라고 표현합니다. 
		controller.test();
	}
}
/*
	자바에서 생성자는 new 연산으로 객체를 만들 때 실행하는 메소드 입니다.
	생성자 메소드의 이름은 클래스 이름과 같습니다.
	
	MyTestDao dao = new MyTestDao();
	
	MyTestDao(); --> 인자가 없는 기본생성자
	new MyTestService(dao); --> 인자를 전달받아 '객체의 구성요소'를 초기화하는 생성자
			       ㄴ 스프링 프레임웍에서는 자동으로 dao 타입의 bean 을 찾아서
			          MyTestService 생성자에게 전달해 줍니다.
			
*/


