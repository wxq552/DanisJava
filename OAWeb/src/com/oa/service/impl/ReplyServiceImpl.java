package com.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.bean.PageBean;
import com.oa.bean.Reply;
import com.oa.bean.Topic;
import com.oa.dao.ReplyDao;
import com.oa.service.ReplyService;
import com.oa.util.QueryHelper;
@Service("replyservice")
public class ReplyServiceImpl implements ReplyService{
    private ReplyDao replydao;
	public ReplyDao getReplydao() {
		return replydao;
	}
	@Resource
	public void setReplydao(ReplyDao replydao) {
		this.replydao = replydao;
	}
	@Deprecated
	public List<Reply> getByTopic(Topic topic) {
		return this.replydao.getByTopic(topic);
	}
	public boolean addReply(Reply reply) {
		return this.replydao.saveReply(reply);
	}
	@Deprecated
	public PageBean getPageBean(int currentPage, int pageSize, Topic topic) {
		return this.replydao.getPageBean(currentPage, pageSize, topic);
	}
	public PageBean getPageBean(int currentPage, int pageSize,
			QueryHelper queryHelper) {
		return this.replydao.getPageBean(currentPage, pageSize, queryHelper);
	}


}
