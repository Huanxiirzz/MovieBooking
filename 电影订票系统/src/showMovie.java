
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import login.DB;

public class showMovie extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
	    ResultSet rs=null;
	    PreparedStatement pstmt;
		DB db=new DB();
		try{
			String operat = null;
			out.print("<input type='radio' name='m' value='���ӰƬ' checked='ok'>���ӰƬ");
			out.print(" <input type='radio' name='m' value='ɾ��ӰƬ'>ɾ��ӰƬ");
			out.print("<input type='radio' name='m' value='�޸�ӰƬ'>�޸�ӰƬ");
			operat="ll";
			operat=request.getParameter("m");
			out.print("operat="+operat);
			pstmt = db.getConn().prepareStatement("select ��Ӱ����  from movieInfo");
	        rs = pstmt.executeQuery();
	        out.print("<br><br><br><Select name='movie'>");
		    while(rs.next()){	
		    	//out.print("<Option value='���'>���</Option>");
		        out.print("<Option value='"+rs.getString(1)+"'>"+rs.getString(1)+"</Option>");// ��������
		    }
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}
}
