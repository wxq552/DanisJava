package com.test.dao;

import java.util.List;

import com.test.bean.production;

public interface productDao {
  public boolean addpro(production pro);
  public List<production> getproducts(int offSet,int maxResult);
  public int getprocount();
  public boolean delete(production pro);
  public production getonepro(int id);
  public boolean updatepro(production pro);
  public boolean deletemulti(List<production> dellist);
  public List<String> findProByType();
  public int getprocountBytype(String type);
  public List<production> getproPageType(int offSet,int maxResult,String type);
}
