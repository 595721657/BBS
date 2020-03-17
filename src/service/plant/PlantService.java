package service.plant;

import java.util.List;

import entity.Plate;

public interface PlantService {
	 //��ѯ�������ݰ���
	  List<Plate> getAllPlate();
	  //�޸İ����Ϣ
	  boolean updatePlate(Plate plate);
	  //ɾ�����
	  boolean delPlate(int plateid);
	  //���Ӱ����Ϣ
	  boolean addPlate(Plate plate);
	  //ͨ�����id��ѯ����
	  Plate getByPlateid(int plateid);
	  //���ð��
	  boolean  IsEnable(int able,int plateid);
	  //ģ����ѯ�ķ���
	  List<Plate> getAllBytitlePlate(String title);
	  //ɾ����������Ϣ
	  boolean delAllPlate(String[] id);
}
