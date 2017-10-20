package com.a.daoImp;

import java.sql.SQLException;

import com.a.dao.ReaderDao;
import com.a.entity.ReaderEntity;
import com.a.util.DBHelper;

public class ReaderDaoImp implements ReaderDao {

	
	//新增读者信息
	@Override
	public int add(ReaderEntity entity) throws SQLException {
		String  sql="insert into tb_reader values(?,?,?,?,?,?,?,?,?)";
		Object [] objs={entity.getReaderId(),entity.getName(),entity.getSex(),
				entity.getBirth(),entity.getIdentityCard(),entity.getMaxNum(),
				entity.getTel(),entity.getKeepMoney(),entity.getCreatedate()};
		boolean bln = DBHelper.execUpdate(sql,objs);
		
		if(bln){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
		
		return 0;
	}



	//删除读者信息
	@Override
	public int delete(int readerId) throws SQLException {

		String sql = "delete from tb_Reader where readerId=?";
		Object[] objs={readerId};
		
		boolean bln = DBHelper.execUpdate(sql,objs);
		
		if(bln){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
		return 0;
	}

	
	
	

}
