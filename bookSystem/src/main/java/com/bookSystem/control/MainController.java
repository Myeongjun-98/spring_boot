package com.bookSystem.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookSystem.DTO.BookBasketDto;
import com.bookSystem.DTO.BookListDto;
import com.bookSystem.DTO.BookLoanDto;
import com.bookSystem.DTO.BookSearchDto;
import com.bookSystem.DTO.MemberDto;
import com.bookSystem.Service.BookService;
import com.bookSystem.Service.MemberService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String home(Model model) {
		
		MemberDto memberDto = new MemberDto();
		model.addAttribute("memberDto", memberDto);
		
		
		
		return "index";
	}
	
	@PostMapping("/signIn")
	public String login(MemberDto memberDto, HttpSession session, Model model) {

		System.out.println(memberDto.getEmail() + memberDto.getPassword());
		
		// 로그인처리를 진행하려면 service의 메서드를 호출한다.
		// member와 관련된 것은 MemberService에서 처리한다.
		// 컨트롤쪽에서는 로그인 처리과정이 어떻게 진행되는지 전혀 몰라도 된다.
		// 그냥 service쪽 메서드를 호출하면 된다.
		boolean isSuccess = memberService.signIn(memberDto);
		
		if(isSuccess) {	// 로그인 성공 시
			session.setAttribute("user", memberDto.getEmail());
			return "redirect:/";
		}
		// 로그인 실패 시 index.html 다시 돌아가기
		model.addAttribute("fail", 1);
		return "index";
		
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
	
	// 도서 검색 부분
	@GetMapping("/bookSearch")
	public String search(Model model) {	// 도서검색 페이지 요청
		model.addAttribute("bookSearchDto", new BookSearchDto());
		return "book/search";
	}
	@GetMapping("bookSearch/result")
	public String searchResult(BookSearchDto bookSearchDto ,Model model) {

		List<BookListDto> bookListDtos = bookService.bookSearch(bookSearchDto);
		
		model.addAttribute("bookListDtos", bookListDtos);
		
		
		return "book/search";
	}
	// 도서검색 부분 끝
	
	// 도서 제목 클릭하여 바구니에 넣기 요청 처리
	@GetMapping("/basket")
	public String basket(@RequestParam int bookId, HttpSession session) {
		
		String email = (String)session.getAttribute("user");
		bookService.myBasketSave(bookId, email);
		
		return "redirect:/bookSearch";
	}
	
	// 대출 페이지 요청 처리
	@GetMapping("/loans")
	public String loansList(Model model, HttpSession session) {
		
		String email = (String)session.getAttribute("user");
		
		List<BookBasketDto> basketList = bookService.myBasketList(email);
		
		model.addAttribute("basketList", basketList);
		
		return "book/loan";
	}
	
	/////////////////////////////////////////////////////////////////////////
	
	// 도서 제목 클릭하여 대출처리
	@GetMapping("/loanSave")
	public String loanSave(@RequestParam("id") int id, 
			@RequestParam("bookId") int bookId, HttpSession session) {
		String email = (String)session.getAttribute("user");
		bookService.myloanSave(id,bookId, email);
		
		return "redirect:/loans";
	}
	
	@GetMapping("/return")
	public String returnPage(Model model , HttpSession session) {
		String email = (String)session.getAttribute("user");
		
		List<BookLoanDto> list = bookService.myLoanList( email );
		
		model.addAttribute("loanList",list);
		return "book/bookReturn";
	}
	
	
	@GetMapping("/returnExecute")
	public String returnExe(@RequestParam int id) {
		
		bookService.returnEx(id);
		
		return "redirect:/return";
	}
	
	
	
	
	
//	@GetMapping("/test")
//	public String main(Model model) {
//		
//		model.addAttribute("name", "곽찬양");
//		model.addAttribute("age", 30);
//		model.addAttribute("tel", "010-2343-9874");
//		model.addAttribute("addr","남아프리카 공화국");
//		
//		MemberDto memberDto = new MemberDto();
//		memberDto.setAge(29);
//		memberDto.setId("rim");
//		memberDto.setName("김은나");
//		memberDto.setTel("010-8888-0000");
//		model.addAttribute("user", memberDto);
//		
//		List<String> animal = new ArrayList<>();
//		animal.add("개"); animal.add("호랑이");
//		animal.add("뱀"); animal.add("닭");
//		animal.add("토끼"); animal.add("소");
//		model.addAttribute("animal", animal);
//		
//		
//		return "test";
//	}
//
//	@GetMapping("/test2")
//	public String test(){
//		return "test2";
//	}
	
	
	
	
}

/*

	스프링의 동작은 기본적으로 mvc패턴이다.
	M 모델		(데이터를 다루기위한 클래스)
	V 뷰		(화면 페이지 - html)
	C 컨트롤	
	
	요청 -> 컨트롤 -> 로직(서비스) -> DAO(레포지토리)
	-> 서비스 -> 컨트롤 -> client

*/
