package com.corelogic.rps.rentrolldata.amsi;

public class AMSIInputs {
	private String url;
	private String username;
	private String password;
	private String portfolio;
	private String propertyId;
	private String startFromDate;
	private String startToDate;
	private String tranFromDate;
	private String tranToDate;
	
	
	public String getStartFromDate() {
		return startFromDate;
	}
	public void setStartFromDate(String startFromDate) {
		this.startFromDate = startFromDate;
	}
	public String getStartToDate() {
		return startToDate;
	}
	public void setStartToDate(String startToDate) {
		this.startToDate = startToDate;
	}
	public String getTranFromDate() {
		return tranFromDate;
	}
	public void setTranFromDate(String tranFromDate) {
		this.tranFromDate = tranFromDate;
	}
	public String getTranToDate() {
		return tranToDate;
	}
	public void setTranToDate(String tranToDate) {
		this.tranToDate = tranToDate;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}
	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

}
