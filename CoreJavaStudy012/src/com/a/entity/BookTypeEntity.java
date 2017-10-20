package com.a.entity;

public class BookTypeEntity {
	private int id;
	private String typeName;
	public BookTypeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookTypeEntity(int id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "BookTypeEntity [id=" + id + ", typeName=" + typeName + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	

}
