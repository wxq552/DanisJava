package com.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.test.bean.msg;
import com.test.dao.messageDao;
import com.test.service.messageService;
@Component("messageservice")
public class messageServiceImpl implements messageService{
    private messageDao messagedao;
	public messageDao getMessagedao() {
		return messagedao;
	}
    @Resource
	public void setMessagedao(messageDao messagedao) {
		this.messagedao = messagedao;
	}

    public List<msg> getmessages(int offSet, int maxResult) {
    	return this.messagedao.getmsg(offSet, maxResult);
    }

    public boolean deleteone(msg msg) {
    	return this.messagedao.deletesingle(msg);
    }
    public int getcount() {
    	return this.messagedao.getmsgcount();
    }
    public boolean deleteMulti(List<msg> list) {
    	return this.messagedao.deletemulti(list);
    }
	public msg getonebean(int id) {
		return this.messagedao.getsinglebean(id);
	}
	public boolean addMess(msg mes) {
		return this.messagedao.addmes(mes);
	}
	


}
