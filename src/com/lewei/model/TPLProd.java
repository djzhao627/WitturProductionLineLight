package com.lewei.model;

/**
 * ���߲�Ʒģ��
 * @author djzhao
 *@time 2015��9��25��
 */
public class TPLProd {

	/** ���� */
	private int TPLProdID;

	/** �������߱�TPLineTable�� */
	private int TPLineID;

	/** ��Ʒ���� */
	private String ProdName;

	/** ��Ʒ����������ģ�Ĭ������10�� */
	private double Takt;
	
	/** ��Ʒ������Ĭ������1��*/
	private int Num;

	/** ״̬��Ĭ��1�� */
	private int Status;

	public int getTPLProdID() {
		return TPLProdID;
	}

	public void setTPLProdID(int tPLProd) {
		TPLProdID = tPLProd;
	}

	public int getTPLineID() {
		return TPLineID;
	}

	public void setTPLineID(int tPLineID) {
		TPLineID = tPLineID;
	}

	public String getProdName() {
		return ProdName;
	}

	public void setProdName(String prodName) {
		ProdName = prodName;
	}

	public double getTakt() {
		return Takt;
	}

	public void setTakt(double takt) {
		Takt = takt;
	}

	public int getNum() {
		return Num;
	}

	public void setNum(int num) {
		Num = num;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

}
