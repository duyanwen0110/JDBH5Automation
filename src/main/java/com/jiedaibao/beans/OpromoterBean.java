package com.jiedaibao.beans;

public class OpromoterBean {
	private String promoterName;
	private String IdCardNo;
	private String telePhoneNo;
	private String email;
	private String province;
	private String city;
	private String cooperSource;
	public String getPromoterName() {
		return promoterName;
	}
	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}
	public String getIdCardNo() {
		return IdCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		IdCardNo = idCardNo;
	}
	public String getTelePhoneNo() {
		return telePhoneNo;
	}
	public void setTelePhoneNo(String telePhoneNo) {
		this.telePhoneNo = telePhoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCooperSource() {
		return cooperSource;
	}
	public void setCooperSource(String cooperSource) {
		this.cooperSource = cooperSource;
	}
	public OpromoterBean(String promoterName, String idCardNo, String telePhoneNo,
			String email, String province, String city, String cooperSource) {
		super();
		this.promoterName = promoterName;
		IdCardNo = idCardNo;
		this.telePhoneNo = telePhoneNo;
		this.email = email;
		this.province = province;
		this.city = city;
		this.cooperSource = cooperSource;
	}
	
}
