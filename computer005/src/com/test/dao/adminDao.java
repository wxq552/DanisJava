package com.test.dao;

import com.test.bean.admin;
import com.test.bean.msg;
import com.test.bean.surface;

public interface adminDao {
  public admin getsingle(String username);
  public boolean saveFileInfo(surface sur);
  
}
