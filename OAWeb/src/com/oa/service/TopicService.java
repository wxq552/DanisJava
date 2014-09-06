package com.oa.service;
import java.util.List;

import com.oa.bean.Forum;
import com.oa.bean.PageBean;
import com.oa.bean.Topic;
import com.oa.util.QueryHelper;
public interface TopicService {
	/**
	 * 获取主题列表
	 * @param forumId
	 * @return
	 */
	@Deprecated
 public List<Topic> getTopicList(Long forumId);
    /**
     * 保存主题信息
     * @param topic
     * @return
     */
 public Long add(Topic topic);
 /**
  * 查询主题
  * @param id
  * @return
  */
 public Topic getById(Long id);
 /**
  * 分页显示本版块的主题列表
  * @param currentPage
  * @param pageSize
  * @param forum
  * @return
  */
 @Deprecated
 public PageBean getPageBean(int currentPage,int pageSize,Forum forum);
 
 /**
  * 最终版本分页查询方法
  */
 public PageBean getPageBean(int currentPage,int pageSize,QueryHelper queryHelper);

 
}