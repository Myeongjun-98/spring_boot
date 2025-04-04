package com.talk.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
	private int boardId;	// 게시글 번호(board테이블 id)
	private String content;	// 댓글 내용
	private String memberId;	// 댓글 작성자
}
