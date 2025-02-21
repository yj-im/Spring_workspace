package org.iclass.beanEx.constructor;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyTestDao {   // Dao 는 MVC 모델2 에서 SQL 실행합니다.

    public MyTestDao() {
    	log.info("★★★★ MyTestDao bean 이 생성됩니다.★★★★");
    }
	
	public void mybatis() {
		log.info("★★★★ MyTestDao  : mybatis 메소드 실행 ★★★★ ");
	}
}
