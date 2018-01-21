package com.jme.springmvc.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class Response {
	
	
	Integer created;
	Integer altered;
	Integer deleted;
	Integer lastvchid;
	Integer lastmid;
	Integer combined;
	Integer ignored;
	Integer errors;
	Integer cancelled;
	String lineerror;
	
	public Integer getCreated() {
		return created;
	}
	@XmlElement
	public void setCreated(Integer created) {
		this.created = created;
	}
	
	public Integer getAltered() {
		return altered;
	}
	@XmlElement
	public void setAltered(Integer altered) {
		this.altered = altered;
	}
	public Integer getDeleted() {
		return deleted;
	}
	@XmlElement
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public Integer getLastvchid() {
		return lastvchid;
	}
	@XmlElement
	public void setLastvchid(Integer lastvchid) {
		this.lastvchid = lastvchid;
	}
	public Integer getLastmid() {
		return lastmid;
	}
	@XmlElement
	public void setLastmid(Integer lastmid) {
		this.lastmid = lastmid;
	}
	public Integer getCombined() {
		return combined;
	}
	@XmlElement
	public void setCombined(Integer combined) {
		this.combined = combined;
	}
	public Integer getIgnored() {
		return ignored;
	}
	@XmlElement
	public void setIgnored(Integer ignored) {
		this.ignored = ignored;
	}
	public Integer getErrors() {
		return errors;
	}
	@XmlElement
	public void setErrors(Integer errors) {
		this.errors = errors;
	}
	public Integer getCancelled() {
		return cancelled;
	}
	@XmlElement
	public void setCancelled(Integer cancelled) {
		this.cancelled = cancelled;
	}
	public String getLineerror() {
		return lineerror;
	}
	@XmlElement
	public void setLineerror(String lineerror) {
		this.lineerror = lineerror;
	}
	

}
