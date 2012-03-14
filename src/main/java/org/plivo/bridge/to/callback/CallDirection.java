package com.plivo.bridge.to.callback;

public enum CallDirection {
	INBOUND("inbound"),
	OUTBOUND("outbound");
	
	private String value;
	
	private CallDirection(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static CallDirection fromValue(String value) {
		if(null == value) return null;
		
		for(CallDirection c: CallDirection.values())
			if(c.getValue().equals(value)) return c;
				
		return null;
	}
}
