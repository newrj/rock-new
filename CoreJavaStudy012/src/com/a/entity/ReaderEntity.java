package com.a.entity;

import java.util.Date;

public class ReaderEntity {
	private int readerId;
	private String name;
	private String sex;
	private Date birth;
	private String identityCard;
	private int maxNum;
	private String tel;
	private int keepMoney;
	private Date createdate;
	public ReaderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReaderEntity(int readerId, String name, String sex, Date birth,
			String identityCard, int maxNum, String tel, int keepMoney,
			Date createdate) {
		super();
		this.readerId = readerId;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.identityCard = identityCard;
		this.maxNum = maxNum;
		this.tel = tel;
		this.keepMoney = keepMoney;
		this.createdate = createdate;
	}
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getKeepMoney() {
		return keepMoney;
	}
	public void setKeepMoney(int keepMoney) {
		this.keepMoney = keepMoney;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "ReaderEntity [readerId=" + readerId + ", name=" + name
				+ ", sex=" + sex + ", birth=" + birth + ", identityCard="
				+ identityCard + ", maxNum=" + maxNum + ", tel=" + tel
				+ ", keepMoney=" + keepMoney + ", createdate=" + createdate
				+ "]";
	}
	 
	

}
