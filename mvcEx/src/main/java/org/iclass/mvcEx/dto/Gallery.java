package org.iclass.mvcEx.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Gallery {
	private int seq;
	private String title;
	private String writer;
	// 1개의 업로드 파일을 저장할 변수 (db저장 안함)
	private MultipartFile file;
	// 여러개의 업로드 파일을 저장할 변수 (db저장 안함)
	private List<MultipartFile> files;
	
	// gallery.html 의 input 요소 외에 db에 파일명을 저장하기 위한 변수
	private String fileNames;

	public Gallery(String title, String writer, String fileNames) {
		this.title=title;
		this.writer=writer;
		this.fileNames=fileNames;
	}


}
