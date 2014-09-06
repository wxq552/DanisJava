package com.oa.dao.impl;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.ForumDao;
import com.oa.bean.Forum;
import com.oa.base.BaseDaoImpl;
@Repository("forumdao")
@Transactional
public class ForumDaoImpl extends BaseDaoImpl<Forum> implements ForumDao{

	public List<Forum> findForums() {
		return this.getSession().createQuery("FROM Forum f ORDER BY f.position ASC").list();
	}
	
	@Override
	public boolean save(Forum forum) {
		// 保存
		boolean flag=super.save(forum);
		// 设置position的值
		forum.setPosition(forum.getId().intValue());
		return flag;
	}
	
    /**
     * 实现上移
     */
	public void moveUP(Long id){
		//获取当前的记录
		Forum current=this.findById(id);
		//获取前面的记录
		Forum before=(Forum) this.getSession().createQuery("FROM Forum f WHERE f.position<? ORDER BY f.position DESC")
		.setParameter(0, current.getPosition())
		.setFirstResult(0)
		.setMaxResults(1).uniqueResult();
		//====交换上下两条记录的position
		
		if(before==null){
			return;
		}
		
		int temp=current.getPosition();
		current.setPosition(before.getPosition());
		before.setPosition(temp);
		//====更新到数据库
		this.getSession().update(current);
		this.getSession().update(before);
	}
	/**
	 * 实现下移
	 */
	public void moveDOWN(Long id){
		//获取当前的记录
		Forum current=this.findById(id);
		//获取前面的记录
		Forum after=(Forum) this.getSession().createQuery("FROM Forum f WHERE f.position>? ORDER BY f.position ASC")
		.setParameter(0, current.getPosition())
		.setFirstResult(0)
		.setMaxResults(1).uniqueResult();
		//====交换上下两条记录的position
		
		if(after==null){
			return;
		}
		
		int temp=current.getPosition();
		current.setPosition(after.getPosition());
		after.setPosition(temp);
		//====更新到数据库
		this.getSession().update(current);
		this.getSession().update(after);
	}


}