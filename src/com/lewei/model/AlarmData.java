package com.lewei.model;

public class AlarmData {
	/** ��¼id*/
	private int id;
	
	/** ����id*/
	private String bid;
	
	/** �������*/
	private String keyid;
	
	/** ����ʱ��*/
	private String ttime;
	
	/** ��������״̬ 1���� 0̧��*/
	private int yn;
	
	/** ״̬δ*/
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getKeyid() {
		return keyid;
	}

	public void setKeyid(String keyid) {
		this.keyid = keyid;
	}

	public String getTtime() {
		return ttime;
	}

	public void setTtime(String ttime) {
		this.ttime = ttime;
	}

	public int getYn() {
		return yn;
	}

	public void setYn(int yn) {
		this.yn = yn;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
