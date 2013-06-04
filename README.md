Plivo Java Helper Library
=========================

Description
-----------

The Plivo Java helper simplifies the process of making PLIVO API Calls and generating PLIVO XML.

See [Plivo Documentation](http://www.plivo.com/docs/) for more information.



Pre-built jars
--------------

[plivo-java-2.3.1-jar-with-dependencies.jar](https://s3-us-west-1.amazonaws.com/helpers.plivo.com/java/plivo-java-2.3.1-jar-with-dependencies.jar)

[plivo-java-2.3.1.jar](https://s3-us-west-1.amazonaws.com/helpers.plivo.com/java/plivo-java-2.3.1.jar) - use this if you have issues with conflicting jars in your project. See the pom.xml for the list of dependencies you will need to include.


Manual Install
------------

### Download and Install Maven3 


[http://maven.apache.org](http://maven.apache.org)

[Maven in 5 minutes guide](http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)


### Generating a release

To generate the final release,
  
	mvn install -Dmaven.test.skip=true

Note: The parameter *-Dmaven.test.skip=true* will skip all test and generate the release.
	
### Use the Library in your Java IDE

Create Stubs for Eclipse

	mvn eclipse:eclipse

Create stubs for idea

	mvn idea:idea


How to use
----------

### Making a Call.
	RestAPI restAPI = new RestAPI("<AUTH_ID>", "<AUTH_TOKEN>", "v1");

  	LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
		params.put("from", "xxxxxxxxxx");
		params.put("to", "xxxxxxxxxx");
		params.put("answer_url", "http://www.myxmlserver.com/Hangup.xml");

		Call response;
		try {

			response = restAPI.makeCall(params);
			System.out.println(response.apiId);
		} 
		catch (PlivoException e) {
			System.out.println(e.getMessage());
		}
 
### Check the [examples](https://github.com/plivo/plivo-examples-java)
