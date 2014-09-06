package com.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.test.bean.job;
import com.test.dao.jobDao;
import com.test.service.jobService;
@Component("jobservice")
public class jobServiceImpl implements jobService{
  private jobDao jobdao;

public jobDao getJobdao() {
	return jobdao;
}
@Resource
public void setJobdao(jobDao jobdao) {
	this.jobdao = jobdao;
}
public boolean saveJob(job job) {
	return this.jobdao.addJob(job);
}
public int getjobCount() {
	return this.jobdao.getjobcount();
}
public List<job> getpagejob(int offSet, int maxResult) {
	return this.jobdao.getjobpage(offSet, maxResult);
}
public boolean deleteonejob(job job) {
	return this.jobdao.deletesinglejob(job);
}
public job getonejob(int id) {
	return this.jobdao.getsinglejob(id);
}
public boolean updateJob(job job) {
	return this.jobdao.updatejob(job);
}
public boolean deletejobmulti(List<job> list) {
	return this.jobdao.deleteMulti(list);
}
}
