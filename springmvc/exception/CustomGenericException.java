package com.jme.springmvc.exception;

public class CustomGenericException extends  RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errMsg;
	private String errCode;
	private String errorMethod;

	public String getErrorMethod() {
		return errorMethod;
	}

	public void setErrorMethod(String errorMethod) {
		this.errorMethod = errorMethod;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public CustomGenericException(String errCode,String errorMethod, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.errorMethod = errorMethod;
	}
}
