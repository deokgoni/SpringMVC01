package com.gon.mapper;

import java.util.List;
import com.gon.model.FileVO;

public interface UploadMapper {
	
	public List<FileVO> getList();
	
	public int insert(FileVO vo);
	
	public FileVO read(String id);
	
}
