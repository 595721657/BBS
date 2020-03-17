package utils;
/**
 * 
 * @author 黄龙
 *数据库工具类
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DButils {
	//创建需要的变量
	private static final String Driver="com.mysql.jdbc.Driver";
	private static final String Url="jdbc:mysql://localhost:3306/bbs?characterEncoding=UTF-8&useUnicode=true";
	private static final String UserName="root";
	private static final String PassWord="1234";
	//获得连接的方法
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
	//释放资源
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
	
	//通用的增删改的方法
	public static int updateAll(String sql,Object [] params) {
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			//判断参数是否为空
			if(params != null) {
				//就为SQL语句赋值
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
	
	//通用的查询方法
	public static ResultSet queryAll(String sql,Object [] params) {
		ResultSet rst = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			if(params != null) {
				//就为SQL语句赋值
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
    //创建一个获取系统当前时间的方法
    // 定义一个专门负责日期格式转换的对象
	SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	//获取当前时间的方法
    public String showTime() {	
		return format.format(new Date());	   
	}
}
