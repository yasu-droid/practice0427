<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%
request.setCharacterEncoding("UTF-8");

// タイトル取得
String title = request.getParameter("title");

// セッション取得
String name = null;
if (session != null) {
	name = (String) session.getAttribute("name");
}
%>

<link rel="stylesheet" href="style.css">
<script>
	function js_alert() {
		alert("Pushed!");
	}
</script>
<!-- 通常表示 -->
<div class="header">

	<div class="title"><%=title != null ? title : "タイトル未設定"%></div>

	<details class="accordion-005">
		<summary>
			<div class="name">
				<%=name != null ? name : "ゲスト"%>
			</div>
		</summary>
		<p>
			<a href="#" onclick="js_alert()"></a>ここ。
		</p>

	</details>
</div>

