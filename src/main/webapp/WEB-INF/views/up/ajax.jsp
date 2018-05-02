<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
<style>
.uploadUL li img{
	width:100px;
	height:100px;
	
}

</style>
<img alt="" src="/controller/temp1">

<form id="uploadForm">
<input type='file' id='upload' multiple>
</form>
<button id='btn'>upload</button>
</div>

<div>
<ul class="uploadUL">
</ul>
</div>

<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
  


<script>

var uploadUL = $(".uploadUL");
var uploadInput = $("#upload");

$('#btn').on("click" , function(e){
	
	console.log("click....");
	
	var formData =  new FormData();
	
	console.log(uploadInput[0].files);
	
	var files = uploadInput[0].files;
	
	for(var i=0; i< files.length; i++){
			
		formData.append("file", files[i]);
	
	}
	
	$.ajax({ 
		url: 'ajax', 
		data: formData, 
		processData: false, 
		contentType: false, 
		type: 'POST',
		success: function(data){
			console.log(data);
			
			var str = "";
			for(var i=0; i< data.length; i++){
				str += "<li><img src='/controller/display?file=" +data[i] +"'></li>";
				
			}
			
			uploadUL.append(str);
			
			$("#uploadForm")[0].reset();
			
			}
	
		});
	
});
</script>

</body>
</html>