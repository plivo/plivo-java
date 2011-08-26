package org.plivo.bridge.to.callback;

public enum HangupReason {
	
	NORMAL_CLEARING("NORMAL_CLEARING"),
	USER_NOT_REGISTERED("USER_NOT_REGISTERED"),
	USER_BUSY("	USER_BUSY");
	
	private String value;
	
	private HangupReason(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static HangupReason fromValue(String value) {
		if(null == value) return null;
		
		for(HangupReason c: HangupReason.values())
			if(c.getValue().equals(value)) return c;
				
		return null;
	}

}
