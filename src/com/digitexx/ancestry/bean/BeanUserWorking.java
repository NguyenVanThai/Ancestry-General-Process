/**
 * 
 */
package com.digitexx.ancestry.bean;

/**
 * @author lqnhu
 * 
 */
public class BeanUserWorking {

	private long id;
	private long projectid;
	private String userid;
	private int role;

	public long getId() {
		return id;
	}

	public long getProjectid() {
		return projectid;
	}

	public String getUserid() {
		return userid;
	}

	public int getRole() {
		return role;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setProjectid(long projectid) {
		this.projectid = projectid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
