package login;

import java.sql.PreparedStatement;
//ͨ���ԡ���Ӱ��š��Ĳ���ɾ���õ�Ӱ��¼
public class deleteMovie {
	public deleteMovie(String movieNo){//movieNoΪ��Ӱ���
			int result=0;
		String createSql="delete from movieInfo where ��Ӱ���=?";//���ݿ�ɾ�����
		DB db=new DB();//�������ݿ�
		try{
			if(db.getConn()!=null){//�Ѿ��������ݿ�
				PreparedStatement pstmt;
				pstmt=db.getConn().prepareStatement(createSql);//Ԥ����
				pstmt.setString(1, movieNo);//�ҵ�movieNo�ļ�¼
				result=pstmt.executeUpdate();//ִ��SQL���
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
