package com.talk.Dto;

import java.time.LocalDate;
import java.util.List;

import com.talk.Entity.BoardEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDetailDto {
	private int id;	// 게시글 번호
	private String title;	// 게시글 제목
	private String memberId;	// 게시글 작성자(아이디)
	private String content;		// 게시글 내용
	private String fileName;	// 첨부파일(이미지)
	private int hit;			// 조회수
	private LocalDate writeDate;	// 작성일
	private List<CommentViewDto> commentList;	// 게시글 댓글 목록
	
	// 게시글 하나의 전체 내용을 보기 위한 dto클래스, 해당 게시들의 댓글을 List로 가져오기
	public static BoardDetailDto of(BoardEntity boardEntity, List<CommentViewDto> list) {
		BoardDetailDto boardDetailDto = new BoardDetailDto();
		
		boardDetailDto.setId(boardEntity.getId());
		boardDetailDto.setTitle(boardEntity.getTitle());
		boardDetailDto.setMemberId(boardEntity.getMemberId());
		boardDetailDto.setContent(boardEntity.getContent());
		boardDetailDto.setHit(boardEntity.getHit());
		boardDetailDto.setWriteDate(boardEntity.getWriteDate());
		boardDetailDto.setCommentList(list);
		boardDetailDto.setFileName(boardEntity.getFileName());
		
		return boardDetailDto;
	}
	
}