package dao.invitation;

import java.util.List;

import entity.Invitation;

public interface InvitationDao {
    //��ѯ��������
	List<Invitation> getall();
	//����id��ѯ����
	Invitation getByid(String id);
	//�޸�����
	int updateInvitation(Invitation in);
	//��������
	int addInvitation(Invitation in);
	//ɾ����������
	int delInvitation(String id);
	//ɾ���������
	int delAllInvitation(String[] params);
	//ģ����ѯ
	List<Invitation> getInvitationById(String id);
	//��ѯ����˵�������Ϣ
	List<Invitation> getInvitationByPass(int pass);
}
