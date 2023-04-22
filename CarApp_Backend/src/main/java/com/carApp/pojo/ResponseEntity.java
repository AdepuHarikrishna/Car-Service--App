package com.carApp.pojo;

public class ResponseEntity {
	
	private int statusCode;
	private Object body;
	private String errMsg;
	public ResponseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseEntity(int statusCode, Object body, String errMsg) {
		super();
		this.statusCode = statusCode;
		this.body = body;
		this.errMsg = errMsg;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	@Override
	public String toString() {
		return "ResponseEntity [statusCode=" + statusCode + ", body=" + body + ", errMsg=" + errMsg + "]";
	}
	
}
