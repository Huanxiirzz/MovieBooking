<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.sql.*" %>
<%@ page import ="login.DB" %>
<html><body>
<% 
String userName=(String)session.getAttribute("userName");
if(userName==null){
%>
<script>alert('������˼������û�е�¼��');</script>
<%
response.addHeader ("refresh", "0.1;URL=user.jsp");
}
else{
session.invalidate(); 
out.println("<script>alert('�ɹ�ע����');</script>");
response.addHeader ("refresh", "0;URL=userIndex.jsp"); 
}%> 
</body></html>