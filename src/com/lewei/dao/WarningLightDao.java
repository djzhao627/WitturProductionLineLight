package com.lewei.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.lewei.db.MySQLDBUtil;
import com.lewei.db.OracleUtils;
import com.lewei.model.AlarmData;
import com.lewei.model.Takt;

public class WarningLightDao {

	/**
	 * ��ȡ��Ϣʱ��
	 * 
	 * @param rangerNum
	 * @return
	 * @throws Exception
	 */
	public String getRestTime(int rangerNum) throws Exception {

		String time = null;

		Connection conn = MySQLDBUtil.getConn();
		// .ͨ�����ݿ�����Ӳ������ݿ⣨��ɾ�Ĳ飩
		Statement statement = conn.createStatement();
		// ͨ����ѯ���ؽ��
		ResultSet rs = statement
				.executeQuery("select RestTime from tpline where TPLineName = 'AA' and Ranger ="
						+ rangerNum
						+ " and Status = 1 ORDER BY StartTime DESC LIMIT 1");
		// ѭ��ȡ�� rs �еĽ��
		while (rs.next()) {
			time = rs.getString(1);
		}
		rs.close();
		statement.close();
		return time;
	}

	/**
	 * ��ȡTPLineID
	 * 
	 * @param rangerNum
	 * @return
	 * @throws SQLException
	 */
	public int getTPLineIDByName(int rangerNum) throws SQLException {
		int id = 0;
		Connection conn = MySQLDBUtil.getConn();
		Statement statement = conn.createStatement();
		ResultSet rs = statement
				.executeQuery("select TPLineID from tpline where TPLineName = 'AA' and Ranger ="
						+ rangerNum
						+ " and Status = 1 ORDER BY StartTime DESC LIMIT 1");
		while (rs.next()) {
			id = rs.getInt(1);
		}
		rs.close();
		statement.close();
		return id;
	}

	/**
	 * ��ȡ����
	 * 
	 * @param tPLineID
	 * @return
	 * @throws SQLException
	 */
	public List<Takt> getTaktByTPLineID(int tPLineID) throws SQLException {
		List<Takt> list = new ArrayList<>();
		Connection conn = MySQLDBUtil.getConn();
		Statement statement = conn.createStatement();
		ResultSet rs = statement
				.executeQuery("select Takt,Num from tplprod where TPLineID = '"
						+ tPLineID + "' and Status = 1");
		while (rs.next()) {
			Takt t = new Takt();
			t.setTakt(rs.getInt(1));
			t.setNum(rs.getInt(2));
			list.add(t);
		}
		rs.close();
		statement.close();
		return list;
	}

	/**
	 * ��ȡ����ʱ��
	 * 
	 * @param rangerNum
	 * @return
	 * @throws SQLException
	 */
	public String getChangeTime(int rangerNum) throws SQLException {
		String time = null;

		Connection conn = MySQLDBUtil.getConn();
		// .ͨ�����ݿ�����Ӳ������ݿ⣨��ɾ�Ĳ飩
		Statement statement = conn.createStatement();
		// ͨ����ѯ���ؽ��
		ResultSet rs = statement
				.executeQuery("select ChangeTime from tpline where TPLineName = 'AA' and Ranger ="
						+ rangerNum
						+ " and Status = 1 ORDER BY StartTime DESC LIMIT 1");
		// ѭ��ȡ�� rs �еĽ��
		while (rs.next()) {
			time = rs.getString(1);
		}
		rs.close();
		statement.close();
		return time;
	}

