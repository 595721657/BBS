package service.invitation;

import java.util.List;

import entity.Invitation;

public interface InvitationService {
    //��ѯ���е���Ϣ
	List<Invitation> getall();
	//����id��ѯ����
	Invitation getByid(String id);
	//�޸�����
	boolean updateInvitation(Invitation in);
	//��������
	boolean addInvitation(Invitation in);
	//ɾ����������
	boolean delInvitation(String id);
	//ɾ���������
	boolean delAllInvitation(String[] params);
	//ģ����ѯ
	List<Invitation> getInvitationById(String id);
}
