package com.lewei.model;

/**
 * ��Ʒ����ģ��
 * @author djzhao
 *@time 2015��9��25��
 */
public class Order {
	
	/** ����*/
	private int TPLPOID;
	
	/** ���������TPLineTable��*/
	private int TPLineID;
	
	/** ��Ʒ˳��*/
	private String Orders;
	
	/** ״̬��Ĭ��1��*/
	private int Status;

	public int getTPLPOID() {
		return TPLPOID;
	}

	public void setTPLPOID(int tPLPOID) {
		TPLPOID = tPLPOID;
	}

	public int getTPLineID() {
		return TPLineID;
	}

	public void setTPLineID(int tPLineID) {
		TPLineID = tPLineID;
	}

	public String getOrders() {
		return Orders;
	}

	public void setOrders(String orders) {
		Orders = orders;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

}
