package entity;
/**
 * 帖子回复时间
 * @author 黄龙
 *
 */

import java.util.Date;

public class InvitationAns {
      private String ansid;
      private String ansmessage;
      private String invitationid;
      private String userid;
      private Date ansdate;
	public InvitationAns(String ansid, String ansmessage, String invitationid, String userid, Date ansdate) {
		super();
		this.ansid = ansid;
		this.ansmessage = ansmessage;
		this.invitationid = invitationid;
		this.userid = userid;
		this.ansdate = ansdate;
	}
	public InvitationAns() {
		super();
	}
	public String getAnsid() {
		return ansid;
	}
	public void setAnsid(String ansid) {
		this.ansid = ansid;
	}
	public String getAnsmessage() {
		return ansmessage;
	}
	public void setAnsmessage(String ansmessage) {
		this.ansmessage = ansmessage;
	}
	public String getInvitationid() {
		return invitationid;
	}
	public void setInvitationid(String invitationid) {
		this.invitationid = invitationid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getAnsdate() {
		return ansdate;
	}
	public void setAnsdate(Date ansdate) {
		this.ansdate = ansdate;
	}
      
}
