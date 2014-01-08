package com.plivo.helper.xml.elements;

public class Hangup extends PlivoElement {

    public Hangup() {
       super(E_HANGUP, null);
       this.nestableElements = null;
    }

    /**
     * Give the reason of hangup
     * @param reason
     */
    public void setReason(String reason) {
        this.set("reason", reason);
    }

    /**
     * Set the schedule time, in seconds
     * @param schedule
     */
    public void setSchedule(Integer schedule) {
        this.set("schedule", schedule.toString());
    }
    
}
