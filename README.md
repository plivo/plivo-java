Plivo Java Helper Library
=========================

Description
-----------

The Plivo Java helper simplifies the process of making PLIVO API Calls and generating PLIVO XML.

See [Plivo Documentation] (http://www.plivo.com/docs/) for more information.



Pre-built jars
--------------

[plivo-0.1-with-dependencies.jar[ (https://github.com/downloads/plivo/plivo-java/plivo-0.1-jar-with-dependencies.jar)
[plivo-0.-1.jar] (https://github.com/downloads/plivo/plivo-java/plivo-0.1.jar) - use this if you have issues with conflicting jars in your project. See the pom.xml for the list of dependencies you will need to include.



Manual Install
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
  * PlivoClient client = PlivoClient.create("authId",
  *				"authToken", debug);

  
  authId=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
  
  authToken=YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY
  
  
  After that, you can run the tests.
 
### Requesting a new CALL to PLIVO

*  Map<String, String> parameters = new HashMap<String, String>();
*
*	parameters.put("from", "15679XXXXX");
*	parameters.put("to", "1567XXXXXXXX");
*	parameters.put("answer_url", "http://example.com/answer_url");
*	parameters.put("hangup_url", "http://example.com/hangup_url");
*	parameters.put("ring_url", "http://example.com/ring_url");
*
*   CallResponse result = client.call().makeCall(parameters);


License
-------

The Plivo Java Helper Library is distributed under the MPL 1.1 License
