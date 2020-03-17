package entity;
/**
 * 管理员信息回复表
 * @author 黄龙
 *
 */

import java.util.Date;

public class SystemAns {
      private String systemid;
      private String userid;
      private String message;
      private int isread;
      private Date createdate;
	public String getSystemid() {
		return systemid;
	}
	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getIsread() {
		return isread;
	}
	public void setIsread(int isread) {
		this.isread = isread;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public SystemAns(String systemid, String userid, String message, int isread, Date createdate) {
		super();
		this.systemid = systemid;
		this.userid = userid;
		this.message = message;
		this.isread = isread;
		this.createdate = createdate;
	}
	public SystemAns() {
		super();
	}
      
}
