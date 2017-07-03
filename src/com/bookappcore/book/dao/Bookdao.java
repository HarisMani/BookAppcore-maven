package com.bookappcore.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bookappcore.book.book.*;
import com.bookappcore.book.util.Connectionutil;
import com.bookappcore.*;

public class Bookdao {
	public void addbook(Book book) throws Exception {
		Connection connection = Connectionutil.getConnection();
		String sql = "insert into books values(?,?,?)";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, book.getId());
		pst.setString(2, book.getName());
		pst.setInt(3, book.getPrice());
		pst.executeUpdate();

	}

	public void delete(Book book) throws Exception {
		Connection connection = Connectionutil.getConnection();
		String sql = "delete from books where id=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, book.getId());
		pst.executeUpdate();

	}

	public void update(Book book) throws Exception {
		Connection connection = Connectionutil.getConnection();
		String sql = "update books set price=? where id=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, book.getPrice());
		pst.setInt(2, book.getId());
		pst.executeUpdate();

	}

	public List<Book> findall() throws Exception {
		Connection connection = Connectionutil.getConnection();
		List<Book> list1 = new ArrayList<Book>();

		String sql = "select id,name,price from books";
		PreparedStatement ps = connection.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Book b1 = new Book();
			b1.setId(rs.getInt(1));
			b1.setName(rs.getString(2));
			b1.setPrice(rs.getInt(3));
			list1.add(b1);

		}
		return list1;
	}

	public List<Book> findbyprice(int min, int max) throws Exception {

		List<Book> list1 = new ArrayList<Book>();

		Connection connection = Connectionutil.getConnection();
		String sql = "select name from books where price>=? and price<=? ";
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setInt(1, min);
		ps.setInt(2, max);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Book b1 = new Book();
			b1.setName(rs.getString(1));
			list1.add(b1);

		}
		/*
		 * Iterator itr=list1.iterator(); while(itr.hasNext()){
		 * System.out.println(itr.next()); }
		 */
		return list1;

	}

	public List<Book> findbyname(String name) throws Exception {
		List<Book> list1 = new ArrayList<Book>();

		Connection connection = Connectionutil.getConnection();
		String sql = "select name,id from books where name=? ";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, name);
		ResultSet rs2 = pst.executeQuery();
		while (rs2.next()) {
			Book b = new Book();
			b.setName(rs2.getString(1));
			b.setId(rs2.getInt(2));
			list1.add(b);
		}

		return list1;
	}
}
