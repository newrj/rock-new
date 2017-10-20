package com.a.dao;

import java.sql.SQLException;

import com.a.entity.ReaderEntity;

public interface ReaderDao {
	//新增读者信息
	public int add(ReaderEntity entity) throws SQLException;
	
	//删除读者信息
	public int delete(int readerId) throws SQLException;

}
