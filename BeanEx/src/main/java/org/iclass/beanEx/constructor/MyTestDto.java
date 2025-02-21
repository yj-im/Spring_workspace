package org.iclass.beanEx.constructor;


public class MyTestDto {
	private String userid;
	private String password;
	
	// 기본생성자
	public MyTestDto() {  	}
	
	// 인자로 전달된 값으로 객체의 변수를 초기화하는 커스텀 생성자
	public MyTestDto(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}
	
	//setter
	// 객체 변수 userid 값을 변경
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	// getter
	// 객체 변수 userid 을 리턴.
	public String getUserid() {
		return userid;
	}
	
	public String getPassword() {
		return password;
	}
	
	
}
