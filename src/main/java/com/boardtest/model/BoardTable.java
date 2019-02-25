package com.boardtest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
public class BoardTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardCode;
	
	@NotBlank(message="제목을 입력하세요")
	@Column(nullable=false, length=200)
	private String title;
	
	@NotBlank(message="내용을 입력하세요")
	@Column(nullable=false, length=4000)
	private String content;
	
	private String status; 
	
	@NotBlank(message="작성자를 입력하세요")
	@Column(nullable=false, length=50)
	private String writer;
	
	@Column(nullable=true, columnDefinition = "date default sysdate" )
	@Temporal(TemporalType.TIMESTAMP)
	private Date boardDate= new Date();
	
	
	public BoardTable() {
	}
	public Long getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(Long boardCode) {
		this.boardCode = boardCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	
	
}
