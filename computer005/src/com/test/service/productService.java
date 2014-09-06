package com.test.service;

import java.util.List;

import com.test.bean.production;

public interface productService {
  public boolean addProduct(production pro);
  public List<production> productdetail(int offSet,int maxResult);
  public int getProcount();
  public boolean deletepro(production pro);
  public production getSinglepro(int id);
  public boolean updateproduct(production pro);
  public boolean deleteproductmulti(List<production> list);
  public List<String> findProduct();
  public int getprocountByType(String type);
  public List<production> getPageProType(int offSet,int maxResult,String type);
}
