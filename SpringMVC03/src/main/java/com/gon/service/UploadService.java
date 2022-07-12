package com.gon.service;

import java.util.List;
import com.gon.model.FileVO;

public interface UploadService {

	public List<FileVO> getList();
	public int Register(FileVO vo);
	public FileVO get(String id);

	
}
