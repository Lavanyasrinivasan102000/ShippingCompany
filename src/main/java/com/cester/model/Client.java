package com.cester.model;

public class Client {
	
	private String name;
    private String contact;
    private String itemShipped;
    private String dateReceived;
    private String dateShipped;
    
    private int clientID;
    /**
	 * @return the clientID
	 */
	public int getClientID() {
		return clientID;
	}
	/**
	 * @param clientID the clientID to set
	 */
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * @return the itemShipped
	 */
	public String getItemShipped() {
		return itemShipped;
	}
	/**
	 * @param itemShipped the itemShipped to set
	 */
	public void setItemShipped(String itemShipped) {
		this.itemShipped = itemShipped;
	}
	/**
	 * @return the dateReceived
	 */
	public String getDateReceived() {
		return dateReceived;
	}
	/**
	 * @param dateReceived the dateReceived to set
	 */
	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
	}
	/**
	 * @return the dateShipped
	 */
	public String getDateShipped() {
		return dateShipped;
	}
	/**
	 * @param dateShipped the dateShipped to set
	 */
	public void setDateShipped(String dateShipped) {
		this.dateShipped = dateShipped;
	}
	
    
    // Getters and setters for fields
}
