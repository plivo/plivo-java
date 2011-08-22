
Plivo Java Helper Library
---------------------------

Description
~~~~~~~~~~~

The Plivo Java helper simplifies the process of making REST calls and generating RESTXML.

See `Plivo Documentation <http://www.plivo.org/docs/>`_ for more information.


Installation
~~~~~~~~~~~~~

**Download Maven2**
    TAR.GZ - http://www.apache.org/dyn/closer.cgi/maven/binaries/apache-maven-2.2.1-bin.tar.gz
    ZIP - http://www.apache.org/dyn/closer.cgi/maven/binaries/apache-maven-2.2.1-bin.zip


**Use maven "mvn install"**

(This currently only supports the Oracle (SUN) JDK 1.6+. We should have OpenJDK available shortly)

**Use the Library in your Java IDE**
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

**Create Stubs for Eclipse:**
    mvn eclipse:eclipse

**Create stubs for idea**
    mvn idea:idea


How to use
~~~~~~~~~~~~~
You can read the code inside src/test/java folder. We've implemented there all methods that are
currently available on PLIVO.

**Creating the plivo client bridge for java**
   PlivoClient client = PlivoClient.create("accountId",
				"accountToken",
				"url", debug);
  // there's another constructor if you want to override the PLIVO version

**Requesting a new CALL to PLIVO**
	Map<String, String> parameters = 
		new HashMap<String, String>();
	
	parameters.put("From", "1001");
	
	parameters.put("To", "1002");
	
	parameters.put("Gateways", "user/");
	
	parameters.put("GatewayCodecs", "PCMA,PCMU");
	
	parameters.put("GatewayTimeouts", "60");
	
	parameters.put("GatewayRetries", "1");
	
	parameters.put("OriginateDialString", "originate_dial_string");
	
	parameters.put("AnswerUrl", "http://localhost:5151/answered");
	
	parameters.put("HangUpUrl", "http://localhost:5151/hangup");
	
	parameters.put("RingUrl", "http://localhost:5151/ringing");

	CallResponse result = client.call().single(parameters);

	Call response will contain RequestUUID of the call.
	Note that the AnswerUrl, HangUpUrl and RingUrl has to be a VALID URL. Your application must be
	listening on these urls and response properly. 
	
	This helper already contains a simple web server implemented by Jetty, so you can check our servlet classes.
	
	Example of a simple implementation of the answered URL:
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AnsweredCallback callback = AnsweredCallback.create(req);
		
		ApplicationResponse r = new ApplicationResponse();
		GetDigits digits = new GetDigits();
		digits.setNumDigits(1);
		digits.setValidDigits("123");
		digits.setPlayBeep(true);
		digits.setRetries(2);
		r.setGetDigits(digits);
		
		try {
			PlivoUtils.JAXBContext.createContext().createMarshaller().marshal(r, resp.getOutputStream());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	This piece of code will receive the PLIVO CALL and return a request to user to enter
	one digit on the phone. The user must enter "1, 2 or 3" and he has 2 tries to accomplish that.
		
**Other features on PLIVO**	
As said before, every test case is implemented to use all of the PLIVO features.
Just read the code or contact us whether you have any doubts.

License
-------

The Plivo Java Helper Library is distributed under the MPL 1.1 License
