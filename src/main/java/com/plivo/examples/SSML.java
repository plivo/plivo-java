package com.plivo.examples;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.exceptions.PlivoXmlException;
import com.plivo.api.xml.Response;
import com.plivo.api.xml.Speak;

public class SSML {

	public static void main(String[] args) throws Exception {
		validateSSMLInvalidLanguage();
	}

	public static void validateEmptyVoiceWithSSML() {
		Response response;
		try {
			response = new Response().children(
					new Speak("validate speak")
            .language("en-US")
            .loop(0)
					.addBreak("maximum", "250ms"));
			System.out.println(response.toXmlString());
		} catch (PlivoXmlException | PlivoValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void validateManOrWomenVoiceWithSSML() {
		Response response;
		try {
			response = new Response().children(
					new Speak("validate speak")
            .voice("MAN")
            .language("en-US")
            .loop(0)
					.addBreak("maximum", "250ms"));
			System.out.println(response.toXmlString());
		} catch (PlivoXmlException | PlivoValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void validateSpeakWithDefaultManOrWomenVoiceWithoutSSML() {
		Response response;
		try {
			response = new Response().children(
					new Speak("validate speak")
            .voice("MAN")
            .language("en-US")
            .loop(0));
			System.out.println(response.toXmlString());
		} catch (PlivoXmlException | PlivoValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void validateSpeakCharlimit() {
		Response response;
		try {
			response = new Response().children(
					new Speak(getAlphaNumericString(3330))
            .voice("MAN")
            .language("en-US")
            .loop(0));
			System.out.println(response.toXmlString());
		} catch (PlivoXmlException | PlivoValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void validateBasicSSML() {
		try {
			Response response = new Response().children(
					new Speak("validate speak")
            .voice("Polly.Salli")
            .language("en-US")
            .loop(0)
					.addBreak("maximum", "250ms")
					.continueSpeak("Continue speak test 1.")
					.addEmphasis("sdfghjjhd", "maximum")
					.addLang("LANG LANG", "maximum")
					.continueSpeak("THIS IS A TEST.")
					);

			System.out.println(response.toXmlString());
		} catch (PlivoXmlException | PlivoValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void validateSSMLVoiceLength() {
		try {
			Response response = new Response().children(
					new Speak("validate speak")
            .voice("Polly.Salli")
            .language("en-US")
            .loop(0)
					.addBreak("maximum", "250ms")
					.continueSpeak("Continue speak test 1.")
					.addEmphasis("sdfghjjhd", "maximum")
					.addLang("LANG LANG", "maximum")
					.continueSpeak("THIS IS A TEST.")
					);

			System.out.println(response.toXmlString());
		} catch (PlivoXmlException | PlivoValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void validateSSMLInvalidLanguage() {
		try {
			Response response = new Response().children(
					new Speak("validate speak")
            .voice("Polly.Salli")
            .language("en-US")
            .loop(0).legs("aleg")
					.addBreak("maximum", "250ms")
					.continueSpeak("Continue speak test 1.")
					.addEmphasis("sdfghjjhd", "maximum")
					.addLang("LANG LANG", "maximum")
					.continueSpeak("THIS IS A TEST.")
					);

			System.out.println(response.toXmlString());
		} catch (PlivoXmlException | PlivoValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  static String getAlphaNumericString(int n) 
	{ 
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz";  
		StringBuilder sb = new StringBuilder(n); 
		for (int i = 0; i < n; i++) { 
			int index 
			= (int)(AlphaNumericString.length() 
					* Math.random());  
			sb.append(AlphaNumericString 
					.charAt(index)); 
		} 

		return sb.toString(); 
	}


}

