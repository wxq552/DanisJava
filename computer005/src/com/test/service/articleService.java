package com.test.service;

import java.util.List;

import com.test.bean.article;

public interface articleService {
  public boolean savearticle(article art);
  public List<article> getnewsPage(int offSet,int maxResult,String type);
  public int getarticlenum(String type);
  public article getOneart(int id);
  public boolean updateArt(article art);
  public boolean deleteArt(article art);
  public boolean delartMulti(List<article> list);
}
