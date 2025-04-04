package com.talk.Dto;

import com.talk.Entity.BoardEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
	private int id;	// 게시글 번호
	private String title;	// 게시글 제목(필수입력)
	private String content;	// 게시글 내용(필수입력, 5자 이상)
	private String fileName;	// 게시글 첨부파일 또는 이미지)
	
	// dti -> entity
	public static BoardEntity to(BoardDto boardDto) {
		BoardEntity boardEntity = new BoardEntity();
		
		boardEntity.setId(boardDto.getId());
		boardEntity.setTitle(boardDto.getTitle());
		boardEntity.setContent(boardDto.getContent());
		boardEntity.setFileName(boardDto.getFileName());
		
		return boardEntity;
	}
	
	// entity -> dto
	public static BoardDto from(BoardEntity boardEntity) {
		BoardDto boardDto = new BoardDto();
		
		boardDto.setId(boardEntity.getId());
		boardDto.setTitle(boardEntity.getTitle());
		boardDto.setContent(boardEntity.getContent());
		boardDto.setFileName(boardEntity.getFileName());
		
		return boardDto;
	}
	
	
}
