<%@ page contentType="text/html; charset=gb2312" %>
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
	background-image: url(images/movieInfo/detail-bg_03.png);
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
	width:555px;
	height:317px;
	z-index:4;
	left: 317px;
	top: 128px;
}
#bgb1 {
	position:absolute;
	width:781px;
	height:338px;
	z-index:4;
	left: 318px;
	top: 123px;
}
#dingpiao {
	position:absolute;
	width:115px;
	height:41px;
	z-index:5;
	left: 533px;
	top: 236px;
}
#shoucang {
	position:absolute;
	width:115px;
	height:41px;
	z-index:5;
	left: 660px;
	top: 236px;
}
#quxiaoshoucang {
	position:absolute;
	width:115px;
	height:41px;
	z-index:5;
	left: 660px;
	top: 237px;
}
p {
	font-family: Verdana, Geneva, sans-serif;
	font-size: 18px;
	font-style: normal;
	font-weight: bold;
	color: #FFF;
	margin:9px 0px 9px 0px;	
	
}

h3{
 	font-family: Verdana, Geneva, sans-serif;
	font-size: 26px;
	font-style: normal;
	font-weight: bold;
	color: #FFF;
	margin:10px 10px;

}
#apDiv2 {
	position:absolute;
	width:254px;
	height:147px;
	z-index:5;
	top: 64px;
	left: 527px;
}
#apDiv3 {
	position:absolute;
	width:115px;
	height:41px;
	z-index:5;
	left: 645px;
	top: 240px;
}
</style>
<script type="text/javascript">
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; 
  for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++)  
	  x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; 
  if(d.images){ 
	  if(!d.MM_p) 
		  d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; 
    for(i=0; i<a.length; i++)
      if (a[i].indexOf("#")!=0){ 
    	  d.MM_p[j]=new Image; 
    	  d.MM_p[j++].src=a[i];}
    }
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; 
  if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);
   }
  if(!(x=d[n])&&d.all) 
	  x=d.all[n]; 
  for (i=0;!x&&i<d.forms.length;i++) 
	  x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) 
	  x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) 
	  x=d.getElementById(n); 
  return x;
}

 function MM_swapImage() { //v3.0
   var i,j=0,x,a=MM_swapImage.arguments; 
   document.MM_sr=new Array; 
   for(i=0;i<(a.length-2);i+=3)
     if ((x=MM_findObj(a[i]))!=null){
    	 document.MM_sr[j++]=x; 
    	 if(!x.oSrc) x.oSrc=x.src; 
    	 x.src=a[i+2];
     }
}
</script>

<script language="JavaScript" type="text/javascript">
     //�����˳��еĶ�ά���飬�����˳���ʡ�ݵ�˳������ͬ�ġ�ͨ��selectedIndex���ʡ�ݵ��±�ֵ���õ���Ӧ�ĳ�������
     var city=[
     ["���ӰԺ","����Ӱ��","����Ӱ��","��Ӱ��Ӱ��"],
     ["���ӰԺ","��Ӱ����Ӱ��","��Ӱ����Ӱ��IMAX","����Ӱ��"],
     ["���ӰԺ","����Ժ������Ӱ��","��Ӱ��˵�ӰԺ","���Ž���Ӱ��"],
     ["��Ӱ����Ӱ��","�����齭�⴨����Ӱ��"],
     ];
     function getCity(){
         //���ʡ��������Ķ���
         var sltProvince=document.form1.area;
         //��ó���������Ķ���
         var sltCity=document.form1.cinema;         
         //�õ���Ӧʡ�ݵĳ�������
         var provinceCity=city[sltProvince.selectedIndex - 1];
 
         //��ճ��������򣬽�����ʾѡ��
         sltCity.length=1;
 
         //�����������е�ֵ��䵽������������
         for(var i=0;i<provinceCity.length;i++){
             sltCity[i+1]=new Option(provinceCity[i],provinceCity[i]);
         }
     }
 </script>
</head>
 
<body>

<% 
String userName=(String)session.getAttribute("userName");
if(userName==null){
%>

<script>alert('������˼������û�е�¼�������Զ�Ʊ��');</script>
<%
response.addHeader ("refresh", "0.1;URL=userIndex.jsp");
}
else{
  String movieNo=(String)session.getAttribute("movieNo");
  String movieName=(String)session.getAttribute("movieName");
  String director=(String)session.getAttribute("director");
  String actor=(String)session.getAttribute("actor");
  String time=(String)session.getAttribute("time");
  String mlong=(String)session.getAttribute("mlong");
  String money=(String)session.getAttribute("money");
  %>
  
<div id="bgbox">    </div>
<div id="bottom">
  <div id="bottom_box">
    <table width="849" height="50" border="0">
      <tr>
        <td width="212" height="50" align="center"><a href="userIndex.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image4','','images/home/movie-bt-on.png',1)"><img src="images/home/movie-bt-off.png" name="Image4" width="120" height="50" border="0" id="Image4" /></a></td>
        <td width="212" height="50" align="center"><a href="favorite.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image5','','images/home/collect-bt-on.png',1)"><img src="images/home/collect-bt-off.png" name="Image5" width="120" height="50" border="0" id="Image5" /></a></td>
        <td width="212" height="50" align="center"><a href="search.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image6','','images/home/search-bt-on.png',1)"><img src="images/home/search-bt-off.png" name="Image6" width="120" height="50" border="0" id="Image6" /></a></td>
        <td width="212" height="50" align="center"><a href="user.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image7','','images/home/user-bt-on.png',1)"><img src="images/home/user-bt-off.png" name="Image7" width="120" height="50" border="0" id="Image7" /></a></td>
      </tr>
    </table>
  </div>
</div>
<div id="bgb1">
  <table width="781" height="337" border="0">
    <tr>
      <td width="260" height="337" align="left" valign="top">
       
       <h3> <%=movieName %></br></h3>
       <p>���ݣ�</p>
        <p><%=director %></br></p>
         <p>���ݣ�</p>
        <p><%=actor %></br></p>
        
        <p>��ӳʱ�䣺<%=time %></br></p>
        <p>Ƭ����<%=mlong %></br></p>
		<p>�۸�<%=money %></br></p>
		
		
      </td>
      <td width="260" height="337" align="center" valign="middle">
      <h3><img src="movie/<%=movieNo %>.jpg" align="center" width="200" height="300" border="0" alt="" /></h3></td>
      <td width="260" height="337" align="left" valign="top">

     <div id="apDiv2">  
      <form action="key.jsp" method="post" name="form1" id="form1">
      <p>����ѡ�� :&nbsp;
      <select name="area" onchange="getCity()">
        <option value="0">��ѡ�����ڵ��� </option>
        <option value="�࿲">�࿲ </option>
        <option value="ϼɽ">ϼɽ </option>
        <option value="����">���� </option>
        <option value="�⴨">�⴨</option>
      </select>
     </p> 
    <p>ӰԺѡ�� :&nbsp;
      <select name="cinema">
        <option value="0">��ѡ��Ӱ�� </option>
      <option value="���ӰԺ">���ӰԺ</option><option value="����Ӱ��">����Ӱ��</option><option value="����Ӱ��">����Ӱ��</option><option value="��Ӱ��Ӱ��">��Ӱ��Ӱ��</option></select>
    </p>
    <p>һ��Ʊ</p>
    <p>������Ч</p>  
</div>
<div id="apDiv3"><input type="image" src="images/book/enter-bt-on.png"> </div></td>
    </tr>
  </table>
  </form>
</div>
<%} %>
</body></html>