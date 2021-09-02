package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
//@AllArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper boardMapper; 

	@Override
	public void register(BoardVO board) { //등록 --> 해당 키
		// TODO Auto-generated method stub
		
		boardMapper.insert(board);
	}

	
	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		log.info("get........." + bno);
		
		return boardMapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		log.info("modify........." + board);
		return boardMapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		log.info("remove........." + bno);
		return boardMapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList........");
		return boardMapper.getList();
	}

}
