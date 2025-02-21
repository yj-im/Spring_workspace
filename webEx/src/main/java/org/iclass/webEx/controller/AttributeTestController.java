package org.iclass.webEx.controller;

import java.util.ArrayList;
import java.util.List;

import org.iclass.webEx.dto.TestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AttributeTestController {
	//화면(View) 에 전달할 데이터를 저장하는 방법
	//   View 는 서버에서 처리하는 템플릿엔진(타임리프) html 파일이어야 함
	
	
	//★요청 URL 에 경로(path) 를 추가 : 파일관리, URL 관리를 위함
	@GetMapping("/community/list")
	public String list(Model model) {
		List<String> list = new ArrayList<>();
		list.add("소녀시대");
		list.add("nuz");
		list.add("아이브");
		list.add("twice");
		
		//View community/list.html 에 전달되는 데이터
		model.addAttribute("page", 3);
		model.addAttribute("testDto", new TestDto());
		model.addAttribute("list", list);
		return "community/list";  //★추가된 경로 이름으로 폴더만들어서 지정
	}
	
	@GetMapping("/community/read")
	public String read(Model model) {
		TestDto dto = new TestDto("홍길순",27,"인천","여자");
		
		model.addAttribute("dto", dto);
		return "community/read";
	}
	
	@GetMapping("exercise")
	public String exercise(Model model) {
		List<TestDto> list = new ArrayList<>();
		list.add(new TestDto("홍길동",22,"서울","남자"));
		list.add(new TestDto("홍길순",24,"인천","여자"));
		list.add(new TestDto("김다현",27,"경기","여자"));
		list.add(new TestDto("이나연",25,"서울","여자"));
		model.addAttribute("list", list);
		return "exercise";   // exercise.html
	}
	
	

}
