package login;
import java.sql.PreparedStatement;
//��ӵ�Ӱ��¼
public class insertMovie {
	public insertMovie(String movieNo,String movieName,String director,String actor,String movieIntr,String time,String type,String mlong,String state,String money){
		int result=0;
	String createSql="insert into movieInfo values (?,?,?,?,?,?,?,?,?,?)";//���ݿ�������
	DB db=new DB();//�������ݿ�
	try{
		if(db.getConn()!=null){//�Ѿ��������ݿ�
			PreparedStatement pstmt;
			pstmt=db.getConn().prepareStatement(createSql);
			pstmt.setString(1, movieNo);//���õ�Ӱ���
		      pstmt.setString(2, movieName);//���õ�Ӱ����
			  pstmt.setString(3, director);//���õ���
			  pstmt.setString(4, actor);//��������
			  pstmt.setString(5, movieIntr);//���õ�Ӱ���
			  pstmt.setString(6, time);//������ӳʱ��
			  pstmt.setString(7, type);//��������
			  pstmt.setString(8, mlong);//����Ƭ��
			  pstmt.setString(9, state);//����״̬
			  pstmt.setString(10, money);//����״̬
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
