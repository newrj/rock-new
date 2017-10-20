package com.a.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.a.entity.BookInfoEntity;


public interface BookInfoDao {
	//����ͼ����Ϣ
	public int add(BookInfoEntity entity) throws SQLException;
	
	//ɾ��ͼ����Ϣ
	public int delete(int bookId) throws SQLException;
	
	//�޸�ͼ����Ϣ
	public int update(BookInfoEntity entity) throws SQLException;
	
	//����������ѯͼ����Ϣ
	public BookInfoEntity queryByPrimayKey(int bookId) throws SQLException;
	
	//����ISBN��ѯͼ����Ϣ
	ArrayList<BookInfoEntity> queryByISBN(String isbn) throws SQLException;
	
	//�����ۺ���Ϣ��ѯͼ����Ϣ
	public ArrayList<BookInfoEntity> queryByKeyWords(BookInfoEntity bookinfo) throws SQLException;

}
