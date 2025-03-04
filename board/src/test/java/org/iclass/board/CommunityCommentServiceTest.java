package org.iclass.board;

import static org.junit.jupiter.api.Assertions.*;

import org.iclass.board.dto.CommunityCommentDTO;
import org.iclass.board.mapper.CommunityCommentMapper;
import org.iclass.board.service.CommunityCommentService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class CommunityCommentServiceTest {

	@Autowired
	CommunityCommentService service;
	
	@Autowired
	CommunityCommentMapper mapper;
	
	@Test
	@DisplayName("421번 글의 댓글 목록 가져오기")
	void list() {
		log.info("421번 댓글 : {}",service.commentList(421));
		log.info("421번 댓글 갯수 : {}",service.commentList(421).size());
	}
	
	
	@Test
	@DisplayName("421번 글의 댓글 추가하기")
	void regist() {
		CommunityCommentDTO dto=CommunityCommentDTO.builder()
				.writer("twice")
				.content("댓글 테스트")
				.mref(421)
				.build();
		int result=service.commentSave(dto);
		log.info("변경된 댓글 갯수 : {}",mapper.selectCommentCount(421));
		assertEquals(1, result);
	}
	
	
	// idx 26번 삭제
	@Test
	@DisplayName("메인글 421번의 댓글 26번 삭제")
	void remove() {
		int result=service.commentRemove(26,421);
		log.info("변경된 댓글 갯수 : {}", mapper.selectCommentCount(421));
		assertEquals(1, result);
		
	}
	

}
