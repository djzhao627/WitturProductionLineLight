package com.lewei.www;
import java.util.Calendar;

import java.util.Date;

import java.util.Timer;

import java.util.TimerTask;


import javax.swing.JFrame;

import javax.swing.JLabel;

/**

 * 

 * @author wesley

 * @date 2015��1��28��

 *

 */

public class CountDownFram {

 

 private long longTime;

 private long currentTime;

 private long distTime;

 private long day, hour, minutes, seconds;

  

 public CountDownFram() {

 CDown();

 }

  

 public void CDown() {

  Timer timer = new Timer();

  JFrame jf = new JFrame();

  final JLabel jl = new JLabel();

  

  jf.add(jl);

  jf.setVisible(true);

  jf.setSize(350, 100);

  jf.setTitle("����ʱ���");

  jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  

  timer.schedule(new TimerTask() {

   @Override

   public void run() {

    Calendar cal = Calendar.getInstance();

    //����Ԥ����ʱ��

    cal.set(2015, 0, 28, 17, 30, 0);//0����1�� ��11����12��

    // ������Ԫ��ָ��ʱ��ĺ�������

    longTime = cal.getTimeInMillis();

    // ������ 1970 �� 1 �� 1 �� 00:00:00 GMT ������ Date �����ʾ�ĺ�������

    currentTime = new Date().getTime();

    //�����ʱ��

    distTime = longTime - currentTime;

    //�õ�����

    day = ((distTime / 1000) / (3600 * 24));

    //�õ�Сʱ��

    hour = ((distTime / 1000) - day * 86400) / 3600;

    //�õ�������

    minutes = ((distTime / 1000) - day * 86400 - hour * 3600) / 60;

    //�õ�����

    seconds = (distTime / 1000) - day * 86400 - hour * 3600

      - minutes * 60;

    jl.setText("����ʱ" + day + " �� " + hour + "Сʱ :" + minutes

      + "���� :" + seconds + "��");

   }

  }, 0, 1000);

 }

  

 public static void main(String[] args) {

 new CountDownFram();

 }

}