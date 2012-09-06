package com.javier.async;

public class Customer {

	private String balance = "";
	private String loanAmount = "";
	private String nextPayDate = "";

	// LOAN FOR APPLY FOR NEW LOAN
	// ////////////////////////////////////////////////////
	

	private static Customer instance = new Customer();

	private Customer() {
	}

	public static synchronized Customer getInstance() {
		return instance;
	}

	public void doSomething() {
		for (int i = 0; i < 10; i++) {
			System.out.println("i = " + i);
		}
	}



	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Clone is not allowed.");
	}

	
}
