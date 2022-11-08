package Beans;

public class detailDTO {
	private int number;
	private String nickname;
	private String shortpage;
	private String detailpage;
	private String api_latitude;
	private String api_longitude;
	private String imageurl;
	private String textminning1;
	private String textminning2;
	private String textminning3;
	private String textminning4;
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getShortpage() {
		return shortpage;
	}
	public void setShortpage(String shortpage) {
		this.shortpage = shortpage;
	}
	public String getDetailpage() {
		return detailpage;
	}
	public void setDetailpage(String detailpage) {
		this.detailpage = detailpage;
	}
	public String getApi_latitude() {
		return api_latitude;
	}
	public void setApi_latitude(String api_latitude) {
		this.api_latitude = api_latitude;
	}
	public String getApi_longitude() {
		return api_longitude;
	}
	public void setApi_longitude(String api_longitude) {
		this.api_longitude = api_longitude;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getTextminning1() {
		return textminning1;
	}
	public void setTextminning1(String textminning1) {
		this.textminning1 = textminning1;
	}
	public String getTextminning2() {
		return textminning2;
	}
	public void setTextminning2(String textminning2) {
		this.textminning2 = textminning2;
	}
	public String getTextminning3() {
		return textminning3;
	}
	public void setTextminning3(String textminning3) {
		this.textminning3 = textminning3;
	}
	public String getTextminning4() {
		return textminning4;
	}
	public void setTextminning4(String textminning4) {
		this.textminning4 = textminning4;
	}
	
	
	@Override
	public String toString() {
		return "detailDAO [number=" + number + ", shortpage=" + shortpage + ", detailpage=" + detailpage + ", imageurl="
				+ imageurl + "]";
	}

}
