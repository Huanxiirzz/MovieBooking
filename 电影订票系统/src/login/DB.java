package login;
import java.sql.*;
public class DB {
	
	private Connection con=null;
	private Statement stmt=null;
	public ResultSet rs=null;
	public PreparedStatement pstmt=null;
	public DB(){}
	/**���ݿ����ӷ��������Connection����**/
	public Connection getConn(){
		if(con==null){
			getConnection();
		}
		return con;	
	}
	/**���ݿ����ӷ���,���Statement����**/
	public void getConnection()
	{
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");      //����JDBC��������
			String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=database";
	        String user="sa";
	        String password="";
	        con=DriverManager.getConnection(url,user,password);   //����Connection����con
		      System.out.print("���ݿ����ӳɹ�");
		}
		catch(Exception e){
			e.getStackTrace(); System.out.print("���ݿ����Ӳ��ɹ�");
		}
	}
	
	/**�ر�����**/	
	public void closeConnection(){
		try{
			if(rs!=null)
			{rs.close();
			 rs=null;
			 }
			if(stmt!=null)
			{stmt.close();
			 stmt=null;
			 }
			if(con!=null)
			{con.close();
			 con=null;
			 }
			if(pstmt!=null)
			{pstmt.close();
			pstmt=null;
			 }
		}catch(SQLException e){
			e.printStackTrace();
		}
	} 
}

