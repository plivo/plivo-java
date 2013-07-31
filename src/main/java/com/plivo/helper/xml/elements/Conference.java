package com.plivo.helper.xml.elements;

public class Conference extends PlivoElement {

   public Conference(String name) {
       /**
        * Instantiates a new conference.
        *
        * @param name the name
        */
        super(E_CONFERENCE, name);
        this.nestableElements = null;
    }

    /**
     * Sets the integer.
     *
     * @param attr the attr
     * @param intr the intr
     */
    private void setInteger(String attr, Integer intr) {
       this.set(attr, intr.toString()); 
    }

    /**
     * Sets the boolean.
     *
     * @param attr the attr
     * @param bool the bool
     */
    private void setBoolean(String attr, Boolean bool) {
       this.set(attr, bool.toString().toLowerCase()); 
    }

    /**
     *  Enter conference muted
          (default false)
     * @param muted
     */
    public void setMuted(Boolean muted) {
        this.setBoolean("muted", muted);
    }

    /**
     * The conference start when this member joins
          (default true)
     * @param startConferenceOnEnter
     */
    public void setStartConferenceOnEnter(Boolean startConferenceOnEnter) {
        this.setBoolean("startConferenceOnEnter", startConferenceOnEnter);
    }

    /**
     * Close conference after all members
            with this attribute set to 'true' leave. (default false)
     * @param endConferenceOnExit
     */
    public void setEndConferenceOnExit(Boolean endConferenceOnExit) {
        this.setBoolean("endConferenceOnExit", endConferenceOnExit);
    }

    /**
     * If 'false' and member is alone, conference is closed and member kicked out
          (default true)
     * @param stayAlone
     */
    public void setStayAlone(Boolean stayAlone) {
        this.setBoolean("stayAlone", stayAlone);
    }

    /**
     * Sound to play when a member enters
          if empty, disabled
          if 'beep:1', play one beep
          if 'beep:2', play two beeps
          (default disabled)
     * @param enterSound
     */
    public void setEnterSound(String enterSound) {
        this.set("enterSound", enterSound);
    }

    /**
     * Sound to play when a member exits
          if empty, disabled
          if 'beep:1', play one beep
          if 'beep:2', play two beeps
          (default disabled)
     * @param exitSound
     */
    public void setExitSound(String exitSound) {
        this.set("exitSound", exitSound);
    }

    /**
     * Sound to play while alone in conference
          Can be a list of sound files separated by comma.
          (default no sound)
     * @param waitSound
     */
    public void setWaitSound(String waitSound) {
        this.set("waitSound", waitSound);
    }

    /**
     * Max members in conference
          (0 for max : 200)
     * @param maxMembers
     */
    public void setMaxMembers(Integer maxMembers) {
        this.setInteger("maxMembers", maxMembers);
    }

    /**
     * Max time in seconds before closing conference
          (default 0, no timeLimit)
     * @param timeLimit
     */
    public void setTimeLimit(Integer timeLimit) {
        this.setInteger("timeLimit", timeLimit);
    }

    /**
     * Exit conference when member press '*'
          (default false)
     * @param hangupOnStar
     */
    public void setHangupOnStar(Boolean hangupOnStar) {
        this.setBoolean("hangupOnStar", hangupOnStar);
    }

    /**
     * Beep in conference  '*'
          (default false)
     * @param beep
     */
    public void setBeep(Boolean beep) {
        this.setBoolean("beep", beep);
    }

    /**
     * Record conference or not
     * @param record
     */
    public void setRecord(Boolean record) {
        this.setBoolean("record", record);
    }

    /**
     * Redirect to this URL after leaving conference
     * @param action
     */
    public void setAction(String action) {
        this.set("action", action);
    }

    /**
     * Submit to 'action' URL using GET or POST
    *        (default POST)
     */
    public void setMethod(String method) {
        this.set("method", method);
    }

    /**
     * A list of matching digits to send with callbackUrl
            Can be a list of digits patterns separated by comma.
     * @param digitsMatch
     */
    public void setDigitsMatch(String digitsMatch) {
        this.set("digitsMatch", digitsMatch);
    }

    /**
     * Url to request when call enters/leaves conference
            or has pressed digits matching (digitsMatch)
     * @param callbackUrl
     */
    public void setCallbackUrl(String callbackUrl) {
        this.set("callbackUrl", callbackUrl);
    }

    /**
     * Submit to 'callbackUrl' URL using GET or POST
    *        (default POST)
     * @param callbackMethod
     */
    public void setCallbackMethod(String callbackMethod) {
        this.set("callbackMethod", callbackMethod);
    }

    /** Floor Event
     * 'true' or 'false'. When this member speaks, 
             send notification to callbackUrl. (default 'false')
     * @param floorEvent
     */
    public void setFloorEvent(Boolean floorEvent) {
        this.setBoolean("floorEvent", floorEvent);
    }

    /** Redirect Event
     * 'true' or 'false'. default redirect to action URL.
             else, only request the URL and continue to next element.
     * @param redirect
     */
    public void setRedirect(Boolean redirect) {
        this.setBoolean("redirect", redirect);
    }
    
    /**
     * The conference start when this member joins
          (default false)
     * @param recordWhenAlone
     */
    public void setRecordWhenAlone(Boolean recordWhenAlone) {
        this.setBoolean("recordWhenAlone", recordWhenAlone);
    }

    /**
    * Set the format of file to be recorded
    * @param format
    */
    public void setRecordFileFormat(String format) {
    	this.set("recordFileFormat", format);
    }
    
    /**
     * Set the type of transcription
     * @param transcriptionType
     */
    public void setTranscriptionType(String transcriptionType) {
    	this.set("transcriptionType", transcriptionType);
    }
    
    /**
     * Set the http method for sending params to transcriptionUrl
     * @param transcriptionMethod
     */
    public void setTranscriptionMethod(String transcriptionMethod) {
    	this.set("transcriptionMethod", transcriptionMethod);
    }

    /**
     * Set the url for receiving transcription
     * @param transcriptionUrl
     */
    public void setTranscriptionUrl(String transcriptionUrl) {
    	this.set("transcriptionUrl", transcriptionUrl);
    }
    
}
