package com.jme.springmvc.exception;

public class TallyException extends  Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errMsg;


	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public TallyException( String errMsg) {
		this.errMsg = errMsg;
	}
}
