package com.lewei.www;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Snippet {
	public static void main(String[] args) throws ParseException{
	        SimpleDateFormat formate =   new SimpleDateFormat( "HH:mm" );  
	
	             Date date1=formate.parse("07:00");
	             Date date2=formate.parse("15:00");
	             System.out.println("date1������Ϊ:"+formate.format(date1));
	             System.out.println("date2������Ϊ:"+formate.format(date2));
	             if(formate.parse(formate.format(new Date())).getTime()>date1.getTime() && formate.parse(formate.format(new Date())).getTime()<date2.getTime())
	            	 System.out.println("���");
	             if(date1.getTime()>date2.getTime())
	             {
	                 System.out.println("date1�����ڴ���date2");
	             }
	             else if(date1.getTime()==date2.getTime())
	             {
	                 System.out.println("date2�����ڵ���date1");
	             }
	             else
	             {
	                 System.out.println("date2�����ڴ���date1");             }
}
}

