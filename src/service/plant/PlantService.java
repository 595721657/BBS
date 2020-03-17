package service.plant;

import java.util.List;

import entity.Plate;

public interface PlantService {
	 //查询所有数据板块表
	  List<Plate> getAllPlate();
	  //修改板块信息
	  boolean updatePlate(Plate plate);
	  //删除板块
	  boolean delPlate(int plateid);
	  //增加板块信息
	  boolean addPlate(Plate plate);
	  //通过板块id查询数据
	  Plate getByPlateid(int plateid);
	  //禁用板块
	  boolean  IsEnable(int able,int plateid);
	  //模糊查询的方法
	  List<Plate> getAllBytitlePlate(String title);
	  //删除多个板块信息
	  boolean delAllPlate(String[] id);
}
