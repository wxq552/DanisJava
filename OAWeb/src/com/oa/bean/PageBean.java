package com.oa.bean;

import java.util.List;

public class PageBean {
	// 指定的或是页面参数
	private int currentPage; // 当前页
	private int pageSize; // 每页显示多少条

	// 查询数据库
	private int recordCount; // 总记录数
	private List recordList; // 本页的数据列表

	// 计算
	private int pageCount; // 总页数
	private int beginPageIndex; // 页码列表的开始索引（包含）
	private int endPageIndex; // 页码列表的结束索引（包含）
  
  public PageBean(int currentPage,int pageSize,int recordCount,List recordList){
	  this.currentPage=currentPage;
	  this.pageSize=pageSize;
	  this.recordCount=recordCount;
	  this.recordList=recordList;
	   
	  //计算总页数
	  pageCount=(recordCount+pageSize-1)/pageSize;
	  //计算beginPageIndex和endPageIndex
	  if(pageCount<=10){
		  beginPageIndex=1;
		  endPageIndex=10;
	  }else{
		  beginPageIndex=currentPage-4;
		  endPageIndex=currentPage+5;
		  if(beginPageIndex<1){
			  beginPageIndex=1;
			  endPageIndex=10;
		  }
		  if(endPageIndex>pageCount){
			  beginPageIndex=pageCount-10+1;
			  endPageIndex=pageCount;
		  }
	  }
  }
  
public int getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public int getRecordCount() {
	return recordCount;
}
public void setRecordCount(int recordCount) {
	this.recordCount = recordCount;
}
public int getPageCount() {
	return pageCount;
}
public void setPageCount(int pageCount) {
	this.pageCount = pageCount;
}

public List getRecordList() {
	return recordList;
}

public void setRecordList(List recordList) {
	this.recordList = recordList;
}

public int getBeginPageIndex() {
	return beginPageIndex;
}

public void setBeginPageIndex(int beginPageIndex) {
	this.beginPageIndex = beginPageIndex;
}

public int getEndPageIndex() {
	return endPageIndex;
}

public void setEndPageIndex(int endPageIndex) {
	this.endPageIndex = endPageIndex;
}

  
}