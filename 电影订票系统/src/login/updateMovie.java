package login;

import java.sql.PreparedStatement;
//ͨ���ԡ���Ӱ��š��Ĳ���ɾ���õ�Ӱ��¼
public class updateMovie {
	public updateMovie(String movieNo,String movieName,String director,String actor,String movieIntr,String time,String type,String mlong,String state,String money){//movieNoΪ��Ӱ���
			int result=0;
		String createSql="update movieInfo set ��Ӱ����  where ��Ӱ���=?";//���ݿ�ɾ�����
		DB db=new DB();//�������ݿ�
		try{
			if(db.getConn()!=null){//�Ѿ��������ݿ�
				PreparedStatement pstmt;
				pstmt=db.getConn().prepareStatement("update movieInfo set ��Ӱ����=?  where ��Ӱ���=?");
				pstmt.setString(1, movieName);//�޸ĵ�Ӱ����
				pstmt.setString(2, movieNo);
				result=pstmt.executeUpdate();//ִ��
				pstmt=db.getConn().prepareStatement("update movieInfo set ����=?  where ��Ӱ���=?");
				pstmt.setString(1, director);//�޸ĵ���
				pstmt.setString(2, movieNo);
				result=pstmt.executeUpdate();//ִ��
				pstmt=db.getConn().prepareStatement("update movieInfo set ����=?  where ��Ӱ���=?");
				pstmt.setString(1, actor);//�޸�����
				pstmt.setString(2, movieNo);
				result=pstmt.executeUpdate();//ִ��
				pstmt=db.getConn().prepareStatement("update movieInfo set ��Ӱ���=?  where ��Ӱ���=?");
				pstmt.setString(1, movieIntr);//�޸ĵ�Ӱ���
				pstmt.setString(2, movieNo);
				result=pstmt.executeUpdate();//ִ��
				pstmt=db.getConn().prepareStatement("update movieInfo set ��ӳʱ��=?  where ��Ӱ���=?");
				pstmt.setString(1, time);//�޸���ӳʱ��
				pstmt.setString(2, movieNo);
				result=pstmt.executeUpdate();//ִ��
				pstmt=db.getConn().prepareStatement("update movieInfo set ����=?  where ��Ӱ���=?");
				pstmt.setString(1, type);//�޸�����
				pstmt.setString(2, movieNo);
				result=pstmt.executeUpdate();//ִ��
				pstmt=db.getConn().prepareStatement("update movieInfo set Ƭ��=?  where ��Ӱ���=?");
				pstmt.setString(1, mlong);//�޸�Ƭ��
				pstmt.setString(2, movieNo);
				result=pstmt.executeUpdate();//ִ��
				pstmt=db.getConn().prepareStatement("update movieInfo set ״̬=?  where ��Ӱ���=?");
				pstmt.setString(1, state);//�޸�״̬
				pstmt.setString(2, movieNo);
				result=pstmt.executeUpdate();//ִ��
				pstmt=db.getConn().prepareStatement("update movieInfo set Ǯ=?  where ��Ӱ���=?");
				pstmt.setString(1, money);//�޸ļ�Ǯ
				pstmt.setString(2, movieNo);
				result=pstmt.executeUpdate();//ִ��
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			db.closeConnection();
		}
	}
}
