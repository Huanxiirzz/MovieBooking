<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="login.DB"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="keywords" content="JS����,ͼƬ��Ч,JS������,JS��Ч����" />
<meta name="description" content="�˴�������Ϊ��ͼ�������Ч�������Զ����ֶ���������վ�����ô��룬����ͼƬ��Ч���������xw�ز���JS����Ƶ����" />
<title>ͼƬ�����޷���������ֶ����Զ�ͼƬ����_xw�ز���</title>
<link type="text/css" href="css/lrtk.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/lrtk.js"></script>
</head>

<body> 
<br/>  <br/>
<!-- ���뿪ʼ -->
<div class="box">
	<div class="picbox">
		<ul class="piclist mainlist">
<%  DB db=new DB();//�������ݿ�
    PreparedStatement pstmt;
    int count=0;
	try {
		pstmt = db.getConn().prepareStatement("select * from movieInfo where ״̬=?");
		pstmt.setString(1,"������ӳ");
		ResultSet rs = pstmt.executeQuery();
		String movieNo=null;
		String movieName=null;
		while(rs.next()){
		++count;
		    movieNo=rs.getString("��Ӱ���");
		    movieName=rs.getString("��Ӱ����");
		    System.out.print("movieNo="+movieNo);
%>
		    <li>
		    <a href="movieInfo.jsp?name=<%=movieNo%>">
		    <img src="movie/<%=movieNo%>.jpg"  width="220" height="300"> 
		    <br> 
		    <%=movieName%></img>
		    </a>
		    </li>
		    <%
		    }
		    %>
		    </ul>
        <ul class="piclist swaplist"></ul>
	</div>
	<div class="og_prev"></div>
	<div class="og_next"></div>
</div>
<!-- ������� -->
		    <%
		if(movieNo==null){//���������
		%>
		û��������ӳ�ĵ�Ӱ
		<%
		}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
			e.printStackTrace();
	}
	%>
	
</body>
</html>