<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.sql.*" %>
<%@ page import="login.DB" %>
<html>
<body>
<% 
String userName=(String)session.getAttribute("userName");
String movieName=request.getParameter("name");
try{
byte b[]=movieName.getBytes("ISO-8859-1");
movieName=new String(b);
}catch(Exception e){}
System.out.print("movieName="+movieName);
  DB db=new DB();//�������ݿ�
  PreparedStatement pstmt = db.getConn().prepareStatement("delete from record where userName=? and ��Ӱ��=?");
  pstmt.setString(1,userName);
  pstmt.setString(2,movieName);
  pstmt.execute();
  %>
<script>alert('��Ʊ�ɹ���');</script>
<% response.addHeader ("refresh", "0;URL=record.jsp");%>
</body></html>