package com.a.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;

import com.a.dao.BorrowDao;
import com.a.entity.BorrowEntity;
import com.a.util.DBHelper;

public class BorrowDaoImp implements BorrowDao {

	@Override
	public void add(BorrowEntity borrow) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into borrow( bookId, operatorId, readerId, isback, borrowDate) values(?,?,?,?,?)";
		ArrayList<Object> listparams = new ArrayList<Object>();

		listparams.add(borrow.getBookId());
		listparams.add(borrow.getOperatorId());
		listparams.add(borrow.getReaderId());
		listparams.add(borrow.getIsback());
		listparams.add(borrow.getBorrowDate());
		// listparams.add(borrow.getBackDate());

		Object[] params = new Object[0];
		params = listparams.toArray(params);
		boolean record = DBHelper.execUpdate(sql, params);
		String str = record == true ? "插入成功" : "插入失败";
		System.out.println(str);

	}

	@Override
	public int update(BorrowEntity borrow) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update borrow set isback = ? ,BackDate = ?  where bookId = ? and readerId = ? and isback = 0";
		Object[] params = { borrow.getIsback(), borrow.getBackDate(),
				borrow.getBookId(),borrow.getReaderId() };
		boolean record = DBHelper.execUpdate(sql, params);
		String str = record == true ? "更新成功" : "更新失败";
		System.out.println(str);
		return 0;
	}
	
	
	public static void main(String[] args) throws SQLException {
		BorrowDao dao = new BorrowDaoImp();
		//dao.query(1, 1);
	}

}
