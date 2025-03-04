package org.iclass.board.service;

import java.util.List;

import org.iclass.board.dto.CommunityCommentDTO;
import org.iclass.board.mapper.CommunityCommentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommunityCommentService {
	private final CommunityCommentMapper mapper;
	
	// 실행할 insert, update, delete SQL 이 
	// 하나의 서비스 메소드에서 2개 이상을 실행하면 서로
	@Transactional	// 트랜잭션 처리 : commit 또는 rollback 자동 실행
	public int commentSave(CommunityCommentDTO dto) {
		int result = mapper.insert(dto);
		mapper.updateCommentCount(dto.getMref());
		return result;
	}
	@Transactional
	public int commentRemove(int idx, int mref) {
		int result=mapper.delete(idx);
		mapper.updateCommentCount(mref);
		return result;
	}
	
	public List<CommunityCommentDTO> commentList(int mref){
		return mapper.selectCommentList(mref);
	}
}
