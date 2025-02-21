package org.iclass.beanEx.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
@Service
public class YourTestService {
	//의존성 : 
	private YourTestDao dao;
	
	public YourTestService() {
		log.info("YourTestService 기본 생성자 실행합니다.");
	}	

	//setter
	@Autowired     //의존관계 bean 자동주입
	public void setDao(YourTestDao dao) {
		this.dao = dao;
	}
	
	public void logicTest() {
		log.info("◆◆◆◆ 비지니스 로직이 실행 됩니다. ◆◆◆◆");
		dao.mybatis();
	}
}
