package com.boardtest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boardtest.model.BoardTable;

@Repository
public interface BoardTableDao extends CrudRepository<BoardTable, Long> {
	
	BoardTable getByBoardCode(Long boardCode);
	
}
