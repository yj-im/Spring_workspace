package org.iclass.board;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iclass.board.dto.CommunityDTO;
import org.iclass.board.mapper.CommunityMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class CommunityMapperTest {
	
	@Autowired	// 빈 저장소에서 자동주입(필드 주입)
	private CommunityMapper mapper;
	
	@Test
	@DisplayName("4페이지의 글 목록을 가져오기")
	void selectAll() {
		Map<String, Integer> map=new HashMap<>();
		map.put("startNo", 31); map.put("endNo", 40);
		List<CommunityDTO> list=mapper.selectPageList(map);
		log.info("4페이지 리스트 : {}", list);
		
	}
	
	@Disabled
	@Test
	@DisplayName("게시판 테이블의 333번 행 삭제")
	void delete() {
		int result=mapper.delete(333);
		assertEquals(1, result);		// 클래스 이름 Assertions 생략. import 확인
		CommunityDTO dto=mapper.selectByIdx(333);
		assertNull(dto);
		
	}

	@Test
	@DisplayName("게시판 테이블의 333번 데이터 수정")
	void update() {
		CommunityDTO dto = CommunityDTO.builder()
				.title("Junit3")
				.content("[수정]테스트프레임웍크3")
				.idx(333)
				.build();
		int result=mapper.update(dto);
		CommunityDTO resDto=mapper.selectByIdx(dto.getIdx()); 
		Assertions.assertEquals(1, result);	
		Assertions.assertEquals(dto.getContent(), resDto.getContent());
		
	}
	
	@Test	// 테스트할 메소드 표시
	@DisplayName("게시판 테이블에 insert 확인")
	@Disabled	// 다음에는 테스트에서 제외
	void test() {
		CommunityDTO dto = CommunityDTO.builder()
						.title("Junit")
						.content("테스트프레임웍크")
						.writer("twice")
						.build();
		int result = mapper.insert(dto);	// 정상 실행하면 1개행 추가. 값 1 리턴
		
		Assertions.assertEquals(1, result);
	}

}
