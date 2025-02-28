package org.iclass.mvcEx.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.iclass.mvcEx.dto.Gallery;
import org.iclass.mvcEx.mapper.GalleryMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Service
public class GalleryUploadService {
	// db mapper 의존관계 필요함.
	private GalleryMapper mapper;		// GalleryMapper 타입 객체는 자동 주입
	
	
	// 상수
	private final static String UPLOAD_PATH = "c:\\upload";

	public List<Gallery> list(){
		
		
		return mapper.selectAll();
	}
	
	// 1개의 파일을 업로드 하는 메소드
	public void uploadOne() {
		
	}

	// 1개의 파일을 업로드하는 메소드 : 첫번째 테스트용(db 저장안됨)
	public void uploadOne(Gallery dto) {
		// 서버가 dto 중에 업로드파일(file 변수)을 지정된 폴더에 저장
		MultipartFile file = dto.getFile();
		try {
		if(file.getSize() !=0) {  // 가져온 파일의 크기가 0이 아닐때만
			log.info("파일의 이름/크기 : {},{},{}", 
					file.getOriginalFilename(), 
					file.getSize(),
					file.getContentType());
			// 해당 파일을 로컬시스템의 File 객체로 만들기
			File uploadFile = new File(UPLOAD_PATH + "\\" + file.getOriginalFilename());
			// 위의 File 객체를 실제로 저장하기
			file.transferTo(uploadFile);
		}
		
		}catch(IOException e) {
		log.debug("파일 업로드 예외 : {}", e.getMessage());
	}
}

	public int uploadMany(Gallery dto) {
		// dto 중에서 List 타입으로 업로드 파일 가져오기 : uploadOne 을 list 크기만큼 반복
		List<MultipartFile> list=dto.getFiles();
		List<String> filenames=new ArrayList<>();
		for(MultipartFile file : list) {
			// MultipartFile 
			try {
				if(file.getSize() !=0) {  // 가져온 파일의 크기가 0이 아닐때만
					log.info("파일의 이름/크기 : {},{},{}", 
							file.getOriginalFilename(), 
							file.getSize(),
							file.getContentType());
					// 해당 파일을 로컬시스템의 File 객체로 만들기
					File uploadFile = new File(UPLOAD_PATH + "\\" + file.getOriginalFilename());
					// 위의 File 객체를 실제로 저장하기
					file.transferTo(uploadFile);
					filenames.add(file.getOriginalFilename());
				}
				
				
				
				}catch(IOException e) {
				log.debug("파일 업로드 예외 : {}", e.getMessage());
			}
			// 테이블에 insert 하기 : filenames 변수는 List. 하나의 String으로 만들기
			dto.setFileNames(String.join(",", filenames));
			mapper.insert(dto);
			
		}	// for문 끝
		return dto.getSeq();
	}
}
