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
	
	//输出型的参数，还是输出型的参数
		//Parameter ： 自定义的（ 传入的参数 和  类型 ）
		public static void execProcedure( String sql_call , 
				Parameter...params ) throws SQLException
		{
			openConn();
			callState = conn.prepareCall(sql_call);
			
			//参数不好处理
			for (int i = 0; i < params.length; i++) {
				if( params[i].direction == Parameter.IN )
				{
					//对日期类型的处理
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
					//对输出型参数的类型进行处理
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
		
		//查询数据
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
		
		// 这个是不能防止SQL注入的执行
		public static boolean execUpdate(String sql) throws SQLException{
			openConn();
			state = conn.createStatement();
			int record = state.executeUpdate(sql);
			closeAll();
			return record>0;
		}
		
		// 这个是能防止SQL注入的执行
		public static boolean execUpdate(String sql, Object...params) throws SQLException{
			openConn();
			preState=conn.prepareStatement(sql);
			
			for (int i=0;i<params.length;i++){
				// Date问题？
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
		
		//打开连接
		public static void openConn() throws SQLException{
			if(conn!=null && conn.isClosed() == false){
				//已经打开就不用再执行了
			}else{
				conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			}
		}
		
		//  关闭所有
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
