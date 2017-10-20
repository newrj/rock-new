package com.a.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.a.entity.BookInfoEntity;


public interface BookInfoDao {
	//新增图书信息
	public int add(BookInfoEntity entity) throws SQLException;
	
	//删除图书信息
	public int delete(int bookId) throws SQLException;
	
	//修改图书信息
	public int update(BookInfoEntity entity) throws SQLException;
	
	//按照主键查询图书信息
	public BookInfoEntity queryByPrimayKey(int bookId) throws SQLException;
	
	//按照ISBN查询图书信息
	ArrayList<BookInfoEntity> queryByISBN(String isbn) throws SQLException;
	
	//按照综合信息查询图书信息
	public ArrayList<BookInfoEntity> queryByKeyWords(BookInfoEntity bookinfo) throws SQLException;

}
