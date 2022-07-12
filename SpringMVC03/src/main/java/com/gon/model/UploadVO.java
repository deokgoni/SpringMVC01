package com.gon.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadVO {

	int cnt = 0, successCnt = 0, errorCnt = 0;
	String saveFilePath = "";
	List<String> fileList = new ArrayList<>();
	List<FileVO> errorList = new ArrayList<>();
	List<Integer> errorLineList = new ArrayList<>();
	List<FileVO> successList = new ArrayList<>();
	
	public UploadVO() {
		
	}

	public UploadVO(String saveFilePath) {
		super();
		this.saveFilePath = saveFilePath;
	}


	public UploadVO(int cnt, int successCnt, int errorCnt, String saveFilePath, List<FileVO> errorList,
			List<FileVO> successList) {
		super();
		this.cnt = cnt;
		this.successCnt = successCnt;
		this.errorCnt = errorCnt;
		this.saveFilePath = saveFilePath;
		this.errorList = errorList;
		this.successList = successList;
	}
	
	public UploadVO(int cnt, int successCnt, int errorCnt, List<FileVO> errorList, List<FileVO> successList) {
		super();
		this.cnt = cnt;
		this.successCnt = successCnt;
		this.errorCnt = errorCnt;
		this.errorList = errorList;
		this.successList = successList;
	}
	public String getSaveFilePath() {
		return saveFilePath;
	}
	public void setSaveFilePath(String saveFilePath) {
		this.saveFilePath = saveFilePath;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getSuccessCnt() {
		return successCnt;
	}
	public void setSuccessCnt(int successCnt) {
		this.successCnt = successCnt;
	}
	public int getErrorCnt() {
		return errorCnt;
	}
	public void setErrorCnt(int errorCnt) {
		this.errorCnt = errorCnt;
	}

	public List<String> getFileList() {
		return fileList;
	}
	public void setFileList(List<String> fileList) {
		this.fileList = fileList;
	}
	public List<FileVO> getErrorList() {
		return errorList;
	}
	public void setErrorList(List<FileVO> errorList) {
		this.errorList = errorList;
	}
	public List<Integer> getErrorLineList() {
		return errorLineList;
	}
	public void setErrorLineList(List<Integer> errorLineList) {
		this.errorLineList = errorLineList;
	}
	public List<FileVO> getSuccessList() {
		return successList;
	}
	public void setSuccessList(List<FileVO> successList) {
		this.successList = successList;
	}
	
	
	
}
