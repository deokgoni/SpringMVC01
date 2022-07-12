package com.gon.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gon.mapper.UploadMapper;
import com.gon.model.FileVO;

@Service
public class UploadServiceImpl implements UploadService{
	

	@Autowired
	private UploadMapper mapper;
	
	@Override
	public List<FileVO> getList() {
		
		return mapper.getList();
	}

	@Override
	public int Register(FileVO vo) {
		
		int cnt = mapper.insert(vo);
		
		return cnt;
	}

	@Override
	public FileVO get(String id) {
		
		return mapper.read(id);
	}
	



}
