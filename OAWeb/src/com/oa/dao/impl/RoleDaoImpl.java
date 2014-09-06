package com.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.oa.base.BaseDaoImpl;
import com.oa.bean.Role;
import com.oa.dao.RoleDao;
@Repository("roledao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

}
