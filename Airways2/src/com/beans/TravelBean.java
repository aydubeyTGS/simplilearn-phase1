package com.beans;

import java.util.Date;

public class TravelBean {
private String source;
private String destination;
private int availableSeat;
private Date date;
private boolean isActive;
private int flightId;
private String company;
private double fare;


public TravelBean() {
	super();
}
@Override
public String toString() {
	return "TravelBean [source=" + source + ", destination=" + destination + ", availableSeat=" + availableSeat
			+ ", date=" + date + ", isActive=" + isActive + ", flightId=" + flightId + ", company="
			+ company + ", fare=" + fare + "]";
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
public int getAvailableSeat() {
	return availableSeat;
}
public void setAvailableSeat(int availableSeat) {
	this.availableSeat = availableSeat;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}
public int getFlightId() {
	return flightId;
}
public void setFlightId(int flightId) {
	this.flightId = flightId;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public double getFare() {
	return fare;
}
public void setFare(double fare) {
	this.fare = fare;
}



}
