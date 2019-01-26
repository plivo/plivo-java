package com.plivo.api.models.address;

public enum NumberType {
	LOCAL("local"),
	NATIONAL("national"),
	MOBILE("mobile"),
	TOLLFREE("tollfree");

	private final String numberType;

	NumberType(final String numberType) {
		this.numberType = numberType;
	}

	@Override
	public String toString() {
		return this.numberType;
	}

}
