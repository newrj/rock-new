package com.a.entity;

import java.util.Date;

public class BorrowEntity {
	private int id;
	private int bookId;
	private int operatorId;
	private int readerId;
	private int isback;
	private Date borrowDate;
	private Date backDate;
	public BorrowEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BorrowEntity(int id, int bookId, int operatorId, int readerId,
			int isback, Date borrowDate, Date backDate) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.operatorId = operatorId;
		this.readerId = readerId;
		this.isback = isback;
		this.borrowDate = borrowDate;
		this.backDate = backDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	public int getIsback() {
		return isback;
	}
	public void setIsback(int isback) {
		this.isback = isback;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getBackDate() {
		return backDate;
	}
	public void setBackDate(Date backDate) {
		this.backDate = backDate;
	}
	 
	
	

}
