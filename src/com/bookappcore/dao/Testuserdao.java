package com.bookappcore.dao;

import com.bookappcore.user.User;

public class Testuserdao {
	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setEmail("har12@gmail.com");
		user.setPassword("abc");
		// user.setName("as");

		UserDao userdao = new UserDao();
		System.out.println(userdao.login(user));

	}

}
