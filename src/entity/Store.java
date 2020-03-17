package entity;
/**
 * ÊÕ²ØÌû×Ó±í
 * @author »ÆÁú
 *
 */

import java.util.Date;

public class Store {
    private String userid;
    private String invitationid;
    private Date storedate;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getInvitationid() {
		return invitationid;
	}
	public void setInvitationid(String invitationid) {
		this.invitationid = invitationid;
	}
	public Date getStoredate() {
		return storedate;
	}
	public void setStoredate(Date storedate) {
		this.storedate = storedate;
	}
	public Store(String userid, String invitationid, Date storedate) {
		super();
		this.userid = userid;
		this.invitationid = invitationid;
		this.storedate = storedate;
	}
	public Store() {
		super();
	}
    
}
