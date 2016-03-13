package org.ernest.applications.bt.db.manager.comments.ct;

import java.util.Date;

public class CreateCommentInput {

	private String userIdOwner;
	private Date creationDate;
	private String content;
	
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