package entity;
/**
 * ¹Ø×¢±í
 * @author »ÆÁú
 *
 */

import java.util.Date;

public class Follow {
     private String userid;
     private String buserid;
     private Date followdate;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBuserid() {
		return buserid;
	}
	public void setBuserid(String buserid) {
		this.buserid = buserid;
	}
	public Date getFollowdate() {
		return followdate;
	}
	public void setFollowdate(Date followdate) {
		this.followdate = followdate;
	}
	public Follow(String userid, String buserid, Date followdate) {
		super();
		this.userid = userid;
		this.buserid = buserid;
		this.followdate = followdate;
	}
	public Follow() {
		super();
	}
     
}
