package com.talk.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.talk.Dto.MemberSignInDto;
import com.talk.Dto.MemberSignUpDto;
import com.talk.Service.BoardService;

@Controller
public class MainController {

	// 메인페이지 ( Get - / )
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String home(Model model) {
		
		// 최근글 5개 가져오기
		model.addAttribute("recentList", boardService.boardRecent());
		// 인기글 5개 가져오기
		model.addAttribute("popularList", boardService.boardPopular());
		
		model.addAttribute("memberSignInDto", new MemberSignInDto());
		model.addAttribute("memberSignUpDto", new MemberSignUpDto());
		
		return "index";
	}
}
