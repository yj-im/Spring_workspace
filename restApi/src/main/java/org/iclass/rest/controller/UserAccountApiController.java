package org.iclass.rest.controller;

import java.util.List;

import org.iclass.rest.dto.UserAccount;
import org.iclass.rest.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RequiredArgsConstructor
@RestController
@Slf4j
public class UserAccountApiController {
	private final UserAccountService service;
	
	@GetMapping("/account")
	public ResponseEntity<List<UserAccount>> getList(){
		return ResponseEntity.ok().body(service.getList());
	}
	
	@GetMapping("/account/{userid}")
	public ResponseEntity<UserAccount> getOne(@PathVariable String userid){
		UserAccount account = service.userInfo(userid);
		return ResponseEntity.ok().body(account);
	}
	
	@GetMapping("/userid/{userid}")
	public ResponseEntity<?> checkUserid(@PathVariable String userid){
		boolean result = service.validUserid(userid);
		log.info("checkUserid : {}",result);
		return ResponseEntity.ok().body(result);
	}
	
	
	@PostMapping("/account")  // 무결성 위반이면 badRequest 응답 보내기
	public ResponseEntity<?> post(@RequestBody UserAccount dto){
		
		try {
			int result = service.regist(dto);
			return ResponseEntity.ok().body(result);
		}catch (Exception e) {
			log.info("insert sql 예외 : {}",e.getMessage());
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	
	
	
	
	
	
}