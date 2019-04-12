package com.plivo.examples;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.phlo.Phlo;
import com.plivo.api.models.phlo.PhloRunGetterResponse;
import com.plivo.api.models.phlo.PhloUpdateResponse;

public class PhloRunGet {
	private static final String authId = "MAZXXXXXXXXXXEWZDI4MZ";
	private static final String authToken = "NzUyYTVhMTYXXXXXXXXXXk1NmI5YTJmNTgwMDI4";

	public static void main (String args[]) {
		Plivo.init(authId, authToken);

		try {
			
			Map<String, Object> params = new HashMap<>();
			params.put("from", "919503364731");
			params.put("to", "918790559952");
			PhloUpdateResponse resp =  Phlo.updater("019c8486-65b6-4fe6-98a5-b0f0973fa45e").payload(params).run();
			PhloRunGetterResponse resp2 = Phlo.phloRunGetter("019c8486-65b6-4fe6-98a5-b0f0973fa45e",resp.getApiId()).get();
			System.out.println(resp2);
			
		} catch (IOException | PlivoRestException e) {
			e.printStackTrace();
		}

	}


}
