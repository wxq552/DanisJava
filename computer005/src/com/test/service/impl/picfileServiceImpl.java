package com.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.test.bean.picfile;
import com.test.dao.picfileDao;
import com.test.service.picfileService;
@Component("picfileservice")
public class picfileServiceImpl implements picfileService{
   private picfileDao picfiledao;

public picfileDao getPicfiledao() {
	return picfiledao;
}
@Resource
public void setPicfiledao(picfileDao picfiledao) {
	this.picfiledao = picfiledao;
}
public boolean savePic(picfile picfile) {
	return this.picfiledao.savepic(picfile);
}
public List<picfile> getpicpage(int firstResult, int maxResult, String type) {
	return this.picfiledao.getpagepic(firstResult, maxResult, type);
}
public int getPicCount(String type) {
	return this.picfiledao.getpiccount(type);
}
public boolean delMultipic(List<picfile> dellist) {
	return this.picfiledao.delmulti(dellist);
}
public boolean delSinglePic(picfile picfile) {
	return this.picfiledao.delOnepic(picfile);
}
public picfile getSinglePic(int id) {
	return this.picfiledao.getOnepic(id);
}
public boolean UpdateSinglePic(picfile picfile) {
	return this.picfiledao.updateOnePic(picfile);
}
   
}
