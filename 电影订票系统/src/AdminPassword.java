import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
import login.DB;

//ͨ�������֤��ʾ����Ա������
public class AdminPassword extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		String realName=request.getParameter("realName");//��ȡ��ʵ����
		byte b[]=realName.getBytes("iso-8859-1");//���Ӵ���
		realName=new String(b);	
		String cardNum=request.getParameter("cardNum");//��ȡ���֤��
		String telephone=request.getParameter("telephone");//��ȡ�ֻ�����
		String adminName=null;//�������Ա����
		String password=null;//�����������
		if(realName.equals("")||cardNum.equals("")||telephone.equals("")){//�����֤��Ϣû����д����
		    out.println("<script>alert('��Ϣδ��д������Ϊ��ת�������֤ҳ�棡');</script>");//����
			response.addHeader ("refresh", "0;URL=adminforget.jsp");//ת�������֤����
		}
		else{//�����֤��Ϣ��д����
			DB db=new DB();//�������ݿ�
			//�����ǲ������ݿ��еļ�¼�Ƿ�͹���Ա�������Ϣһ��
			PreparedStatement pstmt;
			try {
				pstmt = db.getConn().prepareStatement("select * from adminBiao where realName=? and cardNum=? and telePhone=?");
				pstmt.setString(1,realName);
				pstmt.setString(2,cardNum);
				pstmt.setString(3,telephone);
		        ResultSet rs = pstmt.executeQuery();
			    while(rs.next()){//������ݿ��еļ�¼���ڹ���Ա����ļ�¼
				    adminName=rs.getString(1);//��ȡ����Ա
				    password=rs.getString(5);//��ȡ����
			    }
			    if(adminName==null||password==null){//���û�л�ȡ����Ա�����룬˵��û�и�����¼
			    	out.println("<script>alert('�����֤ʧ�ܣ�Ϊ��ת�������֤ҳ�棡');</script>");//����
				    response.addHeader ("refresh", "0;URL=adminforget.jsp"); 
			    }
			    else{//����Ѿ���ȡ����Ա�����룬˵�����ݿ��д��ڸ�����¼

			    	//out.println("<script>alert('����Ա�����벻��Ϊ�գ�');</script>");
			    	out.println("<script>alert('���Ĺ�����Ϊ��"+adminName+"������:"+password+"');</script>");			    	
				    response.addHeader ("refresh", "0;URL=adminLogin.jsp"); 
			    	//out.print("���Ĺ�����Ϊ��"+adminName);//��ʾ����Ա
			    	//out.print("<br>�����ǣ�"+adminName);//��ʾ����
			    }
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		out.println("</body></html>");
	}
}
