package login;
import java.sql.*;
//ͨ���ԡ���Ӱ���ơ���ģ�������ҵ��û������ҵĵ�Ӱ
public class searchMovie {
	public searchMovie(String search){//search���û�����Ĺؼ���
		String createSql="select * from movieInfo where ��Ӱ���� like'%"+search+"%' or ����  like'%"+search+"%' or ����  like'%"+search+"%' or ���� like'%"+search+"%'";//ģ���������
		DB db=new DB();//�������ݿ�
		try{
			if(db.getConn()!=null){//���������ݿ�
				Statement stmt;
				stmt=db.getConn().createStatement();
				ResultSet rs=stmt.executeQuery(createSql);//ִ��ģ������
				while(rs.next()){
					System.out.print(rs.getString(2));//��ʾ�ҵ��ĵ�Ӱ����
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			db.closeConnection();
		}
	}
}
