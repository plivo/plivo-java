import java.util.HashMap;
import java.util.Map;

import com.plivo.bridge.client.PlivoClient;

import com.plivo.bridge.exception.PlivoClientException;

import org.json.JSONObject;


public class PlivoCall {

    public static void main(String[] args) {

        String accountID = "";
        String authToken = "";
        String toNumber = "";
        String fromNumber = "";
        String ringUrl = "";
        String answerUrl = "";
        String hangupUrl = "";
        String transferUrl = "";
        String CallUUID = "";
        PlivoClient client = new PlivoClient(accountID, authToken, true);

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("to", toNumber);
        parameters.put("from", fromNumber);
        parameters.put("ring_url", ringUrl);
        parameters.put("answer_url", answerUrl);
        parameters.put("hangup_url", hangupUrl);

        try {
            String result = client.call().makeCall(parameters);
            System.out.println(result);
        }catch(PlivoClientException e) {
            System.out.println(e);
        }
    
        
        try {
            String result = client.call().hangUp(CallUUID);
        }catch(PlivoClientException e) {
            System.out.println(e);
        }
     
      
        Map<String, String> parameters2 = new HashMap<String, String>();
        parameters2.put("url", transferUrl);

        try {
            String result = client.call().transfer(CallUUID, parameters2);
            System.out.println(result);
        }catch(PlivoClientException e) {
            System.out.println(e);
        }
     
        
        try {
            String result = client.call().hangUpAll();
        }catch(PlivoClientException e){
            System.out.println(e);
        }
     
     
     //   CONFERENCE
        

        try {
            String result = client.conference().getAll();
        }catch(Exception e) {
            System.out.println(e);
        }

    }
}




    











