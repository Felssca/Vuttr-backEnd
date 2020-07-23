package br.com.vuttr.resource.exception;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * 
 * @author felipe
 *
 */

public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer status;
	private String mensage;
	private ZonedDateTime dateTime;
	
	public StandardError(){}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMensage() {
		return mensage;
	}
	public void setMensage(String mensage) {
		this.mensage = mensage;
	}
	public ZonedDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(ZonedDateTime dateTime) {
		this.dateTime = dateTime;
	}
	

}
