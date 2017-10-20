package com.a.ui;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import com.a.daoImp.ReaderDaoImp;
import com.a.entity.ReaderEntity;

public class Test {
	public static void main(String[] args) throws SQLException {
		
		ReaderEntity entity = new ReaderEntity();
		Scanner sc1= new Scanner(System.in);
		entity.setReaderId(sc1.nextInt());
		
		Scanner sc2 = new Scanner(System.in);
		entity.setName(sc2.next());
		
		Scanner sc3 = new Scanner(System.in);
		entity.setSex(sc3.next());
		
		Scanner sc4 = new Scanner(System.in);
		String s = sc4.next();
		entity.setBirth(new Date());
		
		Scanner sc5 = new Scanner(System.in);
		entity.setIdentityCard(sc5.next());
		
		Scanner sc6 = new Scanner(System.in);
		entity.setMaxNum(sc6.nextInt());
		
		Scanner sc7 = new Scanner(System.in);
		entity.setTel(sc7.next());
		
		Scanner sc8 = new Scanner(System.in);
		entity.setKeepMoney(sc8.nextInt());
		
		Scanner sc9 = new Scanner(System.in);
		String s1 = sc9.next();
		entity.setCreatedate(new Date());
		
		ReaderDaoImp dao = new ReaderDaoImp();
		dao.add(entity);
		
		
		
	}

}
