package com.plivo.api.models.address;

public enum AddressProofType {

	NATIONALID("national_id"),
	PASSPORT("passport"),
	BUISNESSID("business_id"),
	NIF("NIF"),
	NIE("NIE"),
	DNI("DNI");

	private final String addressProofType;

	AddressProofType(final String proofType) {
		this.addressProofType = proofType;
	}

	@Override
	public String toString() {
		return this.addressProofType;
	}


}
