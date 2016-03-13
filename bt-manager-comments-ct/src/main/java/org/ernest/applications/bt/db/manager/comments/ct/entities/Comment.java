package org.ernest.applications.bt.db.manager.comments.ct.entities;

import java.util.Date;

public class Comment {

	private String _id;
	private String _rev;
	
	private String userIdOwner;
	private Date creationDate;
	private String content;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String get_rev() {
		return _rev;
	}
	public void set_rev(String _rev) {
		this._rev = _rev;
	}
	public String getUserIdOwner() {
		return userIdOwner;
	}
	public void setUserIdOwner(String userIdOwner) {
		this.userIdOwner = userIdOwner;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}