package com.bookappcore.book.dao;

import com.bookappcore.book.book.Book;

public class Testbookdao {
	public static void main(String[] args) throws Exception {
		Book book = new Book();
		book.setId(2);
		book.setName("c++");
		book.setPrice(1000);

		Bookdao bookdao = new Bookdao();
		bookdao.addbook(book);
	}

}
