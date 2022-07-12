<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

 	function NotReload(){
	    if( (event.ctrlKey == true && (event.keyCode == 78 || event.keyCode == 82)) || (event.keyCode == 116) ) {
	        event.keyCode = 0;
	        event.cancelBubble = true;
	        event.returnValue = false;
	    } 
	}
	document.onkeydown = NotReload; 
	
	function getSuccessList(){
		console.log("aaa");
		var html = '<table class="table table-hover"">';
		
			html += "<tr>         		";       
	        html += "<td>line</td>      ";
	        html += "<td>id</td>        ";
	        html += "<td>pwd</td>       ";
	        html += "<td>name</td>      ";
	        html += "<td>level</td>     ";
	        html += "<td>desc</td>      ";
	        html += "<th>reg_date</th>  ";
      		html += "</tr>              ";
		
		<c:forEach var="vo" items="${map.successList}">
			
			html += "<tr>";
		 	html += "<td>${vo.line}</td> ";
	        html += "<td>${vo.id}</td>   ";
	        html += "<td>${vo.pwd}</td>  ";
	        html += "<td>${vo.name}</td> ";
	        html += "<td>${vo.level}</td>";
	        html += "<td>${vo.desc}</td> ";
	        html += '<td><fmt:formatDate pattern="yyyy년MM월dd일 HH시mm분" value="${vo.reg_date}"/></td>';
	        html += "</tr>";
		
		</c:forEach>
		
		html += '</table>';
      	
      	$("#successDiv").html(html);

	}
	
	$("h3").eq(1).css("style","color=red;");
	
</script>
</head>
<body>
 	
  	<div class="container">
	  	<h2>업로드 전체/일부 실패</h2>
	    <div class="panel panel-default">
	    <div class="panel-heading">
	    	<h3 style="color:blue; font-weight:bold;">성공  ${map.successCnt}건</h3>
	    	<button type="button" class="btn btn-info" onclick="getSuccessList()">성공 조희</button>
	    	
	    	<div id="successDiv">
	    	
	    	</div>
	    </div>
	     <div class="panel-body">
	    
			<div class="table-responsive">          
			  <table class="table table-hover">
			    <thead>
			    </h3><h3  style="color:red; font-weight:bold;">실패 ${map.errorCnt}건</h3>
			     <h3>실패한 라인번호와 리스트 </h3>
			      <tr>
			      	<tr>         
						<th>errorLine</th>        
						<th>id</th>        
						<th>pwd</th>       
						<th>name</th>      
						<th>level</th>     
						<th>desc</th>      
						<th>reg_date</th>  
					</tr>              
			    </thead>
			    <tbody>
			      <tr>
				    <c:forEach var="vo" items="${map.errorList}">
				        <td>${vo.line}</td>
				        <td>${vo.id}</td>
				        <td>${vo.pwd}</td>
				        <td>${vo.name}</td>
				        <td>${vo.level}</td>
				        <td>${vo.desc}</td>
				        <td><fmt:formatDate pattern="yyyy년MM월dd일 HH시mm분" value="${vo.reg_date}"/></td>
				      </tr>
				    </c:forEach>
			    </tbody>
			  </table>
			  </div>
  			</div>
			              
		<div class="panel-footer">
			<button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo" onclick="location.href='<c:url value="form.do"/>'">업로드 이동</button>
			 
	     	
		</div>
	</div>
  	
</div>

</body>
</html>