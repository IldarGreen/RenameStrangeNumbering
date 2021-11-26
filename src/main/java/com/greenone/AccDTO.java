package com.greenone;

public class AccDTO {
	private int numberOfSuccess;
	private int numberOfNone;
	private int numberOfWarning;
	private int numberOfWarnFolder;

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

	public int getNumberOfWarnFolder() {
		return numberOfWarnFolder;
	}

	public void setNumberOfWarnFolder(int numberOfWarnFolder) {
		this.numberOfWarnFolder = numberOfWarnFolder;
	}
}
