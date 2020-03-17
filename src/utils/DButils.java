package utils;
/**
 * 
 * @author ����
 *���ݿ⹤����
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DButils {
	//������Ҫ�ı���
	private static final String Driver="com.mysql.jdbc.Driver";
	private static final String Url="jdbc:mysql://localhost:3306/bbs?characterEncoding=UTF-8&useUnicode=true";
	private static final String UserName="root";
	private static final String PassWord="1234";
	//������ӵķ���
	private static Connection conn = null;
	private static Connection getConnection(){
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url,UserName,PassWord );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//�ͷ���Դ
	public static void closeAll(ResultSet rst,PreparedStatement pst,Connection conn) {
		try {
			if(rst != null) {
				rst.close();
				}if(pst != null){
					pst.close();
				}if(conn != null) {
					conn.close();
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//ͨ�õ���ɾ�ĵķ���
	public static int updateAll(String sql,Object [] params) {
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			//�жϲ����Ƿ�Ϊ��
			if(params != null) {
				//��ΪSQL��丳ֵ
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i+1, params[i]);
				}
				return pst.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pst, conn);
		}
		return 0;
	}
	
	//ͨ�õĲ�ѯ����
	public static ResultSet queryAll(String sql,Object [] params) {
		ResultSet rst = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			if(params != null) {
				//��ΪSQL��丳ֵ
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i+1, params[i]);
				}
			}
			rst =  pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rst;
	}
    //����һ����ȡϵͳ��ǰʱ��ķ���
    // ����һ��ר�Ÿ������ڸ�ʽת���Ķ���
	SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	//��ȡ��ǰʱ��ķ���
    public String showTime() {	
		return format.format(new Date());	   
	}
}
