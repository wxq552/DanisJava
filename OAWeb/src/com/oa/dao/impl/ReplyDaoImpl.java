package com.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oa.base.BaseDaoImpl;
import com.oa.bean.Forum;
import com.oa.bean.PageBean;
import com.oa.bean.Reply;
import com.oa.bean.Topic;
import com.oa.dao.ReplyDao;
@Repository("replydao")
@SuppressWarnings("unchecked")
@Transactional
public class ReplyDaoImpl extends BaseDaoImpl<Reply> implements ReplyDao{

    /**
     * 查询主题回复列表
     */
	@Deprecated
	public List<Reply> getByTopic(Topic topic) {
		return this.getSession().createQuery("FROM Reply r WHERE r.topic.id=? ORDER BY r.postTime ASC")
		.setParameter(0,topic.getId())
		.list();
	}
    /**
     * 保存回复信息，并设置主题的相关信息
     */
	public boolean saveReply(Reply reply) {
		this.getHibernateTemplate().save(reply);
		Topic topic=reply.getTopic();
		Forum forum=topic.getForum();
		topic.setLastUpdateTime(reply.getPostTime());
		topic.setLastReply(reply);
		topic.setReplyCount(topic.getReplyCount()+1);
		forum.setArticleCount(forum.getArticleCount()+1);
		this.getHibernateTemplate().update(forum);
		this.getHibernateTemplate().update(topic);
		return false;
	}
	/**
	 * 实现分页方法
	 */
	@Deprecated
	public PageBean getPageBean(int currentPage, int pageSize,Topic topic) {
		List<Reply> recordList=this.getSession().createQuery("FROM Reply r WHERE r.topic.id=? ORDER BY r.postTime ASC")
		.setParameter(0,topic.getId())
		.setFirstResult((currentPage-1)*pageSize)
		.setMaxResults(pageSize)
		.list();
		Long recordCount=(Long) this.getSession().createQuery("SELECT COUNT(*) FROM Reply r WHERE r.topic.id=?")
		.setParameter(0,topic.getId())
		.uniqueResult();
		return new PageBean(currentPage,pageSize,recordCount.intValue(),recordList);
	}

}