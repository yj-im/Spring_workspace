package org.iclass.mvcEx.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.iclass.mvcEx.dto.Gallery;
import org.iclass.mvcEx.service.GalleryUploadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Controller
public class GalleryUploadController {
	private GalleryUploadService service;
	
	
	// 레이아웃 샘플페이지. 다운로드 테스트
	@GetMapping("/sample")
	public String sample(Model model) {
		List<String> filenames=List.of("가나다.pdf","라마바.pdf","abcd.pdf");
		model.addAttribute("filenames", filenames);
		return "sample";
	}
	
	@GetMapping("/download")
	public void download(String filename, HttpServletResponse response) {
		String FILE_DIRECTORY= "C:/upload/";
		File file = new File(FILE_DIRECTORY+filename);
		
		response.setContentType("application/octet-stream");
		//							ㄴ 파일을 이전형식으로 다루고 강제로 다운로드 동작을 하는 MIME 타입
		String encodedFilename = URLEncoder.encode(filename, StandardCharsets.UTF_8);
		//							ㄴ 다운로드 파일명이 한글 등 다국어 문자 사용가능하도록 인코딩
		
		response.setHeader("Content-Disposition", "attachment; filename=\""
									+ encodedFilename + "\"");
		//							ㄴ 응답 헤더 이름 Content-Disposition에 인코딩된 파일명을 전달함
		response.setContentLengthLong(file.length());
		
		// C에 UPLOAD 폴더에 입력스트림을 만들고
		try(FileInputStream fis=new FileInputStream(file);		// 서버의 파일이 입력스트림
				OutputStream os=response.getOutputStream()){	// 사용자 응답이 출력스트림
			
			byte[] buffer=new byte[1024];
			int bytesRead;
			while ((bytesRead = fis.read(buffer)) != -1) {	// 입력 스트림으로부터 데이터 읽기
				os.write(buffer, 0, bytesRead);		// 출력 스트림에 데이터 쓰기
			}
			os.flush();		// 출력 스트림 캐시 비우기
		} catch(IOException e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("galleries")
	public String galleries(Model model) {
		//List<Gallery> list=new ArrayList<>();
		//list.add(new Gallery("침실", "iclass", "침실1.jpg,침실2.jpg,침실3.jpg"));
		//list.add(new Gallery("거실", "iclass","거실1.jpg,거실2.jpg"));
		//list.add(new Gallery("키친", "iclass","키친1.jpg,키친2.jpg,키친3.jpg"));
		
		// service 에사 조회한 결과를 리턴받아 애트리뷰트로 저장하기
		
		model.addAttribute("list",service.list());
		return "galleries";		// galleries.html
	}
	
	@PostMapping("galleries")
	public String galleries(Gallery dto) {
		int seq=service.uploadMany(dto);
		log.info("추가된 행의 seq : {}", seq);
		return "redirect:galleries";
	}
	
	@GetMapping("gallery")
	public String gallery(Model model) {
		// db를 사용하면 select 결과로 구현함.
		Gallery dto=Gallery.builder()
				.title("테스트1")
				.writer("iclass")
				.fileNames("강쥐.png")
				.build();
		model.addAttribute("dto", dto);
		return "gallery";
	}
	
	@PostMapping("gallery")
	public String gallery(Gallery dto) {
		log.info("POST gallery : {}", dto);
		//service.uploadOne(dto);
		service.uploadMany(dto);
		return "redirect:gallery";
	}
}
