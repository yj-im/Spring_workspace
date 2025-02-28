package org.iclass.board.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
public class PageResponseDTO {
	private int totalCount;		// 전체 글 개수
	private int totalPages;
	
	private int startPage;
	private int endPage;
	
	private List<CommunityDTO> list;	// 요청 페이지의 글목록

}
