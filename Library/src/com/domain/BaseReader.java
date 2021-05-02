package com.domain;
/**
 *  普通的读者
 * @author ASUS
 *
 */
public class BaseReader {
	
	private int id;//id号
	private String userName;//用户名
	private String password;//密码
	private int sex;//性别
	private String mobile;//联系电话
	private String email;//邮箱
	private int userType;//用户类型：0代表普通读者，1代表后台管理员
	private int userState;//用户账户状态，后管理员可以进行注销用户的操作
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getUserState() {
		return userState;
	}
	public void setUserState(int userState) {
		this.userState = userState;
	}
	
	
	
	
	
}
