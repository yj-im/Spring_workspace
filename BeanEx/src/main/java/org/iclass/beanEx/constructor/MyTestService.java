package org.iclass.beanEx.constructor;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyTestService { // Service 는 MVC 모델2 에서 비지니스로직 실행합니다.

	//의존성
	private MyTestDao dao;
	
	// 생성자 실행시 자동으로 MyTestDao 타입 bean 을 찾아서 초기화 실행
	public MyTestService(MyTestDao dao) {
		this.dao = dao;		// 의존성 객체 초기화
		log.info("◆◆◆◆ 의존성 빈 dao 확인 : {} ◆◆◆◆", this.dao);
	}
	
	public void logicTest() {
		log.info("◆◆◆◆ 비지니스 로직이 실행 됩니다. ◆◆◆◆");
		dao.mybatis();
	}
}
