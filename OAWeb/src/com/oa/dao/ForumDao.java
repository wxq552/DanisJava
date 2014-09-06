package com.oa.dao;
import java.util.List;

import com.oa.base.BaseDao;
import com.oa.bean.Forum;
public interface ForumDao extends BaseDao<Forum>{
	/**
	 * 获取当前记录的前一条记录
	 * @param position
	 * @return
	 */
   /**
    * 根据position查询版块列表
    */
   public List<Forum> findForums();
   /**
    * 实现上移
    * @param id
    */
   public void moveUP(Long id);
   /**
    * 实现下移
    * @param id
    */
   public void moveDOWN(Long id);
  
}