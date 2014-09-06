package com.test.dao;

import java.util.List;

import com.test.bean.article;

public interface articleDao {
  public boolean addarticle(article art);
  public List<article> getnewspage(int offSet,int maxResult,String type);
  public int getarticleCount(String type);
  public article getSingleart(int id);
  public boolean updateart(article art);
  public boolean deleteart(article art);
  public boolean delartMulti(List<article> list);
}
