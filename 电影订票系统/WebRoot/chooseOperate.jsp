<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.sql.*" %>
<%@ page import="login.deleteMovie" %>
<%@ page import="login.DB" %>
<html><body>
<%String operat=(String)session.getAttribute("operat");//��ȡ�Ա���Ĳ�������			
			//*******************����Աɾ��ӰƬ��Ϣ********************************************
			if(operat.equals("delete")){
			try {
				RequestDispatcher d=request.getRequestDispatcher("delmovie0.jsp");		//ת����ӵ�Ӱҳ��		   
					d.forward(request,response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//*******************����Ա���ӰƬ��Ϣ************************************************
			if(operat.equals("add")){			
				try {
				RequestDispatcher d=request.getRequestDispatcher("inputMovie.jsp");		//ת����ӵ�Ӱҳ��		   
					d.forward(request,response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//*******************����Ա�޸�ӰƬ��Ϣ**************************************************
			if(operat.equals("update")){
			try {
				RequestDispatcher d=request.getRequestDispatcher("updmovie0.jsp");		//ת����ӵ�Ӱҳ��		   
					d.forward(request,response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}%>
</body></html>