package dao.plant;
/**
 * 板块
 */
import java.util.List;

import entity.Plate;

public interface PlantDao {
      //查询所有数据板块表
	  List<Plate> getAllPlate();
	  //修改板块信息
	  int updatePlate(Plate plate);
	  //删除板块
	  int delPlate(int plateid);
	  //增加板块信息
	  int addPlate(Plate plate);
	  //通过板块id查询数据
	  Plate getByPlateid(int plateid);
	  //禁用板块
	  int  IsEnable(int able,int plateid);
	  //删除多个板块信息
	  int delAllPlate(String[] id);
	  //模糊查询的方法
	  List<Plate> getAllBytitlePlate(String title);
}
