package org.iclass.webEx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes(names= {"userid"})
public class SessionTestController {
	// request 객체를 이용하여 session 을 만드는 기존방식
	// 테스트할때 로그아웃은
	// session 삭제는 미구현이므로 개발자도구에서 JSESSIONID 쿠키를 삭제하세요
	
	@GetMapping("setSession")
	public String setSession(HttpServletRequest request, Model model) {
		HttpSession session=request.getSession();
		session.setAttribute("username", "gilDD");	// 현재 세션이 유지되는 동안 저장한 값
		model.addAttribute("username","트와이스");	// session.html 에만 전달하도록 저장한 값	
		return "session";	// session.html
	}
	@GetMapping("getSession")
	public String getSession(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		log.info("session username : {}",username);
		return "session"; // session.html
	}
	
	@GetMapping("logout")	// 방법 1
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("testSession")
	public String test(@SessionAttribute(name="userid",required=false)
									String userid) {
		log.info("testSession userid : {}",userid);
		return "session";
	}
}
