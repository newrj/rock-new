package com.a.util;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DBHelper {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "admin";
	
	private static Connection conn = null;
	private static Statement state = null;
	private static PreparedStatement preState = null;
	private static CallableStatement callState = null;
	private static ResultSet set = null;
	
	static
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private DBHelper()
	{
		//do nothing
	}
	
	//����͵Ĳ�������������͵Ĳ���
		//Parameter �� �Զ���ģ� ����Ĳ��� ��  ���� ��
		public static void execProcedure( String sql_call , 
				Parameter...params ) throws SQLException
		{
			openConn();
			callState = conn.prepareCall(sql_call);
			
			//�������ô���
			for (int i = 0; i < params.length; i++) {
				if( params[i].direction == Parameter.IN )
				{
					//���������͵Ĵ���
					/*
					 if( params[i].getClass() == java.util.Date.class )
					{
						java.util.Date d_temp = (java.util.Date)params[i];
						java.sql.Date d = new java.sql.Date(d_temp.getTime());
						
						preState.setDate(i + 1, d);
					}else
					{
						preState.setObject(i + 1, params[i]);
					}
					 * */
					callState.setObject(i + 1, params[i].param);
				}else if( params[i].direction == Parameter.OUT )
				{		
					//������Ͳ��������ͽ��д���
					if( params[i].param.getClass() == Integer.class
						 || params[i].param.getClass() == Double.class	)
					{
						callState.registerOutParameter(i + 1 
								, oracle.jdbc.OracleTypes.NUMBER);
						 
						
					}else if( params[i].param.getClass() == String.class )
					{
						callState.registerOutParameter(i + 1 
								, oracle.jdbc.OracleTypes.VARCHAR);
					}else
					{
						callState.registerOutParameter(i + 1 
							, oracle.jdbc.OracleTypes.OTHER);
					}
				}
				
			}
			
			callState.execute();
			
			for (int i = 0; i < params.length; i++) {
				if(params[i].direction == Parameter.OUT  )
				{
					Object obj_out = callState.getObject(i + 1);
					params[i].param = obj_out;
				}
			}
			
			closeAll();
		}
		
		//��ѯ����
		public static ResultSet execQuery(String sql) throws SQLException{
			openConn();
			
			state = conn.createStatement();
			set = state.executeQuery(sql);
			
			return set;
		}
		
		public static ResultSet execQuery(String sql,Object...params) throws SQLException{
			openConn();
			
			preState=conn.prepareStatement(sql);
			
			for(int i=0;i<params.length;i++){
				if(params[i].getClass()==java.util.Date.class){
					java.util.Date d_temp=(java.util.Date)params[i];
					java.sql.Date d = new java.sql.Date(d_temp.getTime());
					
					preState.setDate(i+1, d);
				}else{
					preState.setObject(i+1, params[i]);
				}
			}
			
			set = preState.executeQuery();
			
			return set;
			
		}
		
		// ����ǲ��ܷ�ֹSQLע���ִ��
		public static boolean execUpdate(String sql) throws SQLException{
			openConn();
			state = conn.createStatement();
			int record = state.executeUpdate(sql);
			closeAll();
			return record>0;
		}
		
		// ������ܷ�ֹSQLע���ִ��
		public static boolean execUpdate(String sql, Object...params) throws SQLException{
			openConn();
			preState=conn.prepareStatement(sql);
			
			for (int i=0;i<params.length;i++){
				// Date���⣿
				if(params[i].getClass()==java.util.Date.class ){
					java.util.Date d_temp=(java.util.Date)params[i];
					java.sql.Date d = new java.sql.Date(d_temp.getTime());
					
					preState.setDate(i+1, d);
				}else{
					preState.setObject(i+1, params[i]);
				}
			}
			
			int record = preState.executeUpdate();
			
			closeAll();
			return record >0;
			
		}
		
		//������
		public static void openConn() throws SQLException{
			if(conn!=null && conn.isClosed() == false){
				//�Ѿ��򿪾Ͳ�����ִ����
			}else{
				conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			}
		}
		
		//  �ر�����
		public static void closeAll(){
			if( set != null){
				try{
					set.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				set = null;
			}
			
			if( callState != null ){
				try{
					callState.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				callState = null;
			}
			if(preState != null){
				try{
					preState.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				preState = null;
			}
			
			if(state!= null){
				try{
					state.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				state = null;
			}
			
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				conn = null;
			}
			
		}
		
		public static void main(String [] args){
			
			try{
				Parameter[] params = {
						new Parameter(7499,Parameter.IN) , 
						new Parameter(1,Parameter.OUT )
					};
				execProcedure("{ call usp_getSalaryByEmpno(?,?) }",params);
				System.out.println(params[1].param.toString());
			}catch(Exception e ){
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		
		
		
		

}