	/**
	 * ��ȡ��ť�¼�
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<AlarmData> getNewButtonStat2() throws SQLException {
		List<AlarmData> list = new ArrayList<AlarmData>();
		Connection conn = MySQLDBUtil.getConn();
		// ͨ�����ݿ�����Ӳ������ݿ⣨��ɾ�Ĳ飩
		Statement statement = conn.createStatement();
		// ͨ����ѯ���ؽ��
		ResultSet rs = statement
				.executeQuery("SELECT  id,bid,keyid,ttime,yn,status FROM(SELECT * FROM t_alarmdata WHERE bid BETWEEN 9 AND 12 ORDER BY ttime DESC LIMIT 2000) a GROUP BY a.bid,a.keyid");
		// ѭ��ȡ�� rs �еĽ��
		while (rs.next()) {
			AlarmData ad = new AlarmData();
			ad.setBid(rs.getString("bid"));
			ad.setId(rs.getInt("id"));
			ad.setKeyid(rs.getString("keyid"));
			ad.setStatus(rs.getInt("status"));
			ad.setYn(rs.getInt("yn"));
			list.add(ad);
		}
		rs.close();
		statement.close();
		return list;
	}

	/**
	 * ��ذ�ť״̬
	 */
	public AlarmData getNewButtonStat() throws SQLException {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		AlarmData ad = new AlarmData();
		conn = MySQLDBUtil.getConn();
		// ͨ�����ݿ�����Ӳ������ݿ⣨��ɾ�Ĳ飩
		statement = conn.createStatement();
		// ͨ����ѯ���ؽ��
		rs = statement
				.executeQuery("select id,bid,keyid,ttime,yn,status from t_alarmdata order by id desc limit 1");
		// ѭ��ȡ�� rs �еĽ��
		while (rs.next()) {
			ad.setBid(rs.getString("bid"));
			ad.setId(rs.getInt("id"));
			ad.setKeyid(rs.getString("keyid"));
			ad.setStatus(rs.getInt("status"));
			ad.setYn(rs.getInt("yn"));
		}
		rs.close();
		statement.close();
		return ad;
	}

	/**
	 * ��ǲ���״̬�Ѷ�
	 * @param rangerNum 
	 * 
	 * @throws SQLException
	 */
	public void setTPLineStatusTo0(int rangerNum) throws SQLException {
		Connection conn = MySQLDBUtil.getConn();
		// ͨ�����ݿ�����Ӳ������ݿ⣨��ɾ�Ĳ飩
		Statement statement = conn.createStatement();
		statement
				.executeUpdate("update tpline set Status=0 where Ranger = "+rangerNum+" AND TPLineName = 'AA' and Status = 1");
	}

