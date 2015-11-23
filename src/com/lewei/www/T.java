package com.lewei.www;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.lewei.dao.WarningLightDao;
import com.lewei.model.Warning;

public class T {

	public static void main(String[] args) throws ParseException {

		List<String> list = new ArrayList<>();
		System.out.println(list.size());

		 WarningLightDao wld = new WarningLightDao();
		 Warning w = new Warning();
		 w.setCustomerCode("AP;1");
		 w.setStatus(0);
		 w.setWarningHandler("���߰೤");
		 w.setWarningSite("����");
		 w.setWarningType("���ƾ���");
		 try {
		 boolean b = wld.addWittturBtnWarningToLewei(w);
		 System.out.println(b);
		 b = wld.dealWittturBtnWarningToLewei("AP;1");
		 System.out.println(b);
		 } catch (SQLException e1) {
		 e1.printStackTrace();
		 }

		List<String> l = new ArrayList<>();
		l.add("000000");
		System.out.println("list:" + l.get(0));

		java.util.Date datetime = new java.util.Date();
		java.sql.Timestamp time = new java.sql.Timestamp(datetime.getTime());
		System.out.println("java.sql.Date : " + time);

		SimpleDateFormat sdf_ymd = new SimpleDateFormat("yy-MM-dd");

		Date d = sdf_ymd.parse("2015-11-09");
		Calendar c = new GregorianCalendar();
		c.setTime(d);
		c.add(c.DATE, 1);
		d = c.getTime();
		System.out.println(sdf_ymd.format(d));

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
		System.out.println(sdf.parse("23:59:59").getTime() + "---------");
		System.out.println(sdf1.parse("15:00").getTime() + "---------");
		System.out.println("diff: "
				+ (sdf1.parse("15:00").getTime() - sdf.parse("23:59:59")
						.getTime()));
		System.out.println("diff: "
				+ (sdf1.parse("15:00").getTime() - sdf.parse("8:00:00")
						.getTime()));
		System.out.println(sdf.parse("3:59:59").getTime() / 1000
				- sdf.parse("2:59:59").getTime() / 1000);

		for (int i = 10; i < 61; i++) {
			System.out.print(i + ",");
		}
		System.out.println();

		InputStream is = null;
		Workbook wb = null;
		Cell cell = null;
		Sheet sheet = null;
		try {
			is = new FileInputStream("D:\\plan.xls");

			wb = Workbook.getWorkbook(is);

			sheet = wb.getSheet(0);

			cell = sheet.getCell(2, 4);

			System.out.println(cell.getContents());

			wb.close();

			is.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
