package com.hex.backend.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.hex.backend.Generators.StringPrefixedSeqIdGenerator;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_seq")
	@GenericGenerator(name = "user_seq",
		strategy="com.hex.backend.Generators.StringPrefixedSeqIdGenerator",
		parameters = {
				@Parameter(name = StringPrefixedSeqIdGenerator.INCREMENT_PARAM, value = "1"),
				@Parameter(name = StringPrefixedSeqIdGenerator.VALUE_PREFIX_PARAMETER, value = "USER"),
				@Parameter(name = StringPrefixedSeqIdGenerator.NUMBER_FORMAT_PARAMETER, value = "23%03d")
		})
	@Column(name="userid")
	private String userId;
	@Column(name="username")
	private String userName;
	@Column(name="useraddress")
	private String userAddress;
	@Column(name="usermail")
	private String userMail;
	@Column(name="userphone")
	private Long userPhone;
	@Column(name="userpassword")
	private String userPassword;
	
	public User() {}

	public User(String userId, String userName, String userAddress, String userMail, Long userPhone,
			String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userMail = userMail;
		this.userPhone = userPhone;
		this.userPassword = userPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public Long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(Long userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userAddress=" + userAddress + ", userMail="
				+ userMail + ", userPhone=" + userPhone + ", userPassword=" + userPassword + "]";
	}

}
