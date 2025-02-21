package org.iclass.webEx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes(names= {"userid"})	// 애트리뷰트이름 userid 는 세션에 scope 으로 저장 가져올땐 s 붙음
public class SpringSessionTestController {

	@GetMapping("setSessionAttribute")
	public String setSession(Model model) {
		model.addAttribute("userid", "소녀시대");
		return "session";
	}
	
	@GetMapping("getSessionAttribute")
	public String getSession(			// required = false 는 애트리뷰트 값이 없을수도 있을 때.
			@SessionAttribute(name="userid",required=false) String userid) {
		log.info("session userid:{}",userid);
		return "session";
	}
	@PostMapping("logout")	// 방법 2
	public String logout(SessionStatus sessionStatus) {
		// model 애트리뷰트 중에서 session 스콥에 저장된 것들을 모두 삭제
		sessionStatus.setComplete();
		return "redirect:/";
	}
	
}
