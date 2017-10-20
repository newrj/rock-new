package com.a.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.a.dao.CheckDao;
import com.a.util.DBHelper;

public class CheckDaoImp  implements CheckDao  {

	@Override
	public boolean isBookInfoId(int bookId) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select bookId from bookinfo ";
		ResultSet set = DBHelper.execQuery(sql);
		while (set.next()) {
			if (set.getInt("bookId") == bookId) {
				return true;
			}
		}
		return false;
	}

	// readerid是否存在于reader中
	@Override
	public boolean isReadId(int readerId) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select readerId from reader ";
		ResultSet set = DBHelper.execQuery(sql);
		while (set.next()) {
			if (set.getInt("readerId") == readerId) {
				return true;
			}
		}
		return false;
	}

	// 图书馆是否有书给读者
	@Override
	public boolean isBorrowForLib(int bookId) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select count(*) from bookinfo left outer join borrow on bookinfo.bookId=borrow.bookId where isbn in (select isbn from bookinfo where bookId = ?) and isback=1";
		Object[] params = { bookId };
		ResultSet set = DBHelper.execQuery(sql, params);
		set.next();
		int maxnum = set.getInt("count(*)");
		if (maxnum <= 0) {
			return false;
		}
		return true;
	}

	// 读者是否还能借书
	@Override
	public boolean isBorrowForReader(int readerId) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select count(*) from reader left outer join borrow  on reader.readerId=borrow.readerId where reader.readerId=? and isback = 0";
		String sql1 = "select count(*) from reader left outer join borrow  on reader.readerId=borrow.readerId where reader.readerId=? and isback = 1";
		Object[] params = { readerId };
		ResultSet set = DBHelper.execQuery(sql, params);
		ResultSet set1 = DBHelper.execQuery(sql1, params);
		set.next();
		set1.next();
		int jienum = set.getInt("count(*)");
		
		int huannum = set1.getInt("count(*)");
		int i = jienum - huannum > 0 ? jienum - huannum : huannum - jienum;
		//System.out.println(i);
		if (i > 5) {
			return false;
		}

		return true;
	}
	
	@Override
	public boolean isReaderIsBook(int readerId) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select count(*) from reader left outer join borrow  on reader.readerId=borrow.readerId where reader.readerId=? and isback = 0";
		Object[] params = { readerId };
		ResultSet set = DBHelper.execQuery(sql, params);
		set.next();
		int jienum = set.getInt("count(*)");
		System.out.println(jienum);
		if(jienum>0){
			return false;
		}
		return true;
	}
	
	
	
	

	// 在馆数量
	@Override
	public int bookLib(String isbn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select count(*) from bookinfo left outer join borrow on bookinfo.bookId=borrow.bookId where isbn=? and isback=1";
		Object[] params = { isbn };
		ResultSet set = DBHelper.execQuery(sql, params);
		set.next();
		int num = set.getInt("count(*)");
		return num;
	}

	// 外借数量
	@Override
	public int notBookLib(String isbn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select count(*) from bookinfo left outer join borrow on bookinfo.bookId=borrow.bookId where isbn=? and isback=0";
		Object[] params = { isbn };
		ResultSet set = DBHelper.execQuery(sql, params);
		set.next();
		int num = set.getInt("count(*)");
		return num;
	}

	public static void main(String[] args) throws SQLException {
		CheckDao c = new CheckDaoImp();
		int i = c.bookLib("10-567-6787-001-9");
		//System.out.println(i);
		c.isBorrowForReader(1);
	}

	@Override
	public boolean isTypeId(int typeId) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select typeId from bookType ";
		ResultSet set = DBHelper.execQuery(sql);
		while (set.next()) {
			if (set.getInt("typeId") == typeId) {
				return true;
			}
		}
		return false;
	}

}
