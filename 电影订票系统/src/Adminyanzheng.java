import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import login.DB;;
//����Ա��½ʱ���������
public class Adminyanzheng extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		String admin=request.getParameter("adminName");//��ȡ����Ĺ���Ա	
		String password=request.getParameter("password");//��ȡ���������
		if(admin==""||password==""){//���û��д����
			out.println("<script>alert('����Ա�����벻��Ϊ�գ�');</script>");
		    response.addHeader ("refresh", "0;URL=login.jsp");//ת������Ա��½ҳ�� 
		}
		else{//�������Ա�����붼��д��
		DB db=new DB();//�������ݿ�
		PreparedStatement pstmt;
		try {
			pstmt = db.getConn().prepareStatement("select * from adminBiao where adminName=?");//�������ݿ��Ƿ���ڸù���Ա
			pstmt.setString(1,admin);
	        ResultSet rs = pstmt.executeQuery();
	        String str=null;
		    while(rs.next()){
		    	str=admin;
				if(admin.equals(rs.getString(1))&&password.equals(rs.getString(5))){//�������Ա���������
					out.println("<script>alert('����Ա��½�ɹ���');</script>");//����
					try {
						 RequestDispatcher d=request.getRequestDispatcher("adminIndex.jsp");//ת������Ա��ҳ				   
						d.forward(request,response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   // response.addHeader ("refresh", "0;URL=adminIndex.jsp"); 
				}
				else{//�������Ա�����벻���
					out.println("<script>alert('����Ա���������');</script>");//����
			    response.addHeader ("refresh", "0;URL=login.jsp"); }//ת������Ա��½����			
		    }
		    if(str==null){//���ݿ��в����ڸù���Ա
		    	out.println("<script>alert('����Ա�����ڣ�');</script>");//����
			    response.addHeader ("refresh", "0;URL=login.jsp"); //ת������Ա��½ҳ��
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}				
		out.println("</body></html>");
	}
}
