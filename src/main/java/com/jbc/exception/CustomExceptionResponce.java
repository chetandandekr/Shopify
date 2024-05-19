package com.jbc.exception;

public class CustomExceptionResponce {

	private String path;
	private String timeStamp;
	private String msg;
	
	public CustomExceptionResponce() {
		// TODO Auto-generated constructor stub
	}

	public CustomExceptionResponce(String path, String timeStamp, String msg) {
		super();
		this.path = path;
		this.timeStamp = timeStamp;
		this.msg = msg;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "CustomExceptionResponce [path=" + path + ", timeStamp=" + timeStamp + ", msg=" + msg + "]";
	}
	
	
	
	
}
