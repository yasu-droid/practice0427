<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.TimeOptions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSPページ</title>
<link rel="stylesheet" href="style.css">
<script src ="js/countdown_time.js"></script>
</head>

<body class = "timer">
	<!-- HTMLコメント -->
	<h2>タイマー</h2>
	
	<form>
	<label for= "minutes">分を選択:</label>
	<select id = "minutes" >
	
	<%
	List <Integer> options = TimeOptions.getMinuteOptions();
	for(int m :options){
	%>
	<option value = "<%= m%>"><%= m %>分</option>
	<%
	}
	%>
	</select>
	<button type = "button" id = "startBtn" onclick="startTimer()">スタート</button>
	</form>
	<h3 id="timer">ここにタイマーが表示されます</h3>

	<%-- forループのテスト(JSPコメント) --%>

</body>
</html>
