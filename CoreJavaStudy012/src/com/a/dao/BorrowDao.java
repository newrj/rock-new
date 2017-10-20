package com.a.dao;

import java.sql.SQLException;

import com.a.entity.BorrowEntity;

public interface BorrowDao {
	//
	// add ΩË È
		public void add(BorrowEntity borrow) throws SQLException;

		// update ªπ È

		public int update(BorrowEntity borrow) throws SQLException;


}
