package com.a.dao;

import java.sql.SQLException;

import com.a.entity.BorrowEntity;

public interface BorrowDao {
	//
	// add ����
		public void add(BorrowEntity borrow) throws SQLException;

		// update ����

		public int update(BorrowEntity borrow) throws SQLException;


}
