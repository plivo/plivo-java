import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.exceptions.PlivoXmlException;
import com.plivo.api.models.multipartycall.MultiPartyCallUtils;
import com.plivo.api.xml.MultiPartyCall;
import com.plivo.api.xml.Response;

public class Test {
  public static void main(String[] args) throws PlivoValidationException, PlivoXmlException {
    Response resp = new Response();
    resp.children(new MultiPartyCall("mpc_name", MultiPartyCallUtils.customer).maxDuration(10000));
    System.out.println(resp.toXmlString());
  }
}