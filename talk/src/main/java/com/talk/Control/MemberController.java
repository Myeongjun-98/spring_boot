package com.talk.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.talk.Dto.MemberSignInDto;
import com.talk.Dto.MemberSignUpDto;
import com.talk.Service.BoardService;
import com.talk.Service.MemberService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/member")	// /member 시작하는 주소 매핑
public class MemberController {

	@Autowired	// member서비스 주입
	private MemberService memberService;
	
	@Autowired // index페이지를 요청하기 위해 필요한 보드서비스의 객체를 만듦
	private BoardService boardService;
	
	// 회원가입 요청 (Post - /signUp)
	@PostMapping("/signUp")
	public String signUp(@Valid MemberSignUpDto memberSignUpDto, 
			BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) { // Valid가 유효값 체크하여 유효하지 않은 경우 에러가 발생한다.
			System.out.println("유효하지 않은 값이 입력되었습니다.");
			
			// 최근글 5개 가져오기
			model.addAttribute("recentList", boardService.boardRecent());
			// 인기글 5개 가져오기
			model.addAttribute("popularList", boardService.boardPopular());
			
			model.addAttribute("memberSignInDto", new MemberSignInDto());
			model.addAttribute("open", 1);	//  회원가입 실패 시 페이지가 그대로 있도록, JS
			
			return "index";
		}
		
		// 회원가입을 위해 입력한 값들이 올바른 값이라면 여기서부터 동작 위에 if는 올바르지 않은 경우
		memberService.memberSave(memberSignUpDto);
		
		return "redirect:/";
	}
	
	// 로그인 요청 ( Post - /signIn )
	@PostMapping("/signIn")
	public String signIn(@Valid MemberSignInDto memberSignInDto, 
			BindingResult bindingResult, HttpSession session, Model model) {
		
		boolean hasError = bindingResult.hasErrors();
		if(!hasError) {	// hasError가 true이면 실행 안되게끔!~!!
			hasError = memberService.memberLogin(memberSignInDto);	//true면 입력이 뭔가 틀린거
			if(hasError) {
				bindingResult.reject("fail", "아이디 또는 비밀번호를 잘못 입력했습니다.");
			}
		}
		
		
		if(hasError) {	// 로그인 아이디 또는 비밀번호 입력 안하거나 길이 맞지 않거나 영어 숫자 아닌경우
			
			System.out.println("유효하지 않은 값이 입력되었습니다.");
			
			// 최근글 5개 가져오기
			model.addAttribute("recentList", boardService.boardRecent());
			// 인기글 5개 가져오기
			model.addAttribute("popularList", boardService.boardPopular());
			
			model.addAttribute("memberSignUpDto", new MemberSignUpDto());
			model.addAttribute("show", 1);	//  회원가입 실패 시 페이지가 그대로 있도록, JS
			
			return "index";
		}
		
		// 여기서부터 실행되는 코드는 아이디 비밀번호가 잘 입력되어서 
		session.setAttribute("user", memberSignInDto.getMemberId());
		
		return "redirect:/";
		
	}
	
}
