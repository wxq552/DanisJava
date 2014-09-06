package com.test.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class article {
 private int id;
 private String title;
 private String content;
 private String posttime;
 private String type;
 private String author;
 private int count;
 @Id
 @GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getPosttime() {
	return posttime;
}
public void setPosttime(String posttime) {
	this.posttime = posttime;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
@Column(columnDefinition="int default 0") 
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}

}
