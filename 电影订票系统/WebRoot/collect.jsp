<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.sql.*" %>
<%@ page import="login.DB" %>
<html>
<body>

<% 
  String movieNo=(String)session.getAttribute("movieNo");
  boolean exist=false;
DB db=new DB();//�������ݿ�

String userName=(String)session.getAttribute("userName");
if(userName==null){
%>
<script>alert('������˼������û�е�¼���������ղأ�');</script>
<%
response.addHeader ("refresh", "0.1;URL=userIndex.jsp");
}
  else{
  PreparedStatement pstmt1 = db.getConn().prepareStatement("insert into favorite values (?,?)");
  pstmt1.setString(1,userName);
  pstmt1.setString(2,movieNo);
  pstmt1.execute();
  %>
<script>alert('�ղسɹ���');</script>
<%response.addHeader ("refresh", "0.1;URL=userIndex.jsp");}%>
</body></html>