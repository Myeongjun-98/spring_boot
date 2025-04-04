package com.talk.Entity;

import java.time.LocalDate;

import com.talk.Dto.CommentDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentEntity {
	private int id;	// comment테이블 번호
	private int boardId;	// 게시글 번호
	private String memberId;	// 작성자 아이디
	private String content;	// 댓글 내용
	private LocalDate writeDate;	// 댓글 작성일
	
	// dto -> entity
	public static CommentEntity from(CommentDto commentDto) {
		CommentEntity commentEntity = new CommentEntity();
		
		commentEntity.setId(commentDto.getBoardId());
		commentEntity.setMemberId(commentDto.getMemberId());
		commentEntity.setContent(commentDto.getContent());
		
		return commentEntity;
	}
}
