package org.iclass.board.controller;

import java.time.LocalDate;
import java.util.List;

import org.iclass.board.dto.CommunityDTO;
import org.iclass.board.dto.PageResponseDTO;
import org.iclass.board.service.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@AllArgsConstructor
public class CommunityController {
	private CommunityService service;
	
	@GetMapping("/community/list")
	public String list(@RequestParam(defaultValue = "1")int page, Model model) {
		
		//List<CommunityDTO> list=service.getPageList(page);
		//model.addAttribute("list", list);
		PageResponseDTO pagelist=service.getPageList(page);
		model.addAttribute("pageList", pagelist);
		model.addAttribute("page", page);	// 검색기능 구현하면 dto로 작성.
		return "community/list";	// community 폴더안에 list.html
	}
	
	// 글수정
	@GetMapping("/community/modify")
	public String modify(int idx, int page, Model model) {
		
		model.addAttribute("dto", service.read(idx,false));
		model.addAttribute("page", page);
		return "community/modify";	// write.html 활용
	}
	
	// 수정할 내용 저장
	@PostMapping("/community/modify")
	public String modify(CommunityDTO dto,int page,RedirectAttributes reAttr) {
		log.info("modify dto : {}", dto);
		service.save(dto);
		reAttr.addAttribute("idx",dto.getIdx());
		reAttr.addAttribute("page",page);
		return "redirect:/community/read";
	}
	// 글삭제
	@PostMapping("/community/remove")
	public String remove(int idx, int page, RedirectAttributes reAttr) {
		service.remove(idx);
		reAttr.addAttribute("page", page);
		return "redirect:/list";	
	}
	
	
	// 글읽기
	@GetMapping("/community/read")
		public String read(int idx, int page, Model model) {
								// 		 ㄴ list.html 화면에서 글제목 링크에 page 파라미터 받아오기
		log.info("idx : {} page : {}",idx,page);
		// sql : idx 값으로 하나의 행 조회, mapper, service 
		model.addAttribute("dto", service.read(idx,true));
		model.addAttribute("page",page);
							// 		ㄴ read.html 화면에 목록/수정/삭제 버튼 링크에 page 파라미터 값으로 사용
		return "community/read";
	}
	// 글쓰기
	@GetMapping("/community/write")
	public String write() {
		
		return "community/write";
	}
	
	@PostMapping("/community/write")
	public String write(CommunityDTO dto) {
		service.write(dto);
		return "redirect:list";
		
	}
}
