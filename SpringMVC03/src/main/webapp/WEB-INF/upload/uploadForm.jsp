<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>
<script>
 	
 	$(document).ready(function(){
 		
		var maxSize = 5242880; //5MB
 		
 		$("#uploadBtn").on("click",function(){
 			console.log($("#uploadFile").val())
 			if($("#uploadFile").val()!=""){
 				
	 			var formData = new FormData();
				var inputFile = $("input[name=uploadFile]");
				var files = inputFile[0].files;
				console.log(files);
				
				for(var i=0; i<files.length; i++){
					if(!checkExtension(files[i].name, files[i].size)){
						return false;
					}
					
					//form submit 
					$(".form-horizontal").submit();	
				
				}
 			}else{
 				alert("파일을 선택하세요.");
 				return false;
 			}
			
 		});
 		
 		function checkExtension(fileName, fileSize){
			console.log(fileName);
 			if(fileSize >= maxSize){
				alert("파일 사이즈 초과");
				return false;
			}
			
 			if(fileName.substring(fileName.lastIndexOf(".")+1, fileName.length).search("dbfile") == -1){  
 	 			alert("dbfile의 파일만 업로드 가능합니다!"); 
 	 			return false;
 	 		} 
			return true;
		}
 		
 	});	
</script>

</head>
<body>
<div class="container">
  <h2>파일 업로드</h2>
  <div class="panel panel-default">
    <div class="panel-heading">
    	<h2 style="color:red; font-style:bord;">${error}</h2>
    </div>
    <div class="panel-body">
    
	<c:out value="${map['errorCnt']}"/>
	${map['errorCnt']}
    
    	<form class="form-horizontal" action="<c:url value='/upload.do'/>" enctype="multipart/form-data" method="post">
    	  
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="">파일추가:</label>
		    <div class="col-sm-10">
		      <input type="file" class="control-label" id="uploadFile" name="uploadFile">
		    </div>
		  </div>	 
		  	 
		  
		</form>    
    
    
    
    </div>
    <div class="panel-footer">
    	<input type="button" id="uploadBtn" value="등록" class="btn btn-primary" />
    
    </div>
  </div>
</div>

</body>
</html>