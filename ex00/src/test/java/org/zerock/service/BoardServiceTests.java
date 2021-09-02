package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;
	
	@Test
	public void BoardServiceExist() {
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 글");
		board.setWriter("newbie");
		
		boardService.register(board);
		
		
	}
	@Test
	public void BoardServiceExist2() {
	
	boardService.getList().forEach(board -> log.info(board));
	
	}
	
	@Test
	public void BoardServiceExist3() {
	
	log.info(boardService.get(1L));
	
	}
	@Test
	public void BoardServiceExist4() {
	log.info(""+boardService.remove(2L));
	}
	
	

}
