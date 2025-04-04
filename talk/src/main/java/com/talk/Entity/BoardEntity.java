package com.talk.Entity;

import java.time.LocalDate;

import com.talk.Dto.BoardDetailDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardEntity {
	private int id;	// board테이블 번호
	private String title;	// 제목
	private String memberId;	// 작성자
	private String content;	// 내용	
	private String fileName;	// 파일경로 및 이름
	private int hit;	// 조회수
	private LocalDate writeDate;	// 작성일
	
}
