package com.test.service;

import com.test.bean.admin;
import com.test.bean.msg;
import com.test.bean.surface;

public interface adminService {
  public admin getone(String username);
  public boolean savefileinfo(surface sur);
 
}
