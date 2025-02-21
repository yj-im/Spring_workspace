package org.iclass.demo.autowire;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@AllArgsConstructor
@Slf4j
@Component
public class UserController2 {
	
	private UserService2 userService;
	
//	public UserController2(UserService2 userService) {
//		log.info("UserController2 Bean 이 만들어졌습니다.");
//		this.userService = userService;
//		log.info("userService 주입 완료 : {}",this.userService);
//	}
	
	public void test() {
		System.out.println(userService);
		userService.logicTest();
	}
	
}
