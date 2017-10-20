package com.a.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

public class Method {
	
	//��֤���֤��
	public static boolean checkIdCard(String str){
		if(str.length()!=18){
			return false;
		}
		for(int i=0;i<str.length()-1;i++){
			Character ch=str.charAt(i);
			if(Character.isDigit(ch)==false){
				System.out.println("ǰ17λ����Ϊ����");
			}
		}
		char ch2=str.charAt(str.length()-1);
		if(!(ch2=='X'||ch2=='x'||Character.isDigit(ch2)==true)){
			System.out.println("���һλ������X��x������");
			return false;
		}
		int year=Integer.parseInt(str.substring(6,10));
		int month=Integer.parseInt(str.substring(10,12));
		int day=Integer.parseInt(str.substring(12,14));
		if(year==0){
			System.out.println("��ʽ����ȷ");
			return false;
		}
		if(day==0){
			System.out.println("��ʽ����ȷ");
			return false;
		}
		if(!(month>=1&&month<=12)){
			System.out.println("��ʽ����ȷ");
			return false;
		}
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			if(day>31&&day<1){
				System.out.println("��ʽ����ȷ");
				return false;
			}
			
		}
		else if(month==2){
			if(isYear(year)==true){
				if(day>29){
					System.out.println("��ʽ����ȷ");
					return false;
				}
				else{
					if(day>28){
						System.out.println("��ʽ����ȷ");
						return false;
					}
				}
			}
			else{
				if(day>30){
					System.out.println("��ʽ����ȷ");
					return false;
				}
			}
		}
		return true;
 }
	public static boolean isYear(int year1){
		return (year1%4==0&&year1%100!=0)||year1%400==0;
	}
	
	//��֤�ֻ���
	public static boolean checkPhone(String phone){
		if (phone.length() != 11) {
			return false;
		}
		for (int i = 0; i < phone.length(); i++) {
			Character c = phone.charAt(i);
			if (Character.isDigit(c) == false) {
				return false;
			}
		}
		return true;
	}
	
	//��֤����
	public static boolean checkName(String name){
		for(int i=0;i<name.length();i++){
			Character ch=name.charAt(i);
			if(Character.isDigit(ch)==true){
				System.out.println("�������ܰ�������");
				return false;
			}
			//��֤�Ƿ��Ǻ��ֻ�����ĸ
			if((ch <= 0x0391 && ch >= 0xFFE5)  //�����ַ�
					 || (ch<=0x0000 && ch>=0x00FF))//Ӣ���ַ�
			{
				return false;
			}
		}
		
		if(name.length()<2&&name.length()>15){
			return false;
		}
		
		return true;
	}
	
	//----��֤ISBN��
	public static boolean checkISBN(String isbn){
		
		if (isbn.length() != 17) {
			return false;
		}
		String[] array = isbn.split("\\-");
		if (array.length != 5) {
			return false;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i].length() == 0) {
				return false;
			}
		}
		for (int i = 0; i < isbn.length(); i++) {
			Character c = isbn.charAt(i);
			if (Character.isDigit(c) == false && c != '-') {
				return false;
			}
		}
		/*
		int sum=0;
		char cc='0';
		String isbn_1=isbn.replace("-", "");
		
		for (int i=0;i<9;i++){
			int ii=(int)isbn_1.charAt(i)-48;//'0'��ASCIIΪ48
			sum+=ii*(i+1);
		}
		sum=sum%11;
		if(sum==10){        //�����ʮλ��10������X
			cc='X';
		}else{
			cc=(char)(sum+48);
		}
		if(cc==isbn_1.charAt(9)){
			return true;
		}else{
			isbn=isbn.substring(0,12)+cc;
		}       */
		
		return true;
	}
	
	
	//��֤�Ա�
	public static boolean checkSex(String blnSex){
		for (int i = 0; i < blnSex.length(); i++){
			Character ch = blnSex.charAt(i);
			if(ch =='0' || ch == '1'){
				return true;
			}
		}
		
		return false;
	}
	
	//��֤�����������
	public static boolean checkPNumber(String number){
		for(int i = 0; i < number.length() ; i++){
			Character ch = number.charAt(i);
			if(Character.isDigit(ch)==true){
				return true;
			}
		}
		
		return false;
	}
	
	
	// ��֤���ڸ�ʽ
	public static boolean checkDate(String date){
		 SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		 boolean dateflag= true;
		 try{
			 Date da =format.parse(date);
		 }catch(Exception e){
			 dateflag = false;
		 }
		//  �ɹ�true   ʧ��  false
		return dateflag;
	}
	
	//
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


