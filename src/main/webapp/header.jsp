<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
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



<!-- 通常表示 -->
<h2><%= title != null ? title : "タイトル未設定" %></h2>
<p>ようこそ、<%= name != null ? name : "ゲスト" %> さん</p>