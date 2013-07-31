package com.plivo.helper.xml.elements;

public class Wait extends PlivoElement {

    public Wait() {
       super(E_WAIT, null);
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
     * Length of wait time in seconds
     * @param length
     */
    public void setLength(Integer length) {
        this.setInteger("length", length);
    }

   /**
    * If silence is also set to "true", the XML will process 
    * the next element when there is no voice or sound at the other end,
    * overriding the value of the length attribute. 
    * @param silence
    */
    public void setSilence(Boolean silence) {
        this.setBoolean("silence", silence);
    }

    public void setMinSilence(Integer minSilence) {
        this.setInteger("minSilence", minSilence);
    }

}
