package com.talk.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.talk.Entity.CommentEntity;

@Mapper
public interface CommentRepository {
	
	// 댓글 저장 메서드
	public int insert(CommentEntity commentEntity);	
	
	// 댓글 삭제 메서드
	public int delete(int id);
	
	// 게시글 상세보기에 댓글 목록 가져오기
	public List<CommentEntity> findByBoardIdOrderByIdDesc(int id);
}
