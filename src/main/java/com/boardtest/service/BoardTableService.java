package com.boardtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boardtest.dao.BoardTableDao;
import com.boardtest.model.BoardTable;

@Service
public class BoardTableService {
	
	@Autowired
	private BoardTableDao boardTableDao;
	
	public BoardTable cuboard(BoardTable boardTable) {
		
		if(boardTable.getStatus()==null||boardTable.getStatus()=="") {
			boardTable.setStatus("TODO");
		}
		
		return boardTableDao.save(boardTable);
		
	}
	
	public Iterable<BoardTable> findAll(){
		return boardTableDao.findAll();
	}
	
	public BoardTable getByBoardCode(Long boardCode) {
		return boardTableDao.getByBoardCode(boardCode);
	}
	
	public void delete(Long boardCode) {
		BoardTable boardTable = getByBoardCode(boardCode);
		boardTableDao.delete(boardTable);
	}
}
