package org.hints.pages;

public class PoojaBookingResult {
	private String formattedFutureDate;
	private String enteredTime;

	public PoojaBookingResult(String formattedFutureDate, String enteredTime) {
		this.formattedFutureDate = formattedFutureDate;
		this.enteredTime = enteredTime;
	}
	
	 public String getformattedFutureDate() {
	        return formattedFutureDate;
	    }

	    public String getEnteredTime() {
	        return enteredTime;
	    }
}
