import java.util.HashMap;
import java.util.Map;

import com.plivo.bridge.client.PlivoClient;

import com.plivo.bridge.exception.PlivoClientException;

public class PlivoNumber {

    public static void main(String[] args) {

        String accountID = "";
        String authToken = "";
        String Number  = "";

        PlivoClient client = new PlivoClient(accountID, authToken, true);

        Map<String, String> parameters = new HashMap<String, String>();

        // Get all numbers rented
        try {
            String result = client.number().getAllRented();
            System.out.println(result);
        }catch(PlivoClientException e) {
            System.out.println(e);
        }
        
        // Get Details of One Number
        try {
            String result = client.number().getOneRented(Number);
        }catch(PlivoClientException e) {
            System.out.println(e);
        }
     
        
        parameters.put("contains", "67");

        try {
            String result = client.number().search(parameters);
            System.out.println(result);
        }catch(PlivoClientException e) {
            System.out.println(e);
        }
     
        
        // Rent a Number
        //
        try {
            String result = client.number().rent(Number);
        }catch(PlivoClientException e){
            System.out.println(e);
        }
     

        // UnRent a Number
        try {
            String result = client.number().unRent(Number);
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}




    











