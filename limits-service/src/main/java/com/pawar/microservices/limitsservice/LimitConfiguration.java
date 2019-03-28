package com.pawar.microservices.limitsservice;

public class LimitConfiguration {

	private int maximum;
	private int minimum;
	
	
	
	protected LimitConfiguration() {
		super();
	}

	public LimitConfiguration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public int getMinimum() {
		return minimum;
	}
	
}
