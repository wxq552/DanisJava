package com.test.dao;

import java.util.List;

import com.test.bean.job;

public interface jobDao {
  public boolean addJob(job job);
  public int getjobcount();
  public List<job> getjobpage(int offSet,int maxResult);
  public boolean deletesinglejob(job job);
  public job getsinglejob(int id);
  public boolean updatejob(job job);
  public boolean deleteMulti(List<job> list);
}
