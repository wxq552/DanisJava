package com.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.test.bean.article;
import com.test.dao.articleDao;
import com.test.service.articleService;
@Component("articleservice")
public class articleServiceImpl implements articleService{
  private articleDao articledao;

public articleDao getArticledao() {
	return articledao;
}
@Resource
public void setArticledao(articleDao articledao) {
	this.articledao = articledao;
}
public boolean savearticle(article art) {
	return this.articledao.addarticle(art);
}
public List<article> getnewsPage(int offSet, int maxResult, String type) {
	return this.articledao.getnewspage(offSet, maxResult, type);
}
public int getarticlenum(String type) {
	return this.articledao.getarticleCount(type);
}
public article getOneart(int id) {
	return this.articledao.getSingleart(id);
}
public boolean updateArt(article art) {
	return this.articledao.updateart(art);
}
public boolean deleteArt(article art) {
	return this.articledao.deleteart(art);
}
public boolean delartMulti(List<article> list) {
	return this.articledao.delartMulti(list);
}
}
