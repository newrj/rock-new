package com.a.dao;

import java.sql.SQLException;

public interface OperatorDao {

	
	// 用户登录
	 public boolean login(String admin, String password) throws SQLException ;
	
	
	
	// 查询用户admin,password信息
	 
}
