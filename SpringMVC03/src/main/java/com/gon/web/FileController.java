package com.gon.web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gon.model.FileVO;
import com.gon.model.ResultVO;
import com.gon.service.UploadService;

@Controller
public class FileController {
	
	@Autowired
	private UploadService service;
	
	private static final Logger log = LoggerFactory.getLogger(FileController.class);
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분");
	
	//특수문자 정규식
	String regExp = "[!@#$%^&*(),.?\\\"{}|<>]";		
	
	@GetMapping("/form.do")
	public String formGet() {
		
		return "uploadForm";
	}
	
	@RequestMapping("/upload.do")
	public String upload(MultipartHttpServletRequest multiRequest, Model model, RedirectAttributes redirectAttributes) throws Throwable {
		
		try {
			Map<String, Object> resultMap = saveFile(multiRequest);
			model.addAttribute("map",resultMap);
			
			if((int)resultMap.get("errorCnt")>0) {//error 건수가 있으면 fail.jsp 이동
				return "fail"; 
			}
			
		}catch(Exception e) {
			model.addAttribute("error",e.getMessage()); //에러 넘기기
			return "uploadForm";
		}
		return "success";//error 건수가 없으면 success.jsp 이동
	}
	
	
	//ajax롤 db List 불러오기
	@ResponseBody
	@GetMapping("/getAjaxList.do")
	public void memberAjaxList(HttpServletResponse response) throws IOException {
		
		List<FileVO> list = service.getList();
		
		objectMapper.setDateFormat(sdf);
		
		String gsonList = objectMapper.writeValueAsString(list);
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(gsonList);
	}
	
	
	public Map<String,Object> saveFile(MultipartHttpServletRequest multiRequest) throws Throwable {
		
		int cnt = 0, successCnt = 0, errorCnt = 0;
		
		//파일저장 폴더
		String UPLOAD_DIR="file_dbfile";                                  
		//파일저장 경로
		String uploadPath="C:\\practice"+File.separator+UPLOAD_DIR;
		String saveFilePath = "";
		
		Map<String,Object> map = new HashMap<>();
		List<String> fileList = new ArrayList<>();
		List<FileVO> errorList = new ArrayList<>();
		List<Integer> errorLineList = new ArrayList<>();
		List<FileVO> successList = new ArrayList<>();
		
		Iterator<String> iter = multiRequest.getFileNames(); //파일이름X , 파라미터 이름 (file1, file2)
		
		while(iter.hasNext()) {
			String paramName = iter.next();
			MultipartFile mFile =multiRequest.getFile(paramName);
			String originName = mFile.getOriginalFilename();
			
			File file = new File(uploadPath+"\\"+paramName); //파일 생성
			
			if(mFile.getSize()!=0) { //file이 업로드 되면
				if(!file.exists()) { //file_dbfile폴더가 없으면 생성
					if(file.getParentFile().mkdir()) {
							file.createNewFile();	
					}
				}
				
				saveFilePath = uploadPath+"\\"+originName;
				mFile.transferTo(new File(saveFilePath)); //file을 해당 경로에 저장
				 
			    Scanner scanner = new Scanner(new File(saveFilePath));//들어온 dbfile 읽기         
				  
			    while (scanner.hasNext()) {            
				   String[] inStr = scanner.nextLine().split("/");
				   
				   extractException(inStr); //예외처리
				   
				   cnt = ++cnt;
				   FileVO vo = new FileVO(inStr[0],inStr[1],inStr[2],inStr[3],inStr[4], cnt);
				   
				   //insert 진행, 성공 건 증가
				   try {
					    service.Register(vo);
					    ++successCnt;
					    FileVO successVO = service.get(vo.getId());
					    successVO.setLine(vo.getLine());
					    successList.add(successVO);
					    
				   }catch(Exception e) {
				   //insert 실패 시 에러라인, vo 담기, 실패 건 증가	   
					   FileVO errorVO = service.get(vo.getId());
					   errorVO.setLine(vo.getLine());
					   errorList.add(errorVO);
//						   errorLineList.add(vo.getLine());
					   ++errorCnt;
				   }
			    }//end while
			}
		}//end while

		map.put("fileList", fileList); //List<String>
		map.put("successCnt", successCnt); //int
		map.put("errorCnt", errorCnt); //int
		map.put("errorList", errorList); //List<FileVO>
		map.put("errorLineList", errorLineList); //List<Integer>
		map.put("successList", successList); //List<Integer>
		
		return map;
	}
	
	//예외 처리 
	private void extractException(String[] inStr) throws Throwable {
		 
		  //입력값이 6개 아니면 
		   if(inStr.length != 6) {
			   throw new Exception("필수값의 개수가 맞지않습니다.");
		   }
			   
		   //특수문자 인식, timestamp로 인해 공백인정 ( : , - 제외)
		   for (String string : inStr) {
			   for (int i = 0; i < string.length(); i++) {
				   if(String.valueOf(string.charAt(i)).matches(regExp)) {
					   throw new Exception("특수문자가 있습니다.");
				   }
			   }
		   }
	}

	//파일 생성 uuid
	private String createfileName(String orginalName) {
		String ext = extractExt(orginalName);
		String uuid = UUID.randomUUID().toString();
		return uuid+"."+ext;
	}
	
	
	private String extractExt(String originalFileName) {
		int pos = originalFileName.lastIndexOf(".");
		return originalFileName.substring(pos+1);
	}
	

	
	
//	@RequestMapping("/download.do")
//	public void download(@RequestParam("filename") String filename,
//			HttpServletRequest request,
//			HttpServletResponse response) throws Exception{
//		
//		//String filename=request.getParameter("filename");
//		//System.out.println(filename);		
//		
//		String UPLOAD_DIR="file_repo";                                   // \\, /
//		String uploadPath="C:\\practice"+File.separator+UPLOAD_DIR;
//	
//		File f=new File(uploadPath+"\\"+filename);
//		// 클라이언트로 부터 넘어오는 파일이름에 한글이 있는경우 깨지지 않게하기 위함
//		filename=URLEncoder.encode(filename, "UTF-8");
//		filename=filename.replace("+"," ");
//		// 다운로드 준비로 서버에서 클라이언트에게 다운로드 준비를 시키는 부분(다운로드 창을 띄운다)
//		response.setContentLength((int)f.length());
//		response.setContentType("application/x-msdownload;charset=utf-8");
//		response.setHeader("Content-Disposition", "attachment;filename="+filename+";");
//		response.setHeader("Content-Transfer-Encoding", "binary");
//		response.setHeader("Pragma", "no-cache");
//		response.setHeader("Expires", "0");
//		// 실제 다운로드를 하는 부분
//		FileInputStream in=new FileInputStream(f); //파일읽기 준비
//		OutputStream out=response.getOutputStream();
//		byte[] buffer=new byte[104];
//		while(true) {
//			int count=in.read(buffer);
//			if(count==-1) {
//				break;
//			}
//			out.write(buffer, 0, count); //다운로드(0%......100%)
//		}//_while_
//		in.close();
//		out.close();			
//	}
	

	
	
}













