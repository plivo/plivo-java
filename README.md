
Plivo Java Helper Library
=========================

Description
-----------

The Plivo Java helper simplifies the process of making REST calls and generating RESTXML.

See [Plivo Documentation] (http://www.plivo.com/docs/) for more information.


Installation
------------

### Download and Install Maven3 


[http://maven.apache.org] (http://maven.apache.org)
[Maven in 5 minutes guide] (http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)


### Generating a release

To generate the final release,
	

mvn install -Dmaven.test.skip=true


	
	Note: The parameter *-Dmaven.test.skip=true* will skip all test and generate the release.
	
### Use the Library in your Java IDE

Create Stubs for Eclipse
    * mvn eclipse:eclipse

Create stubs for idea
    * mvn idea:idea


How to use
----------

### Creating the plivo client bridge
  * PlivoClient client = PlivoClient.create("accountId",
  *				"accountToken", debug);

  
  accountId=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
  
  authToken=YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY
  
  
  After that, you can run the tests.
 
### Requesting a new CALL to PLIVO

*  Map<String, String> parameters = new HashMap<String, String>();
*
*	parameters.put("from", "1001");
*	parameters.put("to", "1002");
*	parameters.put("answer_url", "http://example.com/answer_url");
*	parameters.put("hangup_url", "http://example.com/hangup_url");
*	parameters.put("ring_url", "http://example.com/ring_url");
*
*   CallResponse result = client.call().makeCall(parameters);


License
-------

The Plivo Java Helper Library is distributed under the MPL 1.1 License