	/**
	 * ��ȡ����ܲ���
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String getTotalNum0() throws SQLException {
		String totalNum = "0;0";
		Connection conn = MySQLDBUtil.getConn();
		// ͨ�����ݿ�����Ӳ������ݿ⣨��ɾ�Ĳ飩
		Statement statement = conn.createStatement();
		// ͨ����ѯ���ؽ��
		ResultSet rs = statement
				.executeQuery("SELECT TPPlanID,TotalNum FROM tpplan WHERE Ranger = 0 AND TPLineName ='AA' AND STATUS = 1 ORDER BY CreateTime DESC LIMIT 1");
		// ѭ��ȡ�� rs �еĽ��
		while (rs.next()) {
			totalNum = rs.getInt("TotalNum")+";"+rs.getInt("TPPlanID");
		}
		rs.close();
		statement.close();
		return totalNum;
	}

	/**
	 * ��ȡ�а��ܲ���
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String getTotalNum1() throws SQLException {
		String totalNum = "0;0";
		Connection conn = MySQLDBUtil.getConn();
		// ͨ�����ݿ�����Ӳ������ݿ⣨��ɾ�Ĳ飩
		Statement statement = conn.createStatement();
		// ͨ����ѯ���ؽ��
		ResultSet rs = statement
				.executeQuery("SELECT TPPlanID,TotalNum FROM tpplan WHERE Ranger = 1 AND TPLineName ='AA' AND STATUS = 1 ORDER BY CreateTime DESC LIMIT 1");
		// ѭ��ȡ�� rs �еĽ��
		while (rs.next()) {
			totalNum = rs.getInt("TotalNum")+";"+rs.getInt("TPPlanID");
		}
		rs.close();
		statement.close();
		return totalNum;
	}

	/**
	 * ��ȡ����ܲ���
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String getTotalNum2() throws SQLException {
		String totalNum = "0;0";
		Connection conn = MySQLDBUtil.getConn();
		// ͨ�����ݿ�����Ӳ������ݿ⣨��ɾ�Ĳ飩
		Statement statement = conn.createStatement();
		// ͨ����ѯ���ؽ��
		ResultSet rs = statement
				.executeQuery("SELECT TPPlanID,TotalNum FROM tpplan WHERE Ranger = 2 AND TPLineName ='AA' AND STATUS = 1  ORDER BY CreateTime DESC LIMIT 1");
		// ѭ��ȡ�� rs �еĽ��
		while (rs.next()) {
			totalNum = rs.getInt("TotalNum")+";"+rs.getInt("TPPlanID");
		}
		rs.close();
		statement.close();
		return totalNum;
	}

	/**
	 * ��ȡ�ƻ�����
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getPlanIfNum() throws SQLException {
		// TODO Auto-generated method stub
		int planNum = 0;
		Connection conn = MySQLDBUtil.getConn();
		// ͨ�����ݿ�����Ӳ������ݿ⣨��ɾ�Ĳ飩
		Statement statement = conn.createStatement();
		// ͨ����ѯ���ؽ��
		ResultSet rs = statement
				.executeQuery("select PlanNum from tpline where TPLineName = 'AA' and Status = 1");
		// ѭ��ȡ�� rs �еĽ��
		while (rs.next()) {
			planNum = rs.getInt("PlanNum");
		}
		rs.close();
		statement.close();
		return planNum;
	}

	/**
	 * �������ʱ��
	 * 
	 * @param tPLineID
	 * @param lostT
	 * @throws SQLException
	 */
	public void setTPLineLostTime(int tPLineID, String lostT)
			throws SQLException {
		Connection conn = MySQLDBUtil.getConn();
		// ͨ�����ݿ�����Ӳ������ݿ⣨��ɾ�Ĳ飩
		Statement statement = conn.createStatement();
		// ���±�
		statement.executeUpdate("UPDATE tpline SET LostTime = '" + lostT
				+ "' WHERE TPLineID = " + tPLineID);
		statement.close();
	}

	/**
	 * ����ʵ�ʲ���
	 * 
	 * @param tPLineID
	 * @param parseInt
	 * @throws SQLException
	 */
	public void setTPLineRealNum(int tPLineID, int parseInt)
			throws SQLException {
		Connection conn = MySQLDBUtil.getConn();
		// ͨ�����ݿ�����Ӳ������ݿ⣨��ɾ�Ĳ飩
		Statement statement = conn.createStatement();
		// ���±�
		statement.executeUpdate("UPDATE tpline SET RealNum = " + parseInt
				+ " WHERE TPLineID = " + tPLineID);
		statement.close();
	}

	/**
	 * ��ȡ���ʵ�ʲ���
	 * 
	 * @param nowDate
	 * @return
	 * @throws SQLException
	 */
	public int getRealNum_zao() throws SQLException {
		int num = 0;
		Connection connection = OracleUtils.getConnection();
		Statement statement = connection.createStatement();
		Date date = new Date();
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(c.DATE, 1);
		date = c.getTime();
		SimpleDateFormat sdf_ymr = new SimpleDateFormat("yyyy-MM-dd");
		// ��ǰ����
		String now = sdf_ymr.format(new Date());
		// ��һ�� ����
		String next = sdf_ymr.format(date);

		ResultSet rs = statement
				.executeQuery("select GW, sum(case when Crtdate between to_date('"
						+ now
						+ " 07:15:00','yyyy-mm-dd hh24:mi:ss') and to_date('"
						+ now
						+ " 15:14:59','yyyy-mm-dd hh24:mi:ss') then BQUA else 0 end) as ��� from baandb.ttiwcn108220 e,baandb.ttiwcn109220 f where e.BOXID=f.BOXID and ( f.DES1='����') and f.CrtDate between to_date('"
						+ now
						+ " 07:15:00','yyyy-mm-dd hh24:mi:ss') and to_date('"
						+ next
						+ " 07:15:00','yyyy-mm-dd hh24:mi:ss') group by GW");
		while (rs.next()) {
			if (rs.getString(1).equals("AA�Ҽ�")) {
				num = rs.getInt(2);
			}
		}
		rs.close();
		statement.close();
		return num;
	}

