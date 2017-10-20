package com.a.daoImp;

import java.sql.SQLException;

import com.a.dao.ReaderDao;
import com.a.entity.ReaderEntity;
import com.a.util.DBHelper;

public class ReaderDaoImp implements ReaderDao {

	
	//����������Ϣ
	@Override
	public int add(ReaderEntity entity) throws SQLException {
		String  sql="insert into tb_reader values(?,?,?,?,?,?,?,?,?)";
		Object [] objs={entity.getReaderId(),entity.getName(),entity.getSex(),
				entity.getBirth(),entity.getIdentityCard(),entity.getMaxNum(),
				entity.getTel(),entity.getKeepMoney(),entity.getCreatedate()};
		boolean bln = DBHelper.execUpdate(sql,objs);
		
		if(bln){
			System.out.println("��ӳɹ�");
		}else{
			System.out.println("���ʧ��");
		}
		
		return 0;
	}



	//ɾ��������Ϣ
	@Override
	public int delete(int readerId) throws SQLException {

		String sql = "delete from tb_Reader where readerId=?";
		Object[] objs={readerId};
		
		boolean bln = DBHelper.execUpdate(sql,objs);
		
		if(bln){
			System.out.println("ɾ���ɹ�");
		}else{
			System.out.println("ɾ��ʧ��");
		}
		return 0;
	}

	
	
	

}
