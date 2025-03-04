package org.iclass.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.board.dto.CommunityCommentDTO;

@Mapper
public interface CommunityCommentMapper {
	int insert(CommunityCommentDTO dto);
	int delete(int idx);
	List<CommunityCommentDTO> selectCommentList(int mref); 
	int selectCommentCount(int mref);
	int updateCommentCount (int mref);
}