package com.bookappcore.user;

public class Testuser {

	public static void main(String[] args) {

		User a = new User();
		a.setEmail("qw12@jk.com");
		a.setName("mugi");
		a.setPassword("qw");

		System.out.println("Id=" + a.getName() + ",name=" + a.getEmail() + ",price=" + a.getPassword());

	}

}
