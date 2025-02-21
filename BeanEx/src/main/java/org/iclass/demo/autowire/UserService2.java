package org.iclass.demo.autowire;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Component
public class UserService2 {
	
	
	private UserDao2 userDao;

//	public UserService2(UserDao2 userDao) {
//		log.info("UserService2 Bean 이 만들어졌습니다.");
//		this.userDao = userDao;
//	}
	
	public void logicTest() {
		System.out.println(userDao);
		userDao.daoTest();
	}

}
