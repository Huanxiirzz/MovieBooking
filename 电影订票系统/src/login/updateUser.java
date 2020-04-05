package login;
import java.sql.PreparedStatement;
//�޸��û���Ϣ
public class updateUser {
	public updateUser(String userName, String realName, String cardNum,
			String telephone){
			int result=0;
		DB db=new DB();
		try{
			if(db.getConn()!=null){
				PreparedStatement pstmt;
				pstmt=db.getConn().prepareStatement("update userBiao set realName=? where userName=?");
				pstmt.setString(1, realName);//�޸���ʵ����
				pstmt.setString(2, userName);
				result=pstmt.executeUpdate();//ִ��
				pstmt=db.getConn().prepareStatement("update userBiao set cardNum=? where userName=?");
				pstmt.setString(1,cardNum);//�޸����֤��
				pstmt.setString(2, userName);
				result=pstmt.executeUpdate();//ִ��
				pstmt=db.getConn().prepareStatement("update userBiao set telePhone=? where userName=?");
				pstmt.setString(1,telephone);//�޸��ֻ�����
				pstmt.setString(2, userName);
				result=pstmt.executeUpdate();//ִ��
				if (pstmt!=null){
					pstmt.close();
					pstmt=null;
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			db.closeConnection();
		}
	}
}
