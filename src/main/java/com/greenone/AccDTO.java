package com.greenone;

public class AccDTO {
	private int numberOfSuccess;
	private int numberOfNone;
	private int numberOfWarning;

	public AccDTO() {
	}

	public int getNumberOfSuccess() {
		return numberOfSuccess;
	}

	public void setNumberOfSuccess(int numberOfSuccess) {
		this.numberOfSuccess = numberOfSuccess;
	}

	public int getNumberOfNone() {
		return numberOfNone;
	}

	public void setNumberOfNone(int numberOfNone) {
		this.numberOfNone = numberOfNone;
	}

	public int getNumberOfWarning() {
		return numberOfWarning;
	}

	public void setNumberOfWarning(int numberOfWarning) {
		this.numberOfWarning = numberOfWarning;
	}
}
