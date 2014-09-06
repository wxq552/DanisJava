package com.test.service;

import java.util.List;

import com.test.bean.job;

public interface jobService {
  public boolean saveJob(job job);
  public int getjobCount();
  public List<job> getpagejob(int offSet,int maxResult);
  public boolean deleteonejob(job job);
  public job getonejob(int id);
  public boolean updateJob(job job);
  public boolean deletejobmulti(List<job> list);
}
