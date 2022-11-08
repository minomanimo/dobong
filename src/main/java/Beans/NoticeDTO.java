package Beans;

import java.util.Date;

public class NoticeDTO {
	private String id;
	private String password;
	private String number;
	private String nickname;
	private String title;
	private String content;
	private String writingtime;
	private String changetime;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWritingtime() {
		return writingtime;
	}
	public void setWritingtime(String writingtime) {
		this.writingtime = writingtime;
	}
//	public String getChangetime() {
//		return changetime;
//	}
//	public void setChangetime(String changetime) {
//		this.changetime = changetime;
//	}
//	
	@Override
	public String toString() {
		return "NoticeDTO [id=" + id + ", password=" + password + ", number=" + number + ", nickname=" + nickname
				+ ", title=" + title + ", content=" + content + ", writingtime=" + writingtime + ", changetime="
				+ changetime + "]";
	}
	
	
}
