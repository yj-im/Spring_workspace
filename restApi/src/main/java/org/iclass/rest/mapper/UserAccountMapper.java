package org.iclass.rest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.rest.dto.UserAccount;




@Mapper
public interface UserAccountMapper {
		int insert(UserAccount dto);
		UserAccount selectForLogin(Map<String,String> map);
		List<UserAccount> selectAll();
		int selectByEmail(String email);	// email 중복검사
		int selectByUserid(String userid);	// userid 중복검사
		int updateEmail(UserAccount dto);	// email 수정	
		int delete(String userid);
		UserAccount selectByPk(String userid);
}
