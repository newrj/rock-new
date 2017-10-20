package com.a.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.a.dao.BookInfoDao;
import com.a.entity.BookInfoEntity;
import com.a.util.DBHelper;

public class BookInfoDaoImp implements BookInfoDao {
	
	

	//  添加图书信息
	@Override
	public int add(BookInfoEntity entity) throws SQLException {
		String sql = "insert into tb_bookInfo values(?,?,?,?,?,?,?,?,?)";
		System.out.println("---------");
		Object [] objs ={
				entity.getBookId(),entity.getISBN(),entity.getTypeId(),entity.getBookname(),
				entity.getWriter(),entity.getTranslator(),entity.getPublisher(),
				entity.getCreatedate(),entity.getPrice()};
		boolean bln = DBHelper.execUpdate(sql,objs);
		
		if(bln){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
		
		return 0;
	}

	//删除
	@Override
	public int delete(int bookId) throws SQLException {
		String sql="delete from tb_bookInfo where bookId=?";
		Object[] objs={bookId};
		boolean bln = DBHelper.execUpdate(sql,objs);
		
		if(bln){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
		
		return 0;
	}

	
	// 更新
	@Override
	public int update(BookInfoEntity entity) throws SQLException{
		String sql="update tb_bookInfo set bookId=?,ISBN=?,typeId=?,bookname=?,writer=?," +
				"translator=?,publisher=?,createdate=?,price=?";
		
		Object [] objs ={
			entity.getBookId(),entity.getISBN(),entity.getTypeId(),entity.getBookname(),
			entity.getWriter(),entity.getTranslator(),entity.getPublisher(),entity.getCreatedate(),
			entity.getPrice()};
		
		boolean bln = DBHelper.execUpdate(sql,objs);
		
		if(bln){
			System.out.println("更新成功");
		}else{
			System.out.println("更新失败");
		}
		return 0;
	
	}
	
	

	//  根据主键查询图书信息
	@Override
	public BookInfoEntity queryByPrimayKey(int bookId) throws SQLException {
		
		String sql="select * from tb_bookInfo where bookId=?";
		Object [] objs = {bookId};
		ResultSet set = DBHelper.execQuery(sql,objs);
		ArrayList<BookInfoEntity>entitys=new ArrayList<BookInfoEntity>();
		
		while (set.next()){
			BookInfoEntity bookInfo_entity = new BookInfoEntity();
			bookInfo_entity.setBookId(set.getInt("bookId"));
			bookInfo_entity.setISBN(set.getString("ISBN"));
			bookInfo_entity.setTypeId(set.getInt("typeId"));
			bookInfo_entity.setBookname(set.getString("bookname"));
			bookInfo_entity.setWriter(set.getString("writer"));
			bookInfo_entity.setTranslator(set.getString("translator"));
			bookInfo_entity.setPublisher(set.getString("publisher"));
			bookInfo_entity.setCreatedate(set.getDate("createdate"));
			bookInfo_entity.setPrice(set.getDouble("price"));
			
			entitys.add(bookInfo_entity);
			
		}
		for (BookInfoEntity bookInfoEntity : entitys) {
			System.out.println(bookInfoEntity.toString());
		}
		
		return null;
	}

	//按照ISBN查询图书信息
	

	@Override
	public ArrayList<BookInfoEntity> queryByISBN(String isbn)
			throws SQLException {
		
		String sql = "select bookId ,isbn, typeId,bookname, writer, translator, publisher, publishdate, price from bookinfo where isbn = ?";
		String sql1 = "select count(*) from bookinfo where isbn = ?";
		Object params = isbn;
		ResultSet set = DBHelper.execQuery(sql, params);
		ResultSet set1 = DBHelper.execQuery(sql1, params);
		ArrayList<BookInfoEntity> bookinfos = new ArrayList<BookInfoEntity>();
		while (set.next()) {

			BookInfoEntity bookinfo = new BookInfoEntity();
			bookinfo.setBookId(set.getInt("bookId"));
			bookinfo.setISBN(set.getString("ISBN"));
			bookinfo.setTypeId(set.getInt("typeId"));
			bookinfo.setBookname(set.getString("bookName"));
			bookinfo.setWriter(set.getString("writer"));
			bookinfo.setTranslator(set.getString("translator"));
			bookinfo.setPublisher(set.getString("publisher"));
			bookinfo.setCreatedate(set.getDate("createdate"));
			bookinfo.setPrice(set.getDouble("price"));
			bookinfos.add(bookinfo);
		}
		int count = 0;
		while (set1.next()) {
			count = set1.getInt("count(*)");
		}

		for (BookInfoEntity bookInfoEntity : bookinfos) {
			System.out.println(bookInfoEntity.toString());
		}
		System.out.println("共计" + count + "本。");

		set1.close();
		set1 = null;
		set.close();
		set = null;
		DBHelper.closeAll();
		
		return null;
	}

	
	// 按照综合信息查询图书信息
	@Override
	public ArrayList<BookInfoEntity> queryByKeyWords(BookInfoEntity bookinfo) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select * from bookinfo where 0=0";
		// 找到第二个参数
		ArrayList<Object> listparams = new ArrayList<Object>();

		if (bookinfo.getBookname() != null
				&& bookinfo.getBookname().trim().length() != 0) {
			sql += "and bookname like ? ";
			listparams.add("%" + bookinfo.getBookname() + "%");
		}
		if (bookinfo.getWriter() != null
				&& bookinfo.getWriter().trim().length() != 0) {
			sql += "and writer like ? ";
			listparams.add("%" + bookinfo.getWriter() + "%");
		}
		Object[] params = new Object[0];
		params = listparams.toArray(params);
		ArrayList<BookInfoEntity> listbookinfos = new ArrayList<BookInfoEntity>();
		ResultSet set = DBHelper.execQuery(sql, params);
		while (set.next()) {

			BookInfoEntity bookinfo1 = new BookInfoEntity();

			bookinfo1.setBookId(set.getInt("bookId"));
			bookinfo1.setISBN(set.getString("ISBN"));
			bookinfo1.setTypeId(set.getInt("typeId"));
			bookinfo1.setBookname(set.getString("bookName"));
			bookinfo1.setWriter(set.getString("writer"));
			bookinfo1.setTranslator(set.getString("translator"));
			bookinfo1.setPublisher(set.getString("publisher"));
			bookinfo1.setCreatedate(set.getDate("createdate"));
			bookinfo1.setPrice(set.getDouble("price"));
			listbookinfos.add(bookinfo1);
		}

		for (BookInfoEntity bookInfoEntity : listbookinfos) {
			System.out.println(bookInfoEntity);
		}
		set.close();
		set = null;
		DBHelper.closeAll();

		
		return null;
	}




	
	

}
