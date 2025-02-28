package org.iclass.rest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.iclass.rest.dto.UserAccount;
import org.iclass.rest.mapper.UserAccountMapper;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor  // final 변수만 생성자 초기화
@Slf4j
@Service
public class UserAccountService {
	private final UserAccountMapper mapper;
	
	// 모든 사용자 조회
	public List<UserAccount> getList(){
		return mapper.selectAll();
	}
	
	// 사용자 등록
	public int regist(UserAccount dto) {
		return mapper.insert(dto);
	}
	// 사용자 이메일 수정
	public int updateEmail(UserAccount dto) {
		
		return mapper.updateEmail(dto);
	}
	
	// 사용자 삭제
	public int deactive(String userid) {
		return mapper.delete(userid);
	}
	
	// 사용자 정보 조회
	public UserAccount userInfo(String userid) {
		return mapper.selectByPk(userid);
	}
	
	// 이메일 사용 가능 여부(중복검사) - 사용가능하면 참
	public boolean validEmail(String email) {
		return (mapper.selectByEmail(email) == 0);
	}
	// userid 중복검사 - 사용가능하면 참
	public boolean validUserid(String userid) {
		return (mapper.selectByUserid(userid)== 0);
	}
	
	
	
	
}