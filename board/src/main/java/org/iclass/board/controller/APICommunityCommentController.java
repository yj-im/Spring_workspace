package org.iclass.board.controller;

import java.util.List;
import java.util.Map;

import org.iclass.board.dto.CommunityCommentDTO;
import org.iclass.board.service.CommunityCommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RestController
public class APICommunityCommentController {
	private final CommunityCommentService service;

	// 1. 댓글 리스트 요청
	@GetMapping("/api/comments/{mref}")
	public ResponseEntity<?> comments(@PathVariable int mref){
		List<CommunityCommentDTO> list=service.commentList(mref);
		return ResponseEntity.ok().body(list);
	
	}
	// 2. 댓글 추가
	@PostMapping("/api/comments")
	public ResponseEntity<?> comments(@RequestBody CommunityCommentDTO dto){
		int result=service.commentSave(dto);
		return ResponseEntity.ok().body(result);
	}
	
	// 3. 댓글 삭제
	@DeleteMapping("/api/comments")
	public ResponseEntity<?> comments(@RequestParam Map<String, String> map){
		// Map 으로 파라미터 전달될 때, Integer 형 변환 못합니다.
		log.info("idx 파라미터 : {}", map.get("idx"));
		log.info("mref 파라미터 : {}", map.get("mref"));
		int result=service.commentRemove(Integer.valueOf(map.get("idx")),Integer.valueOf(map.get("mref")));
		return ResponseEntity.ok().body(result);
	}
	
}
	

