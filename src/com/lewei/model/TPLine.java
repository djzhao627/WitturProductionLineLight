package com.lewei.model;

/**
 * ����ģ��
 * 
 * @author djzhao
 * @time 2015��9��25��
 */
public class TPLine {

	/** ���� */
	private int TPLineID;

	/** ��������������ƻ���TPPlanTable�� */
	private int TPPlanID;

	/** �������� */
	private String TPLineName;

	/** ��Σ�0Ϊ��࣬1Ϊ�а࣬2Ϊ��ࣩ */
	private int Ranger;

	/** �ƻ����� */
	private int PlanNum;

	/** ʵ�ʲ��� */
	private int RealNum;

	/** �м���Ϣʱ�䣨��ʽ�磺10��00-10��10;12��30-13��00���м��� ';' ���ֲ�ͬʱ��� */
	private String RestTime;

	/** ����ʱ�� */
	private String ChangeTime;

	/** ��ʧ��ʱ�� */
	private String LostTime;

	/** ��վλ������Ϊ�գ���ʽ�磺1,2,3,4,5�� */
	private String WorkStations;

	/** ���߿�ʼʱ�� */
	private String StartTime;

	/** ���߽���ʱ�� */
	private String EndTime;

	/** ����״̬��Ĭ��1 */
	private int Status;

	public int getTPLineID() {
		return TPLineID;
	}

	public void setTPLineID(int tPLineID) {
		TPLineID = tPLineID;
	}

	public int getTPPlanID() {
		return TPPlanID;
	}

	public void setTPPlanID(int tPPlanID) {
		TPPlanID = tPPlanID;
	}

	public String getTPLineName() {
		return TPLineName;
	}

	public void setTPLineName(String tPLineName) {
		TPLineName = tPLineName;
	}

	public int getRanger() {
		return Ranger;
	}

	public void setRanger(int ranger) {
		Ranger = ranger;
	}

	public int getPlanNum() {
		return PlanNum;
	}

	public void setPlanNum(int planNum) {
		PlanNum = planNum;
	}

	public int getRealNum() {
		return RealNum;
	}

	public void setRealNum(int realNum) {
		RealNum = realNum;
	}

	public String getRestTime() {
		return RestTime;
	}

	public void setRestTime(String restTime) {
		RestTime = restTime;
	}

	public String getChangeTime() {
		return ChangeTime;
	}

	public void setChangeTime(String changeTime) {
		ChangeTime = changeTime;
	}

	public String getLostTime() {
		return LostTime;
	}

	public void setLostTime(String lostTime) {
		LostTime = lostTime;
	}

	public String getWorkStations() {
		return WorkStations;
	}

	public void setWorkStations(String workStations) {
		WorkStations = workStations;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public void setEndTime(String endTime) {
		EndTime = endTime;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

}
