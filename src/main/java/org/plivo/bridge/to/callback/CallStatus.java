package com.plivo.bridge.to.callback;

public enum CallStatus {
	RINGING("ringing"),
	COMPLETE("completed"),
	INPROGRESS("in-progress");
	
	private String value;
	
	private CallStatus(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static CallStatus fromValue(String value) {
		if(null == value) return null;
		
		for(CallStatus c: CallStatus.values())
			if(c.getValue().equals(value)) return c;
				
		return null;
	}

}
