package org.iclass.webEx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;

// web mvc 에서는 controller 가 url 요청을 받아서  
// 해당되는 view 를 지정합니다. Controller 와 View 의 매핑.
@Slf4j
@Controller
public class TestController {
	// Get 요청 처리. URL(servlet path) 은 join
	@GetMapping("join")
	public String join() {
		return "join";   //join.html 파일 지정 (View)
	}

	@GetMapping("login")
	public String login() {
		return "login";  //login.html 파일 지정 (View)
	}
	
	
	
}
