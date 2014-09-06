package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.Forum;
import com.oa.bean.PageBean;
import com.oa.bean.Topic;
import com.oa.dao.TopicDao;
import com.oa.service.TopicService;
import com.oa.util.QueryHelper;
@Service("topicservice")
public class TopicServiceImpl implements TopicService{
    private TopicDao topicdao;
	public TopicDao getTopicdao() {
		return topicdao;
	}
	@Resource
	public void setTopicdao(TopicDao topicdao) {
		this.topicdao = topicdao;
	}
	public List<Topic> getTopicList(Long forumId) {
		return this.topicdao.getTopicList(forumId);
	}
	public Long add(Topic topic) {
		return this.topicdao.saveTopic(topic);
	}
	public Topic getById(Long id) {
		return this.topicdao.findById(id);
	}
	@Deprecated
	public PageBean getPageBean(int currentPage, int pageSize, Forum forum) {
		return this.topicdao.getPageBean(currentPage, pageSize, forum);
	}
	public PageBean getPageBean(int currentPage, int pageSize,
			QueryHelper queryHelper) {
		return this.topicdao.getPageBean(currentPage, pageSize, queryHelper);
	}
	

}
