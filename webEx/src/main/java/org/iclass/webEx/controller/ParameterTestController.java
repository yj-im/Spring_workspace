package org.iclass.webEx.controller;
import org.iclass.webEx.dto.TestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ParameterTestController {
	
	@GetMapping("list")
	// JSP 에서는 파라미터는 무조건 String -> 필요시 정수로 변환
	public String list(String name, int age) {
		log.info("이름 : {} ",name);
		log.info("나이 : {} ",age);
		return null;			//템플릿 파일명이 없으면 기본값이 url -> list.html
	}
	
	@GetMapping("listA")
	// 파라미터 중 int age 는 문자열을 정수로 변환하여 저장. 값이 없으면 null -> 오류
	//	-> 파라미터의 기본값 설정
	public String listA(String name, @RequestParam(defaultValue = "0") int age, 
						String address, String gender) {
		log.info("파라미터 : {} , {} , {} , {} " , name,age,address,gender);
		return "list";
	}
	
	@GetMapping("listB")
	// 파라미터가 많을 때 , 변수를 각각 선언하는 것은 비효율적. DTO 클래스를 활용
	public String listB(TestDto dto) {
		log.info("파라미터 dto : {} " , dto);
		log.info("파라미터 : {} , {} , {} , {} " , 
					dto.getName(),dto.getAge(),dto.getAddress(),dto.getGender());
		return "list";
	}
	
	@PostMapping("regist")
	public String regist(TestDto dto) {
		log.info("Post 요청 TestDto : {}",dto);
		
		return "redirect:/";
	}
	
	
	
	@GetMapping("write")
	public String write() {
		return "write";
	}
	
	@PostMapping("write")
	public String save(String title, String content) {
	// 메소드의 인자 변수명 title, content 는 
	// View 에서 서버에 보낸 파라미터를 저장합니다.	
		log.info("post 요청을 처리하고 context path(/) 로 리다이렉트 합니다.");
		log.info("title : {}", title);
		log.info("content : {}", content);
		return "redirect:login";   // "redirect:URL"
	}
	

}
