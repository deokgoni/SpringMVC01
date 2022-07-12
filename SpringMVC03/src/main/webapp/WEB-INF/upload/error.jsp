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

	
</script>
</head>
<body>
${error}
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