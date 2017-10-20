package com.a.ui;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.a.dao.BookInfoDao;
import com.a.dao.BorrowDao;
import com.a.dao.CheckDao;
import com.a.daoImp.BookInfoDaoImp;
import com.a.daoImp.BorrowDaoImp;
import com.a.daoImp.CheckDaoImp;
import com.a.daoImp.OperatorDaoImp;
import com.a.daoImp.ReaderDaoImp;
import com.a.entity.BookInfoEntity;
import com.a.entity.BorrowEntity;
import com.a.entity.ReaderEntity;
import com.a.util.Method;

public class UI {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		
		/*
		Scanner sc = new Scanner (System.in);
		String str = sc.next();
		boolean bln = Method.checkIdCard(str);
		if(bln){
			System.out.println("ok");
		}else{
			System.out.println("��ok");
		}
		*/
		
		login();
		
	}
	
	public static void login() throws Exception{
		/*
			System.out.println("------��ӭ��½ͼ�����ϵͳ------");
			System.out.println("�������û���");
			Scanner scc = new Scanner(System.in);
			String user = scc.next();
			System.out.println("����������");
			String pass = scc.next();
			OperatorDaoImp operator = new OperatorDaoImp();
			boolean bl = operator.login(user, pass);
			
			if(bl){
				System.out.println("��¼�ɹ���");
				welcomeMain();
			}else{
				login();
			}
				*/
		welcomeMain();
	}
		
		
		
		
		
		
	public static void welcomeMain() throws Exception{
		
		
		
		System.out.println("������Ҫѡ��Ĺ��ܣ�");
		System.out.println("1 ������Ϣ           2 ͼ����Ϣ");
		System.out.println("3ͼ�����            4 ����");
		System.out.println("5����                    6 �����޸�");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		
		switch(choose){
		case 1:System.out.println("������Ҫ�Զ��߱���еĲ�����");
		       System.out.println("1 ���Ӷ�����Ϣ    2 ɾ��������Ϣ");
		       Scanner sc1 = new Scanner(System.in);
		       int choose1 = sc1.nextInt();
		       
		       switch(choose1){
		       case 1 :System.out.println("�������������id�����������������Ա�" +
		       		                       "���߳������ڣ��������֤����������Ŀ�����ߵ绰��Ѻ�𣬴�������");
		    	        addreader();
		                break;
		       case 2 :deletereader();
		                   break;
		       }
		      break;
		      
		      
		case 2 :System.out.println("������Ҫ��ͼ�����еĲ���");
		        System.out.println("1 ����ͼ����Ϣ         2 ɾ��ͼ����Ϣ");
		        System.out.println("3 ����ͼ����Ϣ         4 ����ISBN��ѯ��Ϣ");
		        System.out.println("5 ����ͼ�����ƣ�ģ������ѯͼ����Ϣ");
		        System.out.println("6 �����������ƣ�ģ������ѯͼ����Ϣ");
		        System.out.println("7 ����������");
		        Scanner sc2 = new Scanner(System.in);
		        int choose2 = sc2.nextInt();
		        
		        switch(choose2){
		        case 1 : System.out.println("���������룺ͼ��id��ISBN�룬���id��" +
		        		                      "���������ߣ����ߣ������磬�������ڣ��۸�");
		        	     addbookInfo();
		                 break;
		        case 2 : System.out.println("������Ҫɾ����ͼ����");
		        	     deletebookInfo();
		                 break;
		        case 3 :System.out.println("���������룺ͼ��id��ISBN�룬���id��" +
		        		                      "���������ߣ����ߣ������磬�������ڣ��۸�");
		        	     updatebookInfo();
		                 break;
		        case 4 :queryByISBNbookInfo();         //ͨ����ѯISBN�Ų�ѯ
		                 break;
		        case 5 :queryByBookNamebookInfo();      //ͨ��ͼ�����Ʋ�ѯ
		                 break;         
		        case 6 :queryByBookWriter();           //ͨ���������Ʋ�ѯ
		                 break;
		        case 7 : welcomeMain();       
		        
		        default :
		        	break;
		        }
		        
		case 3 : System.out.println("��ӭ��½�������");
                 System.out.println("-----------");
			     borrowAdd();
		         break;
		
		case 4 : System.out.println("��ӭ��½�������");
		         System.out.println("-----------");
		}

	}
	
	
	//���߱�ķ���
	static void addreader() throws SQLException
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
		
		ReaderEntity entity = new ReaderEntity();
		
		System.out.println("���������ID��");
		Scanner sc1= new Scanner(System.in);
		entity.setReaderId(sc1.nextInt());
		
		System.out.println("���������������");
		Scanner sc2 = new Scanner(System.in);
		String str2 = sc2.next();
		if(Method.checkName(str2)){
		entity.setName(str2);}
		else{
			addreader();
		}
		
		System.out.println("����������Ա�����Ϊ0��Ů��Ϊ1��");
		Scanner sc3 = new Scanner(System.in);
		String str=sc3.next();
		if(Method.checkSex(str)){
		entity.setSex(str);}
		else {
			addreader();
		}
		
		System.out.println("��������߳�������");
		Scanner sc4 = new Scanner(System.in);
		String str4 = sc4.next();
		if(Method.checkDate(str4)){
		entity.setBirth(new Date());}
		else {
			addreader();
		}
		
		System.out.println("������������֤");
		Scanner sc5 = new Scanner(System.in);
		String str5 = sc5.next();
		if(Method.checkIdCard(str5)){
		entity.setIdentityCard(str5);}
		else{
			addreader();
		}
		
		System.out.println("��������������Ŀ��");
		Scanner sc6 = new Scanner(System.in);
		entity.setMaxNum(sc6.nextInt());
		
		System.out.println("������������ϵ��ʽ��");
		Scanner sc7 = new Scanner(System.in);
		String str7 = sc7.next();
		if(Method.checkPhone(str7)){
		entity.setTel(str7);}
		else{
			addreader();
		}
		
		System.out.println("������Ѻ��");
		Scanner sc8 = new Scanner(System.in);
		entity.setKeepMoney(sc8.nextInt());
		
		System.out.println("�������֤����");
		Scanner sc9 = new Scanner(System.in);
		String str9 = sc9.next();
		if(Method.checkDate(str9)){
		entity.setCreatedate(new Date());}
		else {
			addreader();
		}
		
		ReaderDaoImp dao = new ReaderDaoImp();
		dao.add(entity);
	}
	 
	 static void deletereader() throws SQLException
	{
		System.out.println("����Ҫɾ����Ա�����");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		ReaderDaoImp dao=new ReaderDaoImp();
		dao.delete(num);
	}
	
	
	
	//ͼ���ķ���
	static void addbookInfo() throws SQLException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
		BookInfoEntity entity = new BookInfoEntity();
		
		Scanner sc= new Scanner(System.in);
		entity.setBookId(sc.nextInt());
		
		String str1 = sc.next();
		if(Method.checkISBN(str1)){
		entity.setISBN(str1);}
		else {
			addbookInfo();
		}
		
		entity.setTypeId(sc.nextInt());
		
		entity.setBookname(sc.next());
		
		String str2 = sc.next();
		if(Method.checkName(str2)){
		entity.setWriter(str2);}
		else {
			addbookInfo();
		}
		
		String str3 = sc.next();
		if(Method.checkName(str3)){
		entity.setTranslator(str3);}
		else {
			addbookInfo();
		}
		
		String str4 = sc.next();
		if(Method.checkName(str4)){
		entity.setPublisher(str4);}
		else {
			addbookInfo();
		}
		
		String createdate = sc.next();
		if(Method.checkDate(createdate)){
		entity.setCreatedate(new Date());}
		else {
			addbookInfo();
		}
		
		entity.setPrice(sc.nextDouble());
		System.out.println(entity.toString());
		BookInfoDaoImp dao = new BookInfoDaoImp();
		dao.add(entity);
		
	}
	
	static void deletebookInfo() throws SQLException
	{
		System.out.println("����Ҫɾ����Ա�����");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		BookInfoDaoImp dao=new BookInfoDaoImp();
		dao.delete(num);
		
	}
	
	
	static void updatebookInfo() throws SQLException
	{
		
		System.out.println("������Ҫ�޸ĵ�ͼ����Ϣ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
		BookInfoEntity entity=new BookInfoEntity();
		
		
		Scanner sc1=new Scanner(System.in);
		entity.setBookId(sc1.nextInt());
		
		Scanner sc2 = new Scanner(System.in);
		String str2 = sc2.next();
		if(Method.checkISBN(str2)){
		entity.setISBN(sc2.next());}
		else {
			updatebookInfo();
		}
		
		Scanner sc3 = new Scanner(System.in);
		entity.setTypeId(sc3.nextInt());
		
		Scanner sc4 = new Scanner(System.in);
		String str4 = sc4.next();
		if(Method.checkName(str4)){
		entity.setBookname(sc4.next());}
		else{
			updatebookInfo();
		}
		
		Scanner sc5 = new Scanner(System.in);
		String str5 = sc5.next();
		if(Method.checkName(str5)){
		entity.setWriter(str5);}
		else {
			updatebookInfo();
		}
		
		Scanner sc6 = new Scanner(System.in);
		String str6 = sc6.next();
		if(Method.checkName(str6)){
		entity.setTranslator(str6);}
		else {
			updatebookInfo();
		}
		
		Scanner sc7 = new Scanner(System.in);
		String str7 = sc7.next();
		if(Method.checkName(str7)){
		entity.setPublisher(sc7.next());}
		else {
			updatebookInfo();
		}
		
		Scanner sc8 = new Scanner(System.in);
		String createdate = sc8.next();
		if(Method.checkDate(createdate)){
		entity.setCreatedate(new Date());}
		else {
			updatebookInfo();
		}
		
		Scanner sc9 = new Scanner(System.in);
		double str9 = sc9.nextDouble();
		entity.setPrice(sc9.nextDouble());
		
		BookInfoDaoImp dao = new BookInfoDaoImp();
		dao.update(entity);
	}
	
	static void queryByISBNbookInfo() throws Exception
	{
		BookInfoDao imp = new BookInfoDaoImp();
		Scanner sc = new Scanner(System.in);
		BookInfoEntity bookinfo = new BookInfoEntity();
		System.out.println("��������Ҫ��ѯ��isbn��");
		String isbn = sc.next();
		if (Method.checkISBN(isbn)) {
			bookinfo.setISBN(isbn);
			imp.queryByISBN(isbn);
			welcomeMain();                 // ------------------
		} else {
			System.out.println("�����isbn�����Ϲ淶�����������룡����");
			queryByISBNbookInfo();
		}
	}
	
	private static void queryByBookNamebookInfo() throws Exception{
		BookInfoDao imp = new BookInfoDaoImp();
		Scanner sc = new Scanner(System.in);
		BookInfoEntity bookinfo = new BookInfoEntity();
		System.out.println("��������Ҫ��ѯģ���֣�");
		String str = sc.next();
		bookinfo.setBookname(str);
		imp.queryByKeyWords(bookinfo);
		welcomeMain();                 // ------------------
		
	}
	
	private static void queryByBookWriter() throws Exception{
		BookInfoDao imp = new BookInfoDaoImp();
		Scanner sc = new Scanner(System.in);
		BookInfoEntity bookinfo = new BookInfoEntity();
		System.out.println("��������Ҫ��ѯģ���֣�");
		String str = sc.next();
		bookinfo.setBookname(str);
		imp.queryByKeyWords(bookinfo);
		welcomeMain();                 // ------------------
		
	}
	
	
	//����
	public static void borrowUpdate() throws SQLException {
		// TODO Auto-generated method stub
		BorrowDao imp = new BorrowDaoImp();
		Scanner sc = new Scanner(System.in);
		CheckDao cd = new CheckDaoImp();
		BorrowEntity borrow = new BorrowEntity();
		System.out.println("������ͼ��ı�ţ�");
		int bookId = sc.nextInt();
		if (!cd.isBookInfoId(bookId)) {//��������ж�ͼ���Ŵ治����
			System.out.println("��ͼ���Ų����ڣ����ͼ���š�");
			borrowUpdate();
		} else {
			System.out.println("��������ߵı�ţ�");
			int readerId = sc.nextInt();
			if (!cd.isReadId(readerId)) {//�ж϶��߱�Ŵ治����
				System.out.println("�ö��߱�Ų����ڣ����������߱���Ƿ�����");
				borrowUpdate();
			} else {
				borrow.setBookId(bookId);
				borrow.setReaderId(readerId);
				borrow.setIsback(1);
				borrow.setBackDate(new Date());
				imp.update(borrow);
			}
		}
	}

	public static void borrowAdd() throws Exception {
		// TODO Auto-generated method stub
		BorrowDao imp = new BorrowDaoImp();
		CheckDao cd = new CheckDaoImp();
		OperatorDaoImp imp1 = new OperatorDaoImp();
		Scanner sc = new Scanner(System.in);
		BorrowEntity borrow = new BorrowEntity();

		System.out.println("������Ҫ�����ı�ţ�");
		int bookId = sc.nextInt();
		if (cd.isBookInfoId(bookId)) {
			if (cd.isBorrowForLib(bookId)) {
				borrow.setBookId(bookId);
			} else {
				System.out.println("û���Ȿ���ˣ�����");
				borrowAdd();
			}
		} else {
			System.out.println("��Ҫ������Ų����ڣ�����");
			borrowAdd();

		}
		borrow.setBookId(imp1.id);
		borrow.setIsback(0);
		borrow.setBorrowDate(new Date());
		System.out.println("��������ߵı�ţ�");
		int readerId = sc.nextInt();
		if (cd.isReadId(readerId)) {
			if (cd.isBorrowForReader(readerId)) {
				borrow.setReaderId(readerId);
			} else {
				System.out.println("��λ���߲����Խ����ˣ�����");
				borrowAdd();
			}
		} else {
			System.out.println("��������λ���ߣ���������¼��ö��������ڽ��н��ģ�����");
			welcomeMain();
		}
		imp.add(borrow);
		welcomeMain();
	}

	
	
	

}
