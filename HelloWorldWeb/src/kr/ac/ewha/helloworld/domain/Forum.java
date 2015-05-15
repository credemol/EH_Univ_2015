package kr.ac.ewha.helloworld.domain;

import java.sql.Timestamp;

public class Forum {
	private int id;
	private ForumType forumType = ForumType.ALL;
	private String title;
	private int createUserid;
	private Timestamp createTimestamp;
	private int lastUpdateUserid;
	private Timestamp lastUpdateTimestamp;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ForumType getForumType() {
		return forumType;
	}
	public void setForumType(ForumType forumType) {
		this.forumType = forumType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCreateUserid() {
		return createUserid;
	}
	public void setCreateUserid(int createUserid) {
		this.createUserid = createUserid;
	}
	public Timestamp getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	public int getLastUpdateUserid() {
		return lastUpdateUserid;
	}
	public void setLastUpdateUserid(int lastUpdateUserid) {
		this.lastUpdateUserid = lastUpdateUserid;
	}
	public Timestamp getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}
	public void setLastUpdateTimestamp(Timestamp lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
