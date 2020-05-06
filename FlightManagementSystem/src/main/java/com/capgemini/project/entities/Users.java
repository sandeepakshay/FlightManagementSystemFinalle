package com.capgemini.project.entities;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Users")
public class Users implements Serializable {

	@Id
	@Column(length=5)
	public int UserId;
	
	@Column(length=10)
	BigInteger UserPhone;
	
    @Column(length=25)
	String UserType;
	
	@Column(length=25)
	String UserName;
	
	@Column(length=25)
	String password;
	
    
	String email;

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public BigInteger getUserPhone() {
		return UserPhone;
	}

	public void setUserPhone(BigInteger userPhone) {
		UserPhone = userPhone;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
