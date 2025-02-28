package org.iclass.mvcEx.controller;

import org.iclass.mvcEx.dto.UserAccount;
import org.iclass.mvcEx.service.UserAccountService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
public class UserAccountController {
	private UserAccountService service;
	

	
	
	@GetMapping("/login")
	public String login() {
		return "login";		// login.html 을 보여줘
	}
	
	
	@PostMapping("/login")
	public String action(String userid, String password, 
				HttpSession session, RedirectAttributes reAttr) {
		
		UserAccount account=service.login(userid,password);
		log.info("login 계정 정보 : {}", account);
		
		if(account !=null) {
			session.setAttribute("account", account);
			return "redirect:/";
		}else {	// 로그인 실패
			reAttr.addFlashAttribute("fail","y");
					// ㄴ login.html (화면) 으로 직접 전달하는 값
		
		return "redirect:login";
	}
}
	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	
	@PostMapping("/join")
	// 파라미터가 많을 때 , 변수를 각각 선언하는 것은 비효율적. DTO 클래스를 활용
	public String list(UserAccount dto) {
		log.info("파라미터 dto : {} " , dto);
		log.info("파라미터 : {} , {} , {} , {}, {} " , 
					dto.getUserid(),dto.getUsername(),dto.getPassword(),dto.getBirth(), dto.getGender(), dto.getEmail());
		
		return "redirect:/";
	}

@GetMapping("/logout")
public String logout(HttpSession session,RedirectAttributes reAttr) {
	session.invalidate();
	reAttr.addFlashAttribute("message", "로그 아웃 했습니다");
	return "redirect:/";	// context path 라고 부르고 화면은 index.html

}
}
