package com.oa.service;
import java.util.List;

import com.oa.bean.PageBean;
import com.oa.bean.Reply;
import com.oa.bean.Topic;
import com.oa.util.QueryHelper;
public interface ReplyService{
	/**
	 * 查询主题回复列表
	 * @param topic
	 * @return
	 */
	@Deprecated
  public List<Reply> getByTopic(Topic topic);
  /**
   * 添加回复信息
   * @param reply
   * @return
   */
  public boolean addReply(Reply reply);
  /**
   * 分页方法
   * @param currentPage
   * @param pageSize
   * @param topic
   * @return
   */
  @Deprecated
  public PageBean getPageBean(int currentPage,int pageSize,Topic topic);
  /**
   * 最终版本分页查询方法
   * @param currentPage
   * @param pageSize
   * @param queryHelper
   * @return
   */
  public PageBean getPageBean(int currentPage,int pageSize,QueryHelper queryHelper);
  
}