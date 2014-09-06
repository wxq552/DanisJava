package com.oa.dao.impl;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oa.base.BaseDaoImpl;
import com.oa.bean.Forum;
import com.oa.bean.PageBean;
import com.oa.bean.Reply;
import com.oa.bean.Topic;
import com.oa.dao.TopicDao;
@Repository("topicdao")
@Transactional
@SuppressWarnings("unchecked")
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements TopicDao{

	/**
	 * 查询所有的主题列表
	 */
	@Deprecated
	public List<Topic> getTopicList(Long forumId) {
		return this.getSession().createQuery("FROM Topic t WHERE t.forum.id=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC")
		.setParameter(0,forumId)
		.list();
	}
     /**
      * 保存主题，并为版块做相关设置
      */
	public Long saveTopic(Topic topic) {
		topic.setLastUpdateTime(topic.getPostTime());
	    topic.setLastReply(null);
	    topic.setReplyCount(0);
	    topic.setType(Topic.TYPE_NORMAL);
	    this.getHibernateTemplate().save(topic);
	    Forum forum=topic.getForum();
	    forum.setTopicCount(forum.getTopicCount()+1);
	    forum.setArticleCount(forum.getArticleCount()+1);
	    forum.setLastTopic(topic);
	    this.getHibernateTemplate().update(forum);
		return topic.getId();
	}
	/**
	 * 分页显示本版块的主题列表
	 */
	@Deprecated
	public PageBean getPageBean(int currentPage, int pageSize, Forum forum) {
		List<Topic> recordList=this.getSession().createQuery("FROM Topic t WHERE t.forum.id=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC")
		.setParameter(0,forum.getId())
		.setFirstResult((currentPage-1)*pageSize)
		.setMaxResults(pageSize)
		.list();
		Long recordCount=(Long) this.getSession().createQuery("SELECT COUNT(*) FROM Topic t WHERE t.forum.id=?")
		.setParameter(0,forum.getId())
		.uniqueResult();
		return new PageBean(currentPage,pageSize,recordCount.intValue(),recordList);
	}
	
  
}