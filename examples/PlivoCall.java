import java.util.HashMap;
import java.util.Map;

import org.plivo.bridge.client.PlivoClient;

import org.plivo.bridge.exception.PlivoClientException;
import org.plivo.bridge.to.response.conference.ConferenceMuteResponse;
import org.plivo.bridge.to.response.PlivoResponse;

import org.json.JSONObject;


public class PlivoCall {

    public static void main(String[] args) {

        String accountID = "MAGWNTM3ZTK1M2YZMDYX";
        String authToken = "MThhNmRjZDFmY2I3MTg1NjAwODIxYWZiZWViNTQx";
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
        parameters2.put("url", TransferUrl);

        try {
            TransfCallResponse result = client.call().transfer(CallUUID, parameters2);
            System.out.println(result);
        }catch(PlivoClientException e) {
            System.out.println(e);
        }
     
        
        try {
            HangupAllCallResponse result = client.call().hangUpAll();
        }catch(PlivoClientException e){
            System.out.println(e);
        }
     
     
     //   CONFERENCE
        

        try {
            ConferenceMuteResponse result = client.conference().getAll();
        }catch(Exception e) {
            System.out.println(e);
        }

    }
}




    











