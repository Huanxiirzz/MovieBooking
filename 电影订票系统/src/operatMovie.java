import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import login.DB;
//����Ա�Ե�Ӱ���ݱ���в���
public class operatMovie extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		String operat=request.getParameter("o");//��ȡ��������
		if(operat!=null){//����Ƚ��ѽ��ͣ���Ҫ���͵Ļ���̸
			HttpSession session=request.getSession(true);//����session
		    session.setAttribute("operat",operat);//��ȡ�������Ʋ�����
		    }
		else
		{HttpSession session=request.getSession(true);//����session
		operat=(String)session.getAttribute("operat");//��ȡ�Ա���Ĳ�������
		}
		response.sendRedirect("chooseOperate.jsp");		
		out.println("</body></html>");
}
}
