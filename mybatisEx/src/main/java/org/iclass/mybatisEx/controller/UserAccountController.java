package org.iclass.mybatisEx.controller;

import java.util.HashMap;
import java.util.Map;

import org.iclass.mybatisEx.dto.UserAccount;
import org.iclass.mybatisEx.mapper.UserAccountMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserAccountController {
	private UserAccountMapper accountMapper;
	
	public UserAccountController(UserAccountMapper accountMapper) {
		this.accountMapper=accountMapper;
	}
	
	@GetMapping("login")
	public String login() {   // 로그인 화면 GET 요청
		return "login";    //login.html : form 과 input,button
	}
	
	@PostMapping("login")
	public String login(String userid, String password,RedirectAttributes reAttr) {
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("password", password);
		UserAccount account = accountMapper.selectForLogin(map);
		log.info("login 계정 정보 : {} ", account);
		
		if(account != null) {
			return "redirect:/";
		}else {  //로그인 실패
			reAttr.addFlashAttribute("fail", "y");
			return "redirect:login";
		}
		    //index.html : INDEX 제목만 작성하세요.
	}

}
