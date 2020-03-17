package entity;

import java.util.Date;

/**
 * Ìû×Ó±í
 * @author »ÆÁú
 *
 */
public class Invitation {
     private String invitationid;
     private String invitationmessage;
     private String userid;
     private int plateid;
     private int categoryid;
     private int ispass;
     private int isenable;
     private int iscream;
     private Date invitationcreate;
     private Date invitationmodify;
	public String getInvitationid() {
		return invitationid;
	}
	public void setInvitationid(String invitationid) {
		this.invitationid = invitationid;
	}
	public String getInvitationmessage() {
		return invitationmessage;
	}
	public void setInvitationmessage(String invitationmessage) {
		this.invitationmessage = invitationmessage;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getPlateid() {
		return plateid;
	}
	public void setPlateid(int plateid) {
		this.plateid = plateid;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public int getIspass() {
		return ispass;
	}
	public void setIspass(int ispass) {
		this.ispass = ispass;
	}
	public int getIsenable() {
		return isenable;
	}
	public void setIsenable(int isenable) {
		this.isenable = isenable;
	}
	public int getIscream() {
		return iscream;
	}
	public void setIscream(int iscream) {
		this.iscream = iscream;
	}
	public Date getInvitationcreate() {
		return invitationcreate;
	}
	public void setInvitationcreate(Date invitationcreate) {
		this.invitationcreate = invitationcreate;
	}
	public Date getInvitationmodify() {
		return invitationmodify;
	}
	public void setInvitationmodify(Date invitationmodify) {
		this.invitationmodify = invitationmodify;
	}
	public Invitation(String invitationid, String invitationmessage, String userid, int plateid, int categoryid,
			int ispass, int isenable, int iscream, Date invitationcreate, Date invitationmodify) {
		super();
		this.invitationid = invitationid;
		this.invitationmessage = invitationmessage;
		this.userid = userid;
		this.plateid = plateid;
		this.categoryid = categoryid;
		this.ispass = ispass;
		this.isenable = isenable;
		this.iscream = iscream;
		this.invitationcreate = invitationcreate;
		this.invitationmodify = invitationmodify;
	}
	public Invitation() {
		super();
	}
     
}
