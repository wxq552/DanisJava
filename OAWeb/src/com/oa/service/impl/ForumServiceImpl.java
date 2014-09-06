package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Forum;
import com.oa.dao.ForumDao;
import com.oa.service.ForumService;
@Service("forumservice")
public class ForumServiceImpl implements ForumService{
private ForumDao forumdao;

public ForumDao getForumdao() {
	return forumdao;
}
@Resource
public void setForumdao(ForumDao forumdao) {
	this.forumdao = forumdao;
}
/**
 * 查询所有的版块列表
 */
public List<Forum> findAll() {
	return this.forumdao.findForums();
}
/**
 * 添加版块
 */
public boolean add(Forum forum) {
	return this.forumdao.save(forum);
}
/**
 * 删除版块
 */
public boolean delete(Forum forum) {
	return this.forumdao.delete(forum);
}
/**
 * 根据Id获取版块
 */
public Forum getById(Long id) {
	return this.forumdao.findById(id);
}
/**
 * 更新版块
 */
public boolean update(Forum forum) {
	return this.forumdao.update(forum);
}
public void movedown(Long id) {
	this.forumdao.moveUP(id);
}
public void moveup(Long id) {
	this.forumdao.moveDOWN(id);
}
}