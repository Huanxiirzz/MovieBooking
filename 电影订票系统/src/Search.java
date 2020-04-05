import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import login.DB;
import login.insertMovie;
import login.searchMovie;;
public class Search extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out=response.getWriter();
		String search=request.getParameter("search");
		if(search!=null){
			try{byte b[]=search.getBytes("iso-8859-1");
			search=new String(b);}catch(Exception e){}
		
			boolean exist=false;
			String createSql="select * from movieInfo where ��Ӱ���� like'%"+search+"%' or ����  like'%"+search+"%'";//ģ���������
			DB db=new DB();//�������ݿ�
			try{
				if(db.getConn()!=null){//���������ݿ�
					Statement stmt;
					stmt=db.getConn().createStatement();
					ResultSet rs=stmt.executeQuery(createSql);//ִ��ģ������
					while(rs.next()){
						exist=true;
						String movieNo=rs.getString("��Ӱ���");
						String movieName=rs.getString("��Ӱ����");
						String director=rs.getString("����");
						String actor=rs.getString("����");
						String time=rs.getString("��ӳʱ��");
						String type=rs.getString("����");
						String mlong=rs.getString("Ƭ��");
						out.print("<table border=1><tr>");
						out.print("<td><a href='movieInfo.jsp?name="+movieNo+"'><img src='movie/"+movieNo+".jpg' width='200' height='300' align='left'></img></a></td>");//��ʾ�ҵ��ĵ�Ӱ
						out.println("<td width='500' height='210'>"+movieName);
						out.println("<br>���ݣ�"+director);
						out.println("<br>���ݣ�"+actor);
						out.println("<br>���ͣ�"+type);
						out.println("<br>��ӳʱ�䣺"+time);
						out.println("<br>Ƭ����"+mlong);
						out.print("</tr></table>");
					}
				}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				db.closeConnection();
			}
		}
		else{
			out.println("<script>alert('����δ����ؼ��֣�');</script>");//����
		    response.addHeader ("refresh", "0.1;URL=search.jsp"); //ת������ҳ��
		}
		out.println("<html><body>");
		out.println("");
		out.println("</body></html>");
	}	

}
