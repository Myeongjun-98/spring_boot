package com.talk.Entity;

import com.talk.Dto.MemberSignUpDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberEntity {
	private int id;	// member테이블 번호
	private String memberId;	// 아이디
	private String password;	// 비밀번호
	private String name;	// 이름
	private String email;	// 이메일
	private String tel;	// 연락처
	
	// dto -> entity 회원가입정보를 엔티티로 변환
	public static MemberEntity from(MemberSignUpDto memberSignUpDto) {
		MemberEntity memberEntity = new MemberEntity();
		
		memberEntity.setMemberId(memberSignUpDto.getMemberId());
		memberEntity.setPassword(memberSignUpDto.getPassword());
		memberEntity.setName(memberSignUpDto.getName());
		memberEntity.setEmail(memberSignUpDto.getEmail());
		memberEntity.setTel(memberSignUpDto.getTel());
		
		return memberEntity;
	}
}
