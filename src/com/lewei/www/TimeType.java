package com.lewei.www;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeType extends Date {

public static void main(String[] args) throws ParseException {
			
	                    //ͳһ��ʽ, Ϊ�˷��㣬Сʱ..��ȥ����
		  SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd"); 
			 
			//��������ֵ
		  Date dateAfter=df.parse("2011-12-22");   
		    Date dateBefor=df.parse("2011-1-19");
			
		    //����Ҫ�жϵ�Date
		    System.out.println("������������ڸ�ʽΪ yyyy-MM-dd");
		    Scanner scan=new Scanner(System.in);
		    String str=scan.next();
		    
		    //���������String ����ת��ΪDate
		    Date time=df.parse(str);
		   
                                   //�ж�time�Ƿ���XX֮�󣬲��� ��XX֮ǰ
		  if(time.before(dateAfter) && time.after(dateBefor)){
		    	System.out.println(df.format(time)+"�ڴ�����");
		    }
		    else{
		    	System.out.println(df.format(time)+"���ڴ�����");
		    }
			
			}

}