package com.test.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="surface")
public class surface implements java.io.Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int id;
 private String pic_address;

 @Id
 @GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPic_address() {
	return pic_address;
}
public void setPic_address(String picAddress) {
	pic_address = picAddress;
}

}
