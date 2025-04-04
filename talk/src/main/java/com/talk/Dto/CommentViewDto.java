package com.talk.Dto;

import java.time.LocalDate;

import com.talk.Entity.CommentEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentViewDto {
	private int id;	// 댓글 번호(comment 테이블 id)
	private String memberId;	// 댓글 작성자
	private String content;		// 댓글 내용
	private LocalDate writeDate;	// 댓글 작성일
	
	// entity -> dtow
	public static CommentViewDto from(CommentEntity commentEntity) {
		CommentViewDto commentViewDto = new CommentViewDto();
		
		commentViewDto.setId(commentEntity.getId());
		commentViewDto.setMemberId(commentEntity.getMemberId());
		commentViewDto.setContent(commentEntity.getContent());
		commentViewDto.setWriteDate(commentEntity.getWriteDate());
		
		return commentViewDto;
	}
}
