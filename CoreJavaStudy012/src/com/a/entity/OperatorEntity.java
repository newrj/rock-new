package com.a.entity;

import java.util.Date;


public class OperatorEntity {
	private int id;
	private String name;
	private String sex;
	private Date birth;
	private String identityCard;
	private String tel;
	private String admin;
	private String password;
	public OperatorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OperatorEntity(int id, String name, String sex, Date birth,
			String identityCard, String tel, String admin, String password) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.identityCard = identityCard;
		this.tel = tel;
		this.admin = admin;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "OperatorEntity [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", birth=" + birth + ", identityCard=" + identityCard
				+ ", tel=" + tel + ", admin=" + admin + ", password="
				+ password + "]";
	}
	
	
	
	
	

}
