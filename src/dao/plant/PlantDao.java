package dao.plant;
/**
 * ���
 */
import java.util.List;

import entity.Plate;

public interface PlantDao {
      //��ѯ�������ݰ���
	  List<Plate> getAllPlate();
	  //�޸İ����Ϣ
	  int updatePlate(Plate plate);
	  //ɾ�����
	  int delPlate(int plateid);
	  //���Ӱ����Ϣ
	  int addPlate(Plate plate);
	  //ͨ�����id��ѯ����
	  Plate getByPlateid(int plateid);
	  //���ð��
	  int  IsEnable(int able,int plateid);
	  //ɾ����������Ϣ
	  int delAllPlate(String[] id);
	  //ģ����ѯ�ķ���
	  List<Plate> getAllBytitlePlate(String title);
}
