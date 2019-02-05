package com.todo.webApplication.todo.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@Entity
public class user {

 @Id	
 @GeneratedValue
 private Integer id;
 @Size(min=2)
 private String username;
 private String firstName;
 private String lastName;
 @ApiModelProperty(notes="birth date should be in past ")
 @Past
 private Date dateOfBirth;
 private String eMail;
 
 protected user() {}
public user(Integer id, String username, String firstName, String lastName, Date dateOfBirth, String eMail) {
	super();
	this.id = id;
	this.username = username;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.eMail = eMail;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String geteMail() {
	return eMail;
}
public void seteMail(String eMail) {
	this.eMail = eMail;
}
@Override
public String toString() {
	return "user [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", dateOfBirth=" + dateOfBirth + ", eMail=" + eMail + "]";
}

 
}
