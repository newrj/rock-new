package com.a.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.a.dao.OperatorDao;
import com.a.entity.OperatorEntity;
import com.a.util.DBHelper;

public class OperatorDaoImp implements OperatorDao {

	//µÇÂ¼
	
	public static OperatorEntity operator;
	public static int id = 0;; 
	@Override
	public boolean login(String admin, String password) throws SQLException {
		String sql= "select * from operator";
		ResultSet set= DBHelper.execQuery(sql);
	//	OperatorEntity operator = new OperatorEntity();
	//	String user = "";
	//	String pwd = "";
		//int operatorId = 0;
		while(set.next()){
		if(set.getString("admin").equals(admin)&&set.getString("password").equals(password))
			{
			//user = admin;
			//pwd = password;
			operator.setAdmin(admin);
			operator.setPassword(password);
			operator.setId(set.getInt("id"));
			return true;
		//	operatorId=	set.getInt("operatorId");
			}
		}
		return false;

	}
	

}
