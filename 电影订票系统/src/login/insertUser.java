package login;
import java.sql.PreparedStatement;
//�����ݿ�����û���¼
public class insertUser {
	public insertUser(String userName, String realName, String cardNum,
			String telephone, String password){
			int result=0;
		String createSql="insert into userBiao values (?,?,?,?,?)";//���ݿ�������
		DB db=new DB();//�������ݿ�
		try{
			if(db.getConn()!=null){//���������ݿ�
				PreparedStatement pstmt;
				pstmt=db.getConn().prepareStatement(createSql);
				pstmt.setString(1, userName);//�����û���
				pstmt.setString(2,realName);//������ʵ����
				pstmt.setString(3,cardNum);//�������֤��
				pstmt.setString(4,telephone);//�����ֻ�����
				pstmt.setString(5,password);//��������
				result=pstmt.executeUpdate();//ִ�в������
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
