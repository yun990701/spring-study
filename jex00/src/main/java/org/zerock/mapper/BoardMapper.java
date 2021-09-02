package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {

	//@Select("SELECT * FROM tbl_board")
	public List<BoardVO> getList();  //리스트, 삽입, 삭제, 수정, 검색 
	
	public void insert(BoardVO board);
	
	public BoardVO insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	

}
