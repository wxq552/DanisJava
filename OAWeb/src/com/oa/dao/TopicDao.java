package com.oa.dao;

import java.util.List;

import com.oa.base.BaseDao;
import com.oa.bean.Forum;
import com.oa.bean.PageBean;
import com.oa.bean.Topic;
import com.oa.util.QueryHelper;

public interface TopicDao extends BaseDao<Topic>{
	 /**
	    * 根据版块Id查询版块中所有的主题列表
	    * @param forumId
	    * @return
	    */
	   @Deprecated
	   public List<Topic> getTopicList(Long forumId);
	   /**
	    * 保存主题信息
	    * @return
	    */
	   public Long saveTopic(Topic topic);
	   /**
	    * 分页显示板块中的主题列表
	    * @param currentPage
	    * @param pageSize
	    * @param forum
	    * @return
	    */
	   @Deprecated
	   public PageBean getPageBean(int currentPage,int pageSize,Forum forum);
	  
}      