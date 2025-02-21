package org.iclass.beanEx.constructor;


public class MyTestDtoMain {

	public static void main(String[] args) {
		//MyTestDto 객체의 생성 1)
		MyTestDto dto = new MyTestDto();   //기본 생성자 실행
		System.out.println(dto.getUserid() + " : " + dto.getPassword());
		dto.setUserid("gildong");   // 객체의 userid 변수값 설정
		dto.setPassword("9999");    // 객체의 password 변수값 설정
		System.out.println(dto.getUserid() + " : " + dto.getPassword());
		
		//MyTestDto 객체의 생성 2)
		// 커스텀 생성자 실행 : 생성자에서 객체의 userid 와 password 변수값 설정
		MyTestDto dto2 = new MyTestDto("gilsoon", "7777");
		System.out.println(dto2.getUserid() + " : " + dto2.getPassword());
	}

}
