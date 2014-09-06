package com.oa.dao;
import java.util.List;

import com.oa.base.BaseDao;
import com.oa.bean.PageBean;
import com.oa.bean.Reply;
import com.oa.bean.Topic;
public interface ReplyDao extends BaseDao<Reply>{
	/**
	 * 查询主题的回复列表信息
	 * @param topic
	 * @return
	 */
	@Deprecated
  public List<Reply> getByTopic(Topic topic);
  /**
   * 保存回复信息
   * @param reply
   * @return
   */
  public boolean saveReply(Reply reply);
  /**
   * 分页方法，获得pageBean对象
   * @param currentPage
   * @param pageSize
   * @return
   */
  @Deprecated
  public PageBean getPageBean(int currentPage,int pageSize,Topic topic);
}