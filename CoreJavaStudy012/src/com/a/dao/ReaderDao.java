package com.a.dao;

import java.sql.SQLException;

import com.a.entity.ReaderEntity;

public interface ReaderDao {
	//����������Ϣ
	public int add(ReaderEntity entity) throws SQLException;
	
	//ɾ��������Ϣ
	public int delete(int readerId) throws SQLException;

}
