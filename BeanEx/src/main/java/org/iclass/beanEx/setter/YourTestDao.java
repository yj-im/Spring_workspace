package org.iclass.beanEx.setter;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
@Repository
public class YourTestDao {
	
	public YourTestDao() {
		log.info("YourTestDao 기본 생성자 실행합니다.");
	}

	public void mybatis() {
		log.info("★★★★ YourTestDao  : mybatis 메소드 실행 ★★★★ ");
	}
}
