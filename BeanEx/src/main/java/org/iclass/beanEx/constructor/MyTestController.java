package org.iclass.beanEx.constructor;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyTestController {  // Controller 는 MVC 모델2 에서 사용자 요청을 처리합니다.
	//의존성 : MyTestService 타입의 Bean(객체)이 필요하다.
	private MyTestService service;
	
	public MyTestController(MyTestService service) {
		this.service = service;
		log.info("■■■ 의존성 빈 service 확인 : {} ■■■ ", this.service);
	}
	
	public void test() {
		log.info("■■■ 사용자 요청을 처리합니다.■■■");
		service.logicTest();
	}
}
