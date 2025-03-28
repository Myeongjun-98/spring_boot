package com.bookSystem.DTO;

import com.bookSystem.Entity.Book;
import com.bookSystem.Entity.MyBasket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookBasketDto {
	private int id;	// mybasket테이블의 id
	private int book_id;	// mybasket테이블의 book_id 컬럼 값 저장
	private String book_title;	//book테이블의 book_title컬럼 값 저장
	private String book_author;	// book테이블의 book_author컬럼 값 저장

	public static BookBasketDto of(MyBasket myBasket, Book book) {
		BookBasketDto bookBasketDto = new BookBasketDto();
		bookBasketDto.setId(myBasket.getId());
		bookBasketDto.setBook_id(myBasket.getBook_id());
		bookBasketDto.setBook_title(book.getBook_title());
		bookBasketDto.setBook_author(book.getBook_author());
		
		return bookBasketDto;
	}



}


