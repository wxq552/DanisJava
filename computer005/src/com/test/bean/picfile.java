package com.test.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="picfile")
public class picfile implements java.io.Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id",unique=true,nullable=false)
private int id;
@Column(name="pic_address")
private String pic_address;
@Column(name="picname")
private String picname;
@Column(name="savename")
private String savename;
@Column(name="type")  
private String type;
@Column(name="description")
private String description;
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getPicname() {
	return picname;
}
public void setPicname(String picname) {
	this.picname = picname;
}
public String getSavename() {
	return savename;
}
public void setSavename(String savename) {
	this.savename = savename;
}
public String getType() {
	return type;
}
public String getPic_address() {
	return pic_address;
}
public void setPic_address(String pic_address) {
	this.pic_address = pic_address;
}
public void setType(String type) {
	this.type = type;
}
}
