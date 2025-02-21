package org.iclass.demo.autowire;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserDao2 {
	
//	public UserDao2() {
//		log.info("UserDao2 Bean 이 만들어졌습니다.");
//		// TODO Auto-generated constructor stub
//	}
	
	public void daoTest() {
		System.out.println("스프링의 자동 주입 기능입니다.");
	}
}
