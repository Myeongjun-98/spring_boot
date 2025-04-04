package com.talk.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSignUpDto {
	
	@NotEmpty(message="아이디는 필수로 입력해야합니다.")
	@Size(min = 5, max = 12, message = "5자 이상 12자 이하로 입력하세요.")
	@Pattern(regexp = "^[a-z0-9]*$", message = "영어소문자와 숫자만 입력하세요")
	private String memberId;	// 회원 아이디(영어소문자, 숫자 5자 이상 12자 이하, 필수입력)
	
	@NotEmpty(message="비밀번호 입력해야합니다.")
	@Size(min = 6, max = 16, message = "6자 이상 16자 이하로 입력하세요.")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "영어 대/소문자와 숫자만 입력하세요")
	private String password;	// 회원 비밀번호(영어대소문자, 숫자 6자 이상 16자 이하, 필수입력)
	
	@NotBlank(message="이름은 필수로 입력해야합니다.")
	private String name;	// 회원이름(필수입력)
	
	@NotEmpty(message="이메일은 필수입니다.")
	private String email;	// 회원 이메일(필수입력)
	private String tel;		// 회원 연락처(형식 : 010-xxxx-xxxx)
}

/*
	
	validation 데이터 유효성 검증
	
	@NotEmpty	: null, 빈문자열 불가
	@NotBlank	: null 불가, 빈 문자열, 공백 불가	
	@Null		: null만 허용
	@NotNull	: null 불가 ( 빈문자열, 공백 허용 )
	
	@Min(value = n)	: value이상의 값만 허용
		@Min(value = 10, message="10이상만 입력하세요")
		private int num;	=> num은 10 이하만 허용된다.
		
	@Max(value = n) : value 이하의 값만 하용 
		@Max(value = 5, message="5자 이하만 입력하세요")
		private int num;	=> num은 5 이상만 허용된다.
		
	@Size( min = , max = )	: 길이를 제한할 때 사용
		@Size( min = 10, max = 20, message="10자 이상 20자 이하만 입력" )
		private String title;	=> title은 길이 10이상, 20이하만 허용된다.
		
	@Positive : 양수만 허용
	@PositiveOrZero : 양수와 0만 허용
	@Negative : 음수만 허용
	@NegativeOrZero : 음수와 0만 허용
	
	@Email : 이메일 형식 검사, 빈문자열은 패스
	
	@Pattern ( regexp = ) : 정규식 검사
	
	
	null	-> empty(true), blank(true)
	""		-> empty(true), blank(true)
	"a"		-> empty(false), blank(false)
	" "		-> empty(false), blank(true)	****
	"v aw " -> empty(false), blank(false)
*/