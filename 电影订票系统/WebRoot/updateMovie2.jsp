<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.sql.*" %>
<%@ page import="login.updateMovie" %>
<%@ page import="login.DB" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>�ޱ����ĵ�</title>
<style type="text/css">
#bgbox {
	position:absolute;
	width:1052px;
	height:449px;
	z-index:1;
	left: 140px;
	top: 40px;
	background-image: url(images/manage/modify/modifysuccess/modifysucess-bg_03.png);
}
td {
	overflow: hidden;
	width:100%;
	word-break:keep-all;
	white-space:nowrap;
	text-overflow:ellipsis;
	font-family: Verdana, Geneva, sans-serif;
	font-size: 20px;
	line-height: 20px;
	color: #DADADA;
	margin: 0px;
	padding: 0px;
}
table {
	table-layout:fixed;
}

#bottom {
	position:absolute;
	width:1055px;
	height:50px;
	z-index:3;
	left: 139px;
	top: 493px;
}
#bottom_box {
	position:absolute;
	width:849px;
	height:50px;
	z-index:1;
	left: 145px;
}
body {
	
	background-color: #313842;
}

#apDiv1 {
	position:absolute;
	width:609px;
	height:265px;
	z-index:4;
	left: 410px;
	top: 130px;
	overflow: hidden;
}
#ss2{
	font-family: Verdana, Geneva, sans-serif;
	font-size: 20px;
	line-height: 20px;
	color: #DADADA;
	margin: 0px;
	padding: 0px;
}


#ss1 {
	font-family: Verdana, Geneva, sans-serif;
	font-size: 20px;
	line-height: 20px;
	color: #DADADA;
	margin: 0px;
	padding: 0px;
}


#apDiv2 {
	position:absolute;
	width:617px;
	height:241px;
	z-index:1;
	left: 255px;
	top: 98px;
}
#apDiv3 {
	position:absolute;
	width:115px;
	height:41px;
	z-index:2;
	left: 776px;
	top: 395px;
}
#apDiv4 {
	position:absolute;
	width:115px;
	height:41px;
	z-index:3;
	left: 912px;
	top: 395px;
}
</style>
<script type="text/javascript">
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
</script>
</head>
<body>
<%         
		   String movieNo=(String)session.getAttribute("movieNo");//��ȡ��Ӱ���
		   String movieName=request.getParameter("movieName");byte b2[]=movieName.getBytes("iso-8859-1");movieName=new String(b2);//��ȡ��Ӱ���Ʋ����к��Ӵ���
		   String director=request.getParameter("director");byte b3[]=director.getBytes("iso-8859-1");director=new String(b3);//��ȡ���ݲ����к��Ӵ���
		   String actor=request.getParameter("actor");byte b4[]=actor.getBytes("iso-8859-1");actor=new String(b4);//��ȡ���ݲ����к��Ӵ���
		   String movieIntr=request.getParameter("movieIntr");byte b5[]=movieIntr.getBytes("iso-8859-1");movieIntr=new String(b5);//��ȡ��Ӱ��鲢���к��Ӵ���	
		   String time=request.getParameter("time");//��ȡ��ӳʱ��
		   String type=request.getParameter("type");byte b7[]=type.getBytes("iso-8859-1");type=new String(b7);//��ȡ���Ͳ����к��Ӵ���	
		   String mlong=request.getParameter("mlong");//��ȡƬ��
		   String money=request.getParameter("money");byte b8[]=money.getBytes("iso-8859-1");money=new String(b8);//��ȡ��Ǯ�����к��Ӵ���
		   String state=request.getParameter("state");byte b9[]=state.getBytes("iso-8859-1");state=new String(b9);//��ȡ״̬�����к��Ӵ���
	   
	   
	   
	   
		   if(movieName==""||director==""||actor==""||movieIntr==""||time==""||type==""||mlong==""||state==""||money==""){//�����д����Ϣ����ȫ				
				out.println("<script>alert('��Ϣδ��д������Ϊ��ת��������Ϣҳ�棡');</script>");//����
			    response.addHeader ("refresh", "0;URL=updateMovie.jsp"); //ת��������Ϣ���沢������б�
			}
		   else{//�����Ӱ��Ϣ��д����
		   updateMovie um=new updateMovie(movieNo,movieName,director,actor,movieIntr,time,type,mlong,state,money);
		   		   System.out.print("movieIntr="+movieIntr);
		   }
 
%>
<div id="bgbox">
  <div id="apDiv2">
    <table width="557" >
     <tr>
      <td width="11%"  height="40" align="center" valign="middle" >���:</td>
      <td width="39%" align="left" ><%=movieNo%></td>
      <td width="25%" align="center" >��ӳ:</td>
      <td width="25%" align="left" ><%=time%></td>
    </tr>
    <tr>
      <td height="40" align="center" valign="middle">����:</td>
      <td align="left">��<%=movieName%>��</td>
      <td align="center">����:</td>
      <td align="left"><%=type%></td>
    </tr>
    <tr>
      <td height="40" align="center" valign="middle">����:</td>
      <td align="left"><%=director%></td>
      <td align="center">Ƭ��:</td>
      <td align="left"><%=mlong%></td>
    </tr>
    <tr>
      <td height="40" align="center" valign="middle">����:</td>
      <td align="left"><%=actor%></td>
      <td align="center">�۸�:</td>
      <td align="left"><%=money%></td>
    </tr>
    <tr>
      <td height="40" align="center" valign="middle">���:</td>
      <td align="left"><%=movieIntr%></td>
      <td align="center">״̬:</td>
      <td align="left"><%=state%></td>
    </tr>
    </table>
  </div>
</div>

<form action="adminIndex.jsp" method=post>
<div id="apDiv3"><input type="image" src="images/manage/add/addsuccess/back-bt-on_03.png"></div>
</form>
<form action="operat" method=post>
<div id="apDiv4"><input type="image" src="images/manage/modify/modifysuccess/keepmodify-bt-on_03.png"></div>
</form>
</body>
</html>