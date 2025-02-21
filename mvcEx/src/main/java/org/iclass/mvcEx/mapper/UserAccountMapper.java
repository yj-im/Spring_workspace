package org.iclass.mvcEx.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.mvcEx.dto.UserAccount;

@Mapper
public interface UserAccountMapper {
	int insert(UserAccount account);
	UserAccount selectForLogin(Map<String,String> map);
}
/*
 * Controller, Service 타입이 객체는 Bean 이라고 부릅니다. 
 * -> 스프링 컨테이너가 프로그램 실행하면 객체를 만들어주고, 필요한 곳에 자동 주입시켜준다
 * -> 인터페이스 UserAccountMapper 는 Connection, PreparedStatement 를 사용하여
 * 	  SQL 실행하는 구현체는 프레임웍이 만들고 빈도 생성합니다.
 */
