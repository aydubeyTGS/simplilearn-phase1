package com.beans;

import java.util.Date;

public class TicketBean {
	private String ticketInfo;
	private String passengerInfo;
	private long pnr;
	private String source;
	private String destination;
	private double fare;
	private Date date;

	
	
	public TicketBean() {
		super();
		
	}
	@Override
	public String toString() {
		return "TicketBean [ticketInfo=" + ticketInfo + ", passengerInfo=" + passengerInfo + ", pnr=" + pnr
				+ ", source=" + source + ", destination=" + destination + ", fare=" + fare + ", date=" + date
				+  "]";
	}
	
	public String getTicketInfo() {
		return ticketInfo;
	}
	public void setTicketInfo(String ticketInfo) {
		this.ticketInfo = ticketInfo;
	}
	public String getPassengerInfo() {
		return passengerInfo;
	}
	public void setPassengerInfo(String passengerInfo) {
		this.passengerInfo = passengerInfo;
	}
	public long getPnr() {
		return pnr;
	}
	public void setPnr(long pnr) {
		this.pnr = pnr;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
