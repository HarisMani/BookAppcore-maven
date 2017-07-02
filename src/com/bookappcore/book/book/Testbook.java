package com.bookappcore.book.book;

public class Testbook {
	public static void main(String[] args) {
		Book book = new Book();
		book.setId(1);
		book.setName("c");
		book.setPrice(120);
		System.out.println(book.getId());
		System.out.println(book.getName());
		System.out.println(book.getPrice());

	}
}
