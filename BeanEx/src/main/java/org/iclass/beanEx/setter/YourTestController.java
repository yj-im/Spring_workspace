package org.iclass.beanEx.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
@Controller
public class YourTestController {
	//의존성
	private YourTestService service;
	
	public YourTestController() {
		log.info("YourTestController 기본 생성자 실행합니다.");
	}
	
	//setter 
	@Autowired     //의존관계 bean 자동주입
	public void setService(YourTestService service) {
		this.service = service;
	}
	
	public void test() {
		log.info("■■■ 사용자 요청을 처리합니다.■■■");
		service.logicTest();
	}
	
	
}
