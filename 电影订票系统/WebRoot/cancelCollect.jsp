<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.sql.*" %>
<%@ page import="login.DB" %>
<html>
<body>
<% String userName=(String)session.getAttribute("userName");
  String movieNo=(String)session.getAttribute("movieNo");
  boolean exist=false;
  DB db=new DB();//�������ݿ�
  PreparedStatement pstmt = db.getConn().prepareStatement("delete from favorite where userName=? and ��Ӱ���=?");
  pstmt.setString(1,userName);
  pstmt.setString(2,movieNo);
  pstmt.execute();%>
<script>alert('ȡ���ղسɹ���');</script>
<%
response.addHeader ("refresh", "0.1;URL=userIndex.jsp");
%>
</body></html>