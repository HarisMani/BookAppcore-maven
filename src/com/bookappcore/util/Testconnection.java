package com.bookappcore.util;

import java.sql.Connection;

public class Testconnection {

	public static void main(String[] args) {

		try {
			Connection con = Connectionutil.getConnection();
			System.out.println(con);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
