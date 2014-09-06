package com.test.dao;

import java.util.List;

import com.test.bean.msg;

public interface messageDao {
  public List<msg> getmsg(int offSet,int maxResult);
  public int getmsgcount();
  public boolean deletesingle(msg msg);
  public boolean deletemulti(List<msg> list);
  public msg getsinglebean(int id);
  public boolean addmes(msg mes);
 
}
