package com.test.service;

import java.util.List;

import com.test.bean.msg;

public interface messageService {
  public List<msg> getmessages(int offSet,int maxResult);
  public int getcount();
  public boolean deleteone(msg msg);
  public boolean deleteMulti(List<msg> list);
  public msg getonebean(int id);
  public boolean addMess(msg mes);
}
