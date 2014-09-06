package com.test.dao;

import java.util.List;

import com.test.bean.picfile;

public interface picfileDao {
  public boolean savepic(picfile picfile);
  public List<picfile> getpagepic(int firstResult,int maxResult,String type);
  public int getpiccount(String type);
  public boolean delmulti(List<picfile> dellist);
  public boolean delOnepic(picfile picfile);
  public picfile getOnepic(int id);
  public boolean updateOnePic(picfile picfile);
}
