package com.test.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job")
public class job {
 private int id;
 private String unit;
 private String place;
 private String num;
 private String job_name;
 private String job_type;
 private String experience;
 private String quality;
 private String post_time;
 private String description;
 private String requirement;
 private String contactor;
 private String phone;
 private String email;
 @Id
 @GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public String getPlace() {
	return place;
}
public void setPlace(String place) {
	this.place = place;
}
public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
public String getJob_name() {
	return job_name;
}
public void setJob_name(String jobName) {
	job_name = jobName;
}
public String getJob_type() {
	return job_type;
}
public void setJob_type(String jobType) {
	job_type = jobType;
}
public String getExperience() {
	return experience;
}
public void setExperience(String experience) {
	this.experience = experience;
}
public String getQuality() {
	return quality;
}
public void setQuality(String quality) {
	this.quality = quality;
}
public String getPost_time() {
	return post_time;
}
public void setPost_time(String postTime) {
	post_time = postTime;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getRequirement() {
	return requirement;
}
public void setRequirement(String requirement) {
	this.requirement = requirement;
}
public String getContactor() {
	return contactor;
}
public void setContactor(String contactor) {
	this.contactor = contactor;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
 
}
