import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import login.DB;
import login.insertUser;

//����û���¼
public class InsertUser extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
	    String userName=request.getParameter("userName");//��ȡ�û���
	    String realName=request.getParameter("realName");byte b1[]=realName.getBytes("iso-8859-1");realName=new String(b1);//��ȡ��ʵ���������ִ���
	    String cardNum=request.getParameter("cardNum");//��ȡ���֤��
	    String telephone=request.getParameter("telephone");//��ȡ�ֻ�����
	    String password1=request.getParameter("password1");//��ȡ��һ�����������
	    String password2=request.getParameter("password2");//��ȡ�ڶ������������
	    if(userName.equals("")||realName.equals("")||cardNum.equals("")||telephone.equals("")||password1.equals("")||password2.equals("")){//�����Ϣû����д����
	    	out.println("<script>alert('�����Ϣ��������');</script>");//����
		    response.addHeader ("refresh", "0.1;URL=register.jsp"); //ת��ע��ҳ��
	    }
	    else{//�����Ϣ������
	    	if(password1.equals(password2)){//��������һ��
	    		DB db=new DB();//�������ݿ�
	    		//�����ǲ������ݿ����Ƿ����ע����û���
				PreparedStatement pstmt;
				try {
					pstmt = db.getConn().prepareStatement("select * from userBiao where userName=?");
					pstmt.setString(1,userName);
			        ResultSet rs = pstmt.executeQuery();
			        String str=null;
				    while(rs.next()){
				    	str=userName;
				    }
				    if(str==null){//��������ڣ���ע��ɹ��������û���ҳ
				    	insertUser insert=new insertUser(userName,realName,cardNum,telephone,password1);
					    out.println("<script>alert('ע��ɹ���Ϊ��ת����½ҳ�棡');</script>");
					    response.addHeader ("refresh", "0.1;URL=userLogin.jsp");
					}
				    else{//���ݿ��д���ע����û�������ע��ʧ�ܣ�����ע��ҳ��
				    	out.println("<script>alert('�û����ѱ�ע�ᣬ������ע�ᣡ');</script>");
					    response.addHeader ("refresh", "0.1;URL=register.jsp");	    	
				    }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	else{//�������벻һ��
	    		out.println("<script>alert('�����������벻һ�£�������ע�ᣡ');</script>");
			    response.addHeader ("refresh", "0.1;URL=register.jsp");	 //����ע��ҳ��
	    	}
	    }    
		out.println("</body></html>");
	}
}
