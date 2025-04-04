package com.talk.Dto;

import com.talk.Entity.MemberEntity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSignInDto {
	
	@NotEmpty(message="아이디는 필수로 입력해야합니다.")
	@Size(min = 5, max = 12, message = "5자 이상 12자 이하로 입력하세요.")
	@Pattern(regexp = "^[a-z0-9]*$", message = "영어소문자와 숫자만 입력하세요")
	private String memberId;	// 로그인 아이디(필수입력)
	
	@NotEmpty(message="비밀번호 입력해야합니다.")
	@Size(min = 6, max = 16, message = "6자 이상 16자 이하로 입력하세요.")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "영어 대/소문자와 숫자만 입력하세요")
	private String password;	// 로그인 비밀번호(필수입력)
	
	// 아이디 비번을 테이블에 조회하기 위해 entity객체로 저장
	public static MemberEntity to(MemberSignInDto memberSignInDto) {
		MemberEntity memberEntity = new MemberEntity();
		
		memberEntity.setMemberId(memberSignInDto.getMemberId());
		memberEntity.setPassword(memberSignInDto.getPassword());
		
		return memberEntity;
	}
}
