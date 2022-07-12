package com.gon.model;

import java.util.List;

public class ResultVO {
	
	private List<String> fileList;
	private List<FileVO> errorList;
	private List<Integer> errorLineList;
	private int successCnt;
	private int errorCnt;
	
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
	
	@Override
	public String toString() {
		return "ResultVO [fileList=" + fileList + ", errorList=" + errorList + ", errorLineList=" + errorLineList
				+ ", successCnt=" + successCnt + ", errorCnt=" + errorCnt + "]";
	}
	
	
	
	
}
