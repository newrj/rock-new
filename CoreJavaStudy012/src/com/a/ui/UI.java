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
			System.out.println("不ok");
		}
		*/
		
		login();
		
	}
	
	public static void login() throws Exception{
		/*
			System.out.println("------欢迎登陆图书管理系统------");
			System.out.println("请输入用户名");
			Scanner scc = new Scanner(System.in);
			String user = scc.next();
			System.out.println("请输入密码");
			String pass = scc.next();
			OperatorDaoImp operator = new OperatorDaoImp();
			boolean bl = operator.login(user, pass);
			
			if(bl){
				System.out.println("登录成功！");
				welcomeMain();
			}else{
				login();
			}
				*/
		welcomeMain();
	}
		
		
		
		
		
		
	public static void welcomeMain() throws Exception{
		
		
		
		System.out.println("请输入要选择的功能：");
		System.out.println("1 读者信息           2 图书信息");
		System.out.println("3图书类别            4 借书");
		System.out.println("5还书                    6 口令修改");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		
		switch(choose){
		case 1:System.out.println("请输入要对读者表进行的操作：");
		       System.out.println("1 增加读者信息    2 删除读者信息");
		       Scanner sc1 = new Scanner(System.in);
		       int choose1 = sc1.nextInt();
		       
		       switch(choose1){
		       case 1 :System.out.println("请依次输入读者id，读者姓名，读者性别，" +
		       		                       "读者出生日期，读者身份证，最大借书数目，读者电话，押金，创建日期");
		    	        addreader();
		                break;
		       case 2 :deletereader();
		                   break;
		       }
		      break;
		      
		      
		case 2 :System.out.println("请输入要对图书表进行的操作");
		        System.out.println("1 增加图书信息         2 删除图书信息");
		        System.out.println("3 更新图书信息         4 根据ISBN查询信息");
		        System.out.println("5 按照图书名称（模糊）查询图书信息");
		        System.out.println("6 按照作者名称（模糊）查询图书信息");
		        System.out.println("7 返回主界面");
		        Scanner sc2 = new Scanner(System.in);
		        int choose2 = sc2.nextInt();
		        
		        switch(choose2){
		        case 1 : System.out.println("请依次输入：图书id，ISBN码，类别id，" +
		        		                      "书名，作者，译者，出版社，创建日期，价格");
		        	     addbookInfo();
		                 break;
		        case 2 : System.out.println("请输入要删除的图书编号");
		        	     deletebookInfo();
		                 break;
		        case 3 :System.out.println("请依次输入：图书id，ISBN码，类别id，" +
		        		                      "书名，作者，译者，出版社，创建日期，价格");
		        	     updatebookInfo();
		                 break;
		        case 4 :queryByISBNbookInfo();         //通过查询ISBN号查询
		                 break;
		        case 5 :queryByBookNamebookInfo();      //通过图书名称查询
		                 break;         
		        case 6 :queryByBookWriter();           //通过作者名称查询
		                 break;
		        case 7 : welcomeMain();       
		        
		        default :
		        	break;
		        }
		        
		case 3 : System.out.println("欢迎登陆借书界面");
                 System.out.println("-----------");
			     borrowAdd();
		         break;
		
		case 4 : System.out.println("欢迎登陆借书界面");
		         System.out.println("-----------");
		}

	}
	
	
	//读者表的方法
	static void addreader() throws SQLException
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		
		ReaderEntity entity = new ReaderEntity();
		
		System.out.println("请输入读者ID：");
		Scanner sc1= new Scanner(System.in);
		entity.setReaderId(sc1.nextInt());
		
		System.out.println("请输入读者姓名：");
		Scanner sc2 = new Scanner(System.in);
		String str2 = sc2.next();
		if(Method.checkName(str2)){
		entity.setName(str2);}
		else{
			addreader();
		}
		
		System.out.println("请输入读者性别，男性为0，女性为1：");
		Scanner sc3 = new Scanner(System.in);
		String str=sc3.next();
		if(Method.checkSex(str)){
		entity.setSex(str);}
		else {
			addreader();
		}
		
		System.out.println("请输入读者出生日期");
		Scanner sc4 = new Scanner(System.in);
		String str4 = sc4.next();
		if(Method.checkDate(str4)){
		entity.setBirth(new Date());}
		else {
			addreader();
		}
		
		System.out.println("请输入读者身份证");
		Scanner sc5 = new Scanner(System.in);
		String str5 = sc5.next();
		if(Method.checkIdCard(str5)){
		entity.setIdentityCard(str5);}
		else{
			addreader();
		}
		
		System.out.println("请输入最大借书数目：");
		Scanner sc6 = new Scanner(System.in);
		entity.setMaxNum(sc6.nextInt());
		
		System.out.println("请输入您的联系方式：");
		Scanner sc7 = new Scanner(System.in);
		String str7 = sc7.next();
		if(Method.checkPhone(str7)){
		entity.setTel(str7);}
		else{
			addreader();
		}
		
		System.out.println("请输入押金：");
		Scanner sc8 = new Scanner(System.in);
		entity.setKeepMoney(sc8.nextInt());
		
		System.out.println("请输入办证日期");
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
		System.out.println("输入要删除的员工编号");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		ReaderDaoImp dao=new ReaderDaoImp();
		dao.delete(num);
	}
	
	
	
	//图书表的方法
	static void addbookInfo() throws SQLException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
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
		System.out.println("输入要删除的员工编号");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		BookInfoDaoImp dao=new BookInfoDaoImp();
		dao.delete(num);
		
	}
	
	
	static void updatebookInfo() throws SQLException
	{
		
		System.out.println("请输入要修改的图书信息");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
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
		System.out.println("请输入你要查询的isbn：");
		String isbn = sc.next();
		if (Method.checkISBN(isbn)) {
			bookinfo.setISBN(isbn);
			imp.queryByISBN(isbn);
			welcomeMain();                 // ------------------
		} else {
			System.out.println("输入的isbn不符合规范，请重新输入！！！");
			queryByISBNbookInfo();
		}
	}
	
	private static void queryByBookNamebookInfo() throws Exception{
		BookInfoDao imp = new BookInfoDaoImp();
		Scanner sc = new Scanner(System.in);
		BookInfoEntity bookinfo = new BookInfoEntity();
		System.out.println("请输入你要查询模糊字：");
		String str = sc.next();
		bookinfo.setBookname(str);
		imp.queryByKeyWords(bookinfo);
		welcomeMain();                 // ------------------
		
	}
	
	private static void queryByBookWriter() throws Exception{
		BookInfoDao imp = new BookInfoDaoImp();
		Scanner sc = new Scanner(System.in);
		BookInfoEntity bookinfo = new BookInfoEntity();
		System.out.println("请输入你要查询模糊字：");
		String str = sc.next();
		bookinfo.setBookname(str);
		imp.queryByKeyWords(bookinfo);
		welcomeMain();                 // ------------------
		
	}
	
	
	//借书
	public static void borrowUpdate() throws SQLException {
		// TODO Auto-generated method stub
		BorrowDao imp = new BorrowDaoImp();
		Scanner sc = new Scanner(System.in);
		CheckDao cd = new CheckDaoImp();
		BorrowEntity borrow = new BorrowEntity();
		System.out.println("请输入图书的编号：");
		int bookId = sc.nextInt();
		if (!cd.isBookInfoId(bookId)) {//这个方法判断图书编号存不存在
			System.out.println("该图书编号不存在，检查图书编号。");
			borrowUpdate();
		} else {
			System.out.println("请输入读者的编号：");
			int readerId = sc.nextInt();
			if (!cd.isReadId(readerId)) {//判断读者编号存不存在
				System.out.println("该读者编号不存在，检查输入读者编号是否有误。");
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

		System.out.println("请输入要借的书的编号：");
		int bookId = sc.nextInt();
		if (cd.isBookInfoId(bookId)) {
			if (cd.isBorrowForLib(bookId)) {
				borrow.setBookId(bookId);
			} else {
				System.out.println("没有这本书了！！！");
				borrowAdd();
			}
		} else {
			System.out.println("你要借的书编号不存在！！！");
			borrowAdd();

		}
		borrow.setBookId(imp1.id);
		borrow.setIsback(0);
		borrow.setBorrowDate(new Date());
		System.out.println("请输入读者的编号：");
		int readerId = sc.nextInt();
		if (cd.isReadId(readerId)) {
			if (cd.isBorrowForReader(readerId)) {
				borrow.setReaderId(readerId);
			} else {
				System.out.println("这位读者不可以借书了！！！");
				borrowAdd();
			}
		} else {
			System.out.println("不存在这位读者！！！请先录入该读者信心在进行借阅！！！");
			welcomeMain();
		}
		imp.add(borrow);
		welcomeMain();
	}

	
	
	

}
