import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import login.insertMovie;
import login.DB;
//��ӵ�Ӱ��¼��servlet
public class addMovie extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		String movieNo=request.getParameter("movieNo");//��ȡ��Ӱ���
		   String movieName=request.getParameter("movieName");byte b2[]=movieName.getBytes("iso-8859-1");movieName=new String(b2);//��ȡ��Ӱ���Ʋ����к��Ӵ���
		   String director=request.getParameter("director");byte b3[]=director.getBytes("iso-8859-1");director=new String(b3);//��ȡ���ݲ����к��Ӵ���
		   String actor=request.getParameter("actor");byte b4[]=actor.getBytes("iso-8859-1");actor=new String(b4);//��ȡ���ݲ����к��Ӵ���
		   String movieIntr=request.getParameter("movieIntr");byte b5[]=movieIntr.getBytes("iso-8859-1");movieIntr=new String(b5);//��ȡ��Ӱ��鲢���к��Ӵ���	
		   String time=request.getParameter("time");//��ȡ��ӳʱ��
		   String type=request.getParameter("type");byte b7[]=type.getBytes("iso-8859-1");type=new String(b7);//��ȡ���Ͳ����к��Ӵ���	
		   String mlong=request.getParameter("mlong");//��ȡƬ��
		   String money=request.getParameter("money");byte b8[]=money.getBytes("iso-8859-1");money=new String(b8);//��ȡ��Ǯ�����к��Ӵ���
		   String state=request.getParameter("state");byte b9[]=state.getBytes("iso-8859-1");state=new String(b9);//��ȡ״̬�����к��Ӵ���
	   
		   HttpSession session=request.getSession(true);//����һ��session���ڴ洢����
		   session.setAttribute("movieNo",movieNo);
		   session.setAttribute("movieName",movieName);
		   session.setAttribute("director",director);
		   session.setAttribute("actor",actor);
		   session.setAttribute("movieIntr",movieIntr);
		   session.setAttribute("time",time);
		   session.setAttribute("type",type);
		   session.setAttribute("mlong",mlong);
		   session.setAttribute("state",state);
		   session.setAttribute("money",money);
		   if(movieNo==""||movieName==""||director==""||actor==""||movieIntr==""||time==""||type==""||mlong==""||state==""){//�����д����Ϣ����ȫ				
				out.println("<script>alert('��Ϣδ��д������Ϊ��ת��������Ϣҳ�棡');</script>");//����
			    response.addHeader ("refresh", "0;URL=inputMovie.jsp"); //ת��������Ϣ���沢������б�
			}
		   else{//�����Ӱ��Ϣ��д����
			   try {PreparedStatement pstmt=null;DB db=new DB();//�������ݿ�
			   //�����ǲ������ݿ��Ƿ��Ѿ����ڹ���Ա����ĵ�Ӱ���
			  pstmt = db.getConn().prepareStatement("select * from movieInfo where ��Ӱ���=?");
			  pstmt.setString(1,movieNo);
			  ResultSet rs = pstmt.executeQuery();
			  String str="str";
			  while(rs.next()){
				  str=null;
			  }
			  if(str==null){//������ݿ��Ѿ����ڹ���Ա����ĵ�Ӱ���
		      out.println("<script>alert('��Ӱ����Ѵ��ڣ����ʧ�ܣ�');</script>");//����
				response.addHeader ("refresh", "0;URL=inputMovie.jsp"); //ת�������Ӱ��Ϣҳ��
		      }
		      else{//������ݿⲻ���ڹ���Ա����ĵ�Ӱ���
		    	  System.out.print("money="+money);
		    	  insertMovie im=new insertMovie(movieNo,movieName,director,actor,movieIntr,time,type,mlong,state,money);//�����µĵ�Ӱ��¼
			      RequestDispatcher d=request.getRequestDispatcher("addmovie.jsp");//ת����һ��ҳ��		   				
			      try {d.forward(request,response);
			    	} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();}}
		          }catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		   }
		out.println("</body></html>");
	}
}
