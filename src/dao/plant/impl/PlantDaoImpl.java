package dao.plant.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.plant.PlantDao;
import entity.Plate;
import utils.DButils;

public class PlantDaoImpl implements PlantDao{
    //��ѯ�������ݰ��
	@Override
	public List<Plate> getAllPlate() {
		List<Plate> plate=new ArrayList<Plate>();
		String sql="SELECT * FROM bbs_plate";
		try {
			ResultSet rs=DButils.queryAll(sql, null);
			while(rs.next()) {
				plate.add(new Plate(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plate;
	}
    //�޸İ����Ϣ
	@Override
	public int updatePlate(Plate plate) {
		String sql="UPDATE bbs_plate SET plateTitle=?,plateMessage=? WHERE plateId=?";
		Object params[]= {plate.getPlatetitle(),plate.getPlatemessage(),plate.getPlateid()};
		return DButils.updateAll(sql, params);
	}
    //ɾ�������Ϣ
	@Override
	public int delPlate(int plateid) {
		String sql="DELETE FROM bbs_plate WHERE plateId=?";
		Object params[]= {plateid};
		return DButils.updateAll(sql, params);
	}
    //���Ӱ����Ϣ
	@Override
	public int addPlate(Plate plate) {
		String sql="INSERT INTO bbs_plate(plateTitle,plateMessage) VALUES(?,?)";
		Object params[]= {plate.getPlatetitle(),plate.getPlatemessage()};
		return DButils.updateAll(sql, params);
	}
    //ͨ�����id��ѯ����
	@Override
	public Plate getByPlateid(int plateid) {
		Plate plate=new Plate();
		Object params[]= {plateid};
		String sql="SELECT * FROM bbs_plate where plateId=?";
		try {
			ResultSet rs=DButils.queryAll(sql, params);
			while(rs.next()) {
				plate=new  Plate(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plate;
	}
    //���ð��
	@Override
	public int IsEnable(int able,int plateid) {
		String sql="UPDATE bbs_plate SET isEnable=? WHERE plateId=?";
	    Object params[]= {able,plateid};
		return DButils.updateAll(sql, params);
	}
	//ɾ�����
	public int delAllPlate(String[] id) {
		StringBuffer sql = new StringBuffer("DELETE FROM bbs_plate WHERE plateId IN(");
		// ���ݲ�������ĳ��ȣ�ƴ������Ҫ��?�Ÿ���
		for (int i = 0; i < id.length; i++) {
			sql.append("?");
			if (i != id.length-1) {
				sql.append(",");
			}
		}
		sql.append(")");
		return DButils.updateAll(sql.toString(), id);
	}
	//ģ����ѯ�ķ���
	@Override
	public List<Plate> getAllBytitlePlate(String title) {
		List<Plate> plate=new ArrayList<Plate>();
		Object params[]= {title};
		String sql="SELECT * FROM bbs_plate where plateTitle LIKE CONCAT('%',?,'%')";
		try {
			ResultSet rs=DButils.queryAll(sql, params);
			while(rs.next()) {
				plate.add(new Plate(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plate;
	}

}
