<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>
<script>
/* 
function getfile(filename){
	console.log(filename);
	location.href="<c:url value='/download.do'/>?filename="+filename;
}

*/	

	function getList(){
		//alert("aaa");
   	 	$.ajax({
   			url : "<c:url value='/getAjaxList.do'/>",
   			type : "get",
   			//contantType : "application/json;charset=utf-8",
   			dataType : "json",
   			success : resultHtml, 
   			error : function(){ error("error"); }
   			
   		});
   		
	} 
	
	function resultHtml(data){
		console.log(data);
		var html = '<table class="table table-hover">';
		
		html += "<tr>         		";       
        html += "<th>id</th>        ";
        html += "<th>pwd</th>       ";
        html += "<th>name</th>      ";
        html += "<th>level</th>     ";
        html += "<th>desc</th>      ";
        html += "<th>reg_date</th>  ";
      	html += "</tr>              ";
		
      	$.each(data, function(index, obj){
      		
      		html += "<tr>         		";       
            html += "<td>"+obj.id+"</td>        ";
            html += "<td>"+obj.pwd+"</td>       ";
            html += "<td>"+obj.name+"</td>      ";
            html += "<td>"+obj.level+"</td>     ";
            html += "<td>"+obj.desc+"</td>      ";
            html += "<td>"+obj.reg_date+"</td>      ";
           // html += '<fmt:formatDate pattern="yyyy년MM월dd일 hh시mm분ss초" value="${list.reg_date}"/>';
          	html += "</tr>              ";
          	
      	});
      	
      	html += '</table>';
      	
      	$("#demo").html(html);
      	
	}
	
</script>
</head>
<body>
  	<div class="container">
	  	<h2>업로드 결과 화면</h2>
	 
	    <div class="panel panel-default">
	    <div class="panel-heading">
	    	<h3>전체 성공 건 : ${map.successCnt} </h3>
	    </div>
	    <div class="panel-body">
	  		<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo" onclick="getList()">성공 조회</button>
		  <div id="demo" class="collapse">
		  		    
		  </div>
		</div>  
		<div class="panel-footer">
	  		<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo" onclick="location.href='<c:url value="form.do"/>'">업로드 이동</button>
		</div>
	</div>
  	
</div>
</body>
</html>