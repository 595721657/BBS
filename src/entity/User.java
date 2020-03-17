package entity;
/**
 * 用户信息表
 * @author 黄龙
 *
 */

import java.util.Date;

public class User {
      private String userid;
      private String userpsw;
      private String usermail;
      private String usersex;
      private String userphoto;
      private Double userscore;
      private int userlevel;
      private Date leveldown;
      private Date userlock;
      private Date usercreatedate;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpsw() {
		return userpsw;
	}
	public void setUserpsw(String userpsw) {
		this.userpsw = userpsw;
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getUserphoto() {
		return userphoto;
	}
	public void setUserphoto(String userphoto) {
		this.userphoto = userphoto;
	}
	public Double getUserscore() {
		return userscore;
	}
	public void setUserscore(Double userscore) {
		this.userscore = userscore;
	}
	public int getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(int userlevel) {
		this.userlevel = userlevel;
	}
	public Date getLeveldown() {
		return leveldown;
	}
	public void setLeveldown(Date leveldown) {
		this.leveldown = leveldown;
	}
	public Date getUserlock() {
		return userlock;
	}
	public void setUserlock(Date userlock) {
		this.userlock = userlock;
	}
	public Date getUsercreatedate() {
		return usercreatedate;
	}
	public void setUsercreatedate(Date usercreatedate) {
		this.usercreatedate = usercreatedate;
	}
	public User(String userid, String userpsw, String usermail, String usersex, String userphoto, Double userscore,
			int userlevel, Date leveldown, Date userlock, Date usercreatedate) {
		super();
		this.userid = userid;
		this.userpsw = userpsw;
		this.usermail = usermail;
		this.usersex = usersex;
		this.userphoto = userphoto;
		this.userscore = userscore;
		this.userlevel = userlevel;
		this.leveldown = leveldown;
		this.userlock = userlock;
		this.usercreatedate = usercreatedate;
	}
	public User() {
		super();
	}
	public User(String userid, String userpsw, String usermail, String usersex, String userphoto) {
		super();
		this.userid = userid;
		this.userpsw = userpsw;
		this.usermail = usermail;
		this.usersex = usersex;
		this.userphoto = userphoto;
	}
	public User(String userid, String usermail, String usersex, String userphoto) {
		super();
		this.userid = userid;
		this.usermail = usermail;
		this.usersex = usersex;
		this.userphoto = userphoto;
	}          
}
