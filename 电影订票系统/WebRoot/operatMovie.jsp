<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.sql.*" %>
<%@ page import="login.DB" %>
<html><body>
<form action="deleteMovie.jsp" method="post">
��ѡ��Ҫɾ����ӰƬ
<% String operat=request.getParameter("o");
   if(operat.equals("delete")){
	  DB db=new DB();
	  ResultSet rs=null;
	  PreparedStatement pstmt;
      pstmt = db.getConn().prepareStatement("select ��Ӱ���,��Ӱ����,����,����  from movieInfo");
	  rs = pstmt.executeQuery();
%>
<Select name="movie">
<% while(rs.next()){%>	
<Option value="<%=rs.getString(1)%>">��<%=rs.getString(2)%>��,<%=rs.getString(3)%>,<%=rs.getString(4)%></Option>")
<% }}%>

<input type="submit" value="ɾ��ӰƬ">
</form>

</body></html>