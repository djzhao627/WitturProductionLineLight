package com.lewei.model;

/**
 * ���ư�ťʵ��ģ��
 * @author djzhao
 *@time 2015��9��25��
 */
public class LightControl {
	
	/** ��վ���*/
	private String WorkStation;
	
	/** ����ɫ�����磺red,blue,green ���� red,none,green��*/
	private String Color;
	
	/** ʱ���¼*/
	private String Time;
	
	/** ״̬��Ĭ��1��*/
	private int Status;

	public String getWorkStation() {
		return WorkStation;
	}

	public void setWorkStation(String workStation) {
		WorkStation = workStation;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

}
