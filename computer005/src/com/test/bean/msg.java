package com.test.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class msg {
  private int id;
  private String topic;
  private String content;
  private String custom;
  private String contactor;
  private String contact_phone;
  private String qq;
  @Id
  @GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTopic() {
	return topic;
}
public void setTopic(String topic) {
	this.topic = topic;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getCustom() {
	return custom;
}
public void setCustom(String custom) {
	this.custom = custom;
}
public String getContactor() {
	return contactor;
}
public void setContactor(String contactor) {
	this.contactor = contactor;
}
public String getContact_phone() {
	return contact_phone;
}
public void setContact_phone(String contactPhone) {
	contact_phone = contactPhone;
}
public String getQq() {
	return qq;
}
public void setQq(String qq) {
	this.qq = qq;
}
  
}
