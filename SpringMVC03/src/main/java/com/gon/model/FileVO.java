package com.gon.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class FileVO {

	private String id;	
	private String pwd;
	private String name;	
	private String level;	
	private String desc;	
	private Timestamp reg_date;
	private int line;
	
	public FileVO() {
		
	}
	
	public FileVO(String id, String pwd, String name, String level, String desc) {
		
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.level = level;
		this.desc = desc;
	}
	
	public FileVO(String id, String pwd, String name, String level, String desc, int line) {
		
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.level = level;
		this.desc = desc;
		this.line = line;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	


	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	@Override
	public String toString() {
		return "FileVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", level=" + level + ", desc=" + desc
				+ ", reg_date=" + reg_date + ", line=" + line + "]";
	}

	
	
	
}
