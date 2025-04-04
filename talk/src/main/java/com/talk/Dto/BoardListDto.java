package com.talk.Dto;

import java.time.LocalDate;

import com.talk.Entity.BoardEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardListDto {
	private int id;	// 게시글 번호(제목 클릭 시 상세보기 위해)
	private String title;	// 게시글 제목
	private String memberId;	// 작성자	
	private int hit;	// 조회수
	private LocalDate writeDate;	// 작성일
	
	// entity -> dto
	public static BoardListDto from(BoardEntity boardEntity) {
		BoardListDto boardListDto = new BoardListDto();
		
		boardListDto.setId(boardEntity.getId());
		boardListDto.setTitle(boardEntity.getTitle());
		boardListDto.setMemberId(boardEntity.getMemberId());
		boardListDto.setHit(boardEntity.getHit());
		boardListDto.setWriteDate(boardEntity.getWriteDate());
		
		
		return boardListDto;
	}
	
}
