package com.a.util;

public class Parameter {
	public static final int IN=1;
	public static final int OUT=2;
	
	public Object param;  //�洢�Ĳ���ֵ
	public int direction=1;// ����Ϊ��ֵ�����κ�ֵ��ʱ��Ĭ�ϸò���Ϊ�������͵Ĳ���
	
	
	public Parameter(Object param, int direction) {
		super();
		this.param = param;
		this.direction = direction;
	}
	public Parameter(){
		super();
	}
	@Override
	public String toString() {
		return "Parameter [param=" + param + ", direction=" + direction + "]";
	}
	

}