	/**
	 * ��ȡ�а�ʵ�ʲ���
	 * 
	 * @param nowDate
	 * @return
	 * @throws SQLException
	 */
	public int getRealNum_zhong() throws SQLException {
		int num = 0;
		Connection connection = OracleUtils.getConnection();
		Statement statement = connection.createStatement();
		Date date = new Date();
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(c.DATE, 1);
		date = c.getTime();
		SimpleDateFormat sdf_ymr = new SimpleDateFormat("yyyy-MM-dd");
		// ��ǰ����
		String now = sdf_ymr.format(new Date());
		// ��һ�� ����
		String next = sdf_ymr.format(date);

		ResultSet rs = statement
				.executeQuery("select GW,sum(case when Crtdate between to_date('"
						+ now
						+ " 15:15:00','yyyy-mm-dd hh24:mi:ss') and to_date('"
						+ now
						+ " 23:14:59','yyyy-mm-dd hh24:mi:ss') then BQUA else 0 end) as �а� from baandb.ttiwcn108220 e,baandb.ttiwcn109220 f where e.BOXID=f.BOXID and ( f.DES1='����') and f.CrtDate between to_date('"
						+ now
						+ " 07:15:00','yyyy-mm-dd hh24:mi:ss') and to_date('"
						+ next
						+ " 07:15:00','yyyy-mm-dd hh24:mi:ss') group by GW");
		while (rs.next()) {
			if (rs.getString(1).equals("AA�Ҽ�")) {
				num = rs.getInt(2);
				System.out.println(num);
			}
		}
		rs.close();
		statement.close();
		return num;
	}

	/**
	 * ��ȡ���ʵ�ʲ���
	 * 
	 * @param nowDate
	 * @return
	 * @throws SQLException
	 */
	public int getRealNum_wan() throws SQLException {
		int num = 0;
		Connection connection = OracleUtils.getConnection();
		Statement statement = connection.createStatement();
		Date date = new Date();
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(c.DATE, 1);
		date = c.getTime();
		SimpleDateFormat sdf_ymr = new SimpleDateFormat("yyyy-MM-dd");
		// ��ǰ����
		String now = sdf_ymr.format(new Date());
		// ��һ�� ����
		String next = sdf_ymr.format(date);

		ResultSet rs = statement
				.executeQuery("select GW,sum(case when Crtdate between to_date('"
						+ now
						+ " 23:15:00','yyyy-mm-dd hh24:mi:ss') and to_date('"
						+ next
						+ " 07:14:59','yyyy-mm-dd hh24:mi:ss') then BQUA else 0 end) as ��� from baandb.ttiwcn108220 e,baandb.ttiwcn109220 f where e.BOXID=f.BOXID and ( f.DES1='����') and f.CrtDate between to_date('"
						+ now
						+ " 07:15:00','yyyy-mm-dd hh24:mi:ss') and to_date('"
						+ next
						+ " 07:15:00','yyyy-mm-dd hh24:mi:ss') group by GW");
		while (rs.next()) {
			if (rs.getString(1).equals("AA�Ҽ�")) {
				num = rs.getInt(2);
			}
		}
		rs.close();
		statement.close();
		return num;
	}

	public void setTPPlanStatusTo0(int tPLineID) throws SQLException {
		Connection conn = MySQLDBUtil.getConn();
		// ͨ�����ݿ�����Ӳ������ݿ⣨��ɾ�Ĳ飩
		Statement statement = conn.createStatement();
		statement.executeUpdate("update tpplan set Status=0 where TPPlanID = "+tPLineID);

	}

}
