package com.a.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookInfoEntity {
	private int bookId;
	private String ISBN;
	private int typeId;
	private String bookname;
	private String writer;
	private String translator;
	private String publisher;
	private Date createdate;
	private double price;
	
	//格式化日期
	public String displayCreatedate()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String str_createdate = sdf.format(createdate);
		
		return str_createdate;
	}

	public BookInfoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookInfoEntity(int bookId, String iSBN, int typeId, String bookname,
			String writer, String translator, String publisher,
			Date createdate, double price) {
		super();
		this.bookId = bookId;
		ISBN = iSBN;
		this.typeId = typeId;
		this.bookname = bookname;
		this.writer = writer;
		this.translator = translator;
		this.publisher = publisher;
		this.createdate = createdate;
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTranslator() {
		return translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookInfoEntity [bookId=" + bookId + ", ISBN=" + ISBN
				+ ", typeId=" + typeId + ", bookname=" + bookname + ", writer="
				+ writer + ", translator=" + translator + ", publisher="
				+ publisher + ", createdate=" + createdate + ", price=" + price
				+ "]";
	}
	
	

}
