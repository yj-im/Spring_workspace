package org.iclass.webEx.controller;

import org.iclass.webEx.dto.PageDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ParamAttrTestController {
	
	@GetMapping("/board/search")
	public String searchlist2(@ModelAttribute("pageDto")  PageDto dto 
//			, Model model
			) {
		log.info("GET /board/search 파라미터 : {} , {}",dto.getPage(), dto.getKeyword());
		
//		model.addAttribute("pageDto", dto);   // @ModelAttribute("pageDto") 사용할 수 있음
		return "board/search";
	}
	
	@PostMapping("/board/search")
	public String search2(PageDto dto ,RedirectAttributes reAttr ) {
		log.info("POST /board/search 파라미터 : {} , {}",dto.getPage(), dto.getKeyword());
		
//		reAttr.addAttribute("pagedto", dto);   // 파라미터 역할도 있어서 형식이 오류
		reAttr.addAttribute("page",dto.getPage());   
		reAttr.addAttribute("keyword", dto.getKeyword());
		reAttr.addFlashAttribute("message", dto.getKeyword() + " 검색 완료했습니다.");
		return "redirect:/board/search";
	}
	
	
	/*	
	@PostMapping("/board/search")
	public String search(int page, String keyword , 
			RedirectAttributes reAttr) {  
		//Model 대신에 RedirectAttributes 사용하면 리다이렉트 할 때 애트리뷰트 저장할 수 있음.
		//														ㄴ url 에 표시됨.
		log.info("POST /board/search 파라미터 : {} , {}",page, keyword);
		
		// 리다이렉트 할때에도 애트리뷰트값(+파라미터)을 줄 수 있을까?? (JSP에서는 불가능)
//		model.addAttribute("page", pageDto.getPage());
		reAttr.addAttribute("page",page);   // RedirectAttributes는 스프링 프레임웍에서만
		reAttr.addAttribute("keyword", keyword);
		return "redirect:/board/search";
//		return "redirect:/board/search?page="+page + "&keyword=" + keyword;  //JSP방식
	}
	
	@GetMapping("/board/search")
	public String searchlist(
			@RequestParam(defaultValue = "1") int page, 
			String keyword, Model model) {
		log.info("GET /board/search 파라미터 : {} , {}",page, keyword);
		model.addAttribute("page",page);
		model.addAttribute("keyword", keyword);
		return "board/search";
	}
*/	
	
	@GetMapping("/board/list")
	public String list(
//			@RequestParam(defaultValue = "1")   // 2개 어노테이션 동시 동작 못함
			@ModelAttribute(name="page") int page) {
		// @ModelAttribute 는 dto 타입에서 유용
		log.info("GET 요청 /board/list 파라미터 : {}",page);
		
		return "board/list";
	}
	
	
	@GetMapping("/board/write")
	//http://localhost:8085/board/write?code=XYZ
	// 					ㄴ 예시 : 파라미터 code의 값을 View 에게 전달
	public String write(String code, Model model) {
	// 파라미터 dto 타입으로 받아도 동일하게 적용 가능합니다.	
		log.info("GET 요청 /board/write 파라미터 : {}",code);
		model.addAttribute("code", code);
		return "board/write";    // board/write.html 을 View 로 설정
	}
	
	@PostMapping("/board/write")
	public String save(String title, String content) {
		log.info("POST 요청 /board/write 파라미터 : {}, {}",title,content);
		return "redirect:/";
	}

}
