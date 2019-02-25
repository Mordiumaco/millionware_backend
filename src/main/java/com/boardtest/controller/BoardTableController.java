package com.boardtest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boardtest.model.BoardTable;
import com.boardtest.service.BoardTableService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="BoardTable for API", description="게시판 관리 컨트롤러")
@RestController
@RequestMapping("/board")
@CrossOrigin
public class BoardTableController {
	
	@Autowired
	private BoardTableService boardTableService;
	
	
	@ApiOperation(value="addBT", notes="게시물 생성 및 수정", protocols="http")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Error")
	})
	@PostMapping("")
	public ResponseEntity<?> addBT(@Valid @RequestBody BoardTable boardTable, BindingResult result){
		
		if(result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			
			for(FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}
		
		BoardTable newBT = boardTableService.cuboard(boardTable);
		
		return new ResponseEntity<BoardTable>(newBT, HttpStatus.CREATED);
		
	}
	
	@ApiOperation(value="getAllBTs", notes="모든 생성된 게시물을 조회한다.", protocols="http")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Error")
	})
	@GetMapping("/all")
	public Iterable<BoardTable> getAllBTs(){
		return boardTableService.findAll();
	}
	
	@ApiOperation(value="getBTByCode", notes="주어진 게시물 번호를 조회하여 해당 번호에 해당하는 게시물 겍체를 반환한다.", protocols="http")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Error")
	})
	@GetMapping("/{boardCode}")
	public ResponseEntity<?> getBTByCode(@PathVariable Long boardCode){
		BoardTable boardTable = boardTableService.getByBoardCode(boardCode);
		return new ResponseEntity<BoardTable>(boardTable, HttpStatus.OK);
	}
	
	@ApiOperation(value="deleteBoardTable", notes="주어진 게시물 번호를 조회하여 해당 번호에 해당하는 게시물을 삭제한다.", protocols="http")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Error")
	})
	@DeleteMapping("/{boardCode}")
	public ResponseEntity<?> deleteBoardTable(@PathVariable Long boardCode){
		boardTableService.delete(boardCode);
		return new ResponseEntity<String>("Board Table Deleted", HttpStatus.OK);
	}
	
	
}
