package com.test.service;

import java.util.List;

import com.test.bean.picfile;

public interface picfileService {
   public boolean savePic(picfile picfile);
   public List<picfile> getpicpage(int firstResult,int maxResult,String type);
   public int getPicCount(String type);
   public boolean delMultipic(List<picfile> dellist);
   public boolean delSinglePic(picfile picfile);
   public picfile getSinglePic(int id);
   public boolean UpdateSinglePic(picfile picfile);
}
