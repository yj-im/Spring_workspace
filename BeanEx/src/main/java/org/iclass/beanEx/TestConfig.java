package org.iclass.beanEx;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class TestConfig {  
// 다른 외부라이브러리에서 메소드 실행 후 리턴 결과를 빈으로 만드는 설정작업에서 활용

	// @Bean : 메소드 리턴값으로 bean 을 생성합니다.
	@Bean
	List<String> nuz(){  //bean 이 생성되고 이름은 메소드 이름과 같게 만들어집니다.
		log.info("TestConfig 의 nuz() 메소드");
		return List.of("민지","하니","다니엘","혜린","혜인");
	}
}
