# plivo-java

[![UnitTests](https://github.com/plivo/plivo-java/actions/workflows/unitTests.yml/badge.svg?branch=master)](https://github.com/plivo/plivo-java/actions/workflows/unitTests.yml)

The Plivo Java SDK makes it simpler to integrate communications into your Java applications using the Plivo REST API. Using the SDK, you will be able to make voice calls, send SMS and generate Plivo XML to control your call flows.

**Supported Java versions:** This SDK works with Java 1.8 & 1.9 i.e., JDK 8 and JDK 9. While using the SDK with Java 1.9, you may have to use the `--add-modules java.se.ee` flag to include modules that are no longer present by default.

## Installation

### To Install Stable release

You can use this SDK by adding it as a dependency in your dependency management tool. Alternatively, you can use the [JAR file](https://search.maven.org/remotecontent?filepath=com/plivo/plivo-java/5.38.0/plivo-java-5.38.0.jar).

If you are using Maven, use the following XML to include the Plivo SDK as a dependency.

```xml
<dependency>
  <groupId>com.plivo</groupId>
  <artifactId>plivo-java</artifactId>
  <version>5.38.1</version>
</dependency>
```

If you are using Gradle, use the following line in your dependencies.
```
compile 'com.plivo:plivo-java:5.38.0'
```

### To Install Beta release

You can use this SDK by adding it as a dependency in your dependency management tool. Alternatively, you can use the [JAR file](https://search.maven.org/remotecontent?filepath=com/plivo/plivo-java/4.3.0-beta-2/plivo-java-4.3.0-beta-2.jar).

If you are using Maven, use the following XML to include the Plivo SDK as a dependency.

```xml
<dependency>
  <groupId>com.plivo</groupId>
  <artifactId>plivo-java</artifactId>
  <version>4.3.0-beta-2</version>
</dependency>
```

If you are using Gradle, use the following line in your dependencies.
```
compile 'com.plivo:plivo-java:4.3.0-beta-2'
```

Note: if you are already using Retrofit, exclude this SDK's dependency so there is no version conflict.

## Getting started

### Authentication
To make the API requests, you need to create a `Plivo` instance and provide it with authentication credentials (which can be found at [https://console.plivo.com/dashboard/](https://console.plivo.com/dashboard/)).

We recommend that you store your credentials in the `PLIVO_AUTH_ID` and the `PLIVO_AUTH_TOKEN` environment variables, so as to avoid the possibility of accidentally committing them to source control. If you do this, you can initialise the client with no arguments and it will automatically fetch them from the environment variables:

```java
class Example {
  public static void main(String [] args) {
    Plivo.init();
  }
}
```

Alternatively, you can provide these to `Plivo.init()`'s constructor yourself:

```java
class Example {
  public static void main(String [] args) {
    Plivo.init("<auth_id>", "<auth_id>");
  }
}
```

To use multiple clients, you can create a `PlivoClient` instance yourself and set it on a request:

```java
class Example {
  public static void main(String [] args) {
    PlivoClient client = new PlivoClient("<auth_id>", "<auth_id>");
    Message.creator("+14156667778", "+14156667777", "Hello, this is sample text from Plivo")
                    .client(client)
                    .create();
  }
}
```

## The Basics
The SDK uses consistent interfaces to create, retrieve, update, delete and list resources. The pattern followed is as follows:

``` java
Resource.creator(parameters).create();
Resource.getter(parameters).get();
Resource.updater(identifier, parameters).update();
Resource.deleter(identifier).delete();
Resource.lister().list();
```

Using `Resource.lister().list()` would list the first 20 resources by default (which is the first page, with `limit` as 20, and `offset` as 0). To get more, you will have to use `limit` and `offset` to get the second page of resources.

To list all objects of any resource, simply use the request object itself as an iterable:

```java
class Example {
  public static void main(String [] args) {
    Plivo.init();
    for (Message message : Message.lister()) {
      System.out.println(message.getMessageUuid());
    }
  }
}
```

Please note that this makes several requests to the Plivo API, and hence will pause for a short duration at every 20 resources.

## Examples

### Send a message

```java
class Example {
  public static void main(String [] args) {
    Plivo.init();
    Message.creator("+14156667778", Collections.singletonList("+14156667777"), "Hello, world!")
                    .create();
  }
}
```

### Make a call

```java
class Example {
  public static void main(String [] args) {
    Plivo.init();
    Call.creator("+14156667778", Collections.singletonList("+14156667777"), "https://answer.url")
                    .answerMethod("GET")
                    .create();
  }
}
```

### Lookup a number

```java
class Example {
  public static void main(String [] args) {
    Plivo.init("<auth_id>", "<auth_id>");
    System.out.println(com.plivo.api.models.lookup.Number
        .getter("<number-goes-here>")
        .get());
  }
}
```


### Generate Plivo XML

```java
class Example {
  public static void main(String [] args) {
    System.out.println(new Response()
                             .children(
                               new Speak("Hello, world!")
                             ).toXmlString());
  }
}
```

This generates the following XML:

```xml
<Response>
  <Speak>Hello, world!</Speak>
</Response>
```

### Log Level

We’ve introduced a customizable logging mechanism in the Java SDK that enables you to choose the level of logging in your development/production environment. 

| Log-level      | Description |
| :---        |    :----:   |
| NONE      | No logs       |
| BASIC   | Logs request and response line |
| HEADER   | Logs request and response line along with their headers        |
| BODY   | Logs request and response line along with their headers and bodies |

### Example

```java
package com.plivo.api.samples.call;

import com.plivo.api.Plivo;
import com.plivo.api.models.base.LogLevel;

class Example {
    public static void main(String [] args) {
        Plivo.init("<auth_id>","<auth_token>", LogLevel.NONE); // LogLevel.NONE is the default value.
//        Plivo.init("<auth_id>","<auth_token>", LogLevel.BASIC);
//        Plivo.init("<auth_id>","<auth_token>", LogLevel.BODY);
//        Plivo.init("<auth_id>","<auth_token>", LogLevel.HEADERS);
    }
}
```

### More examples
More examples are available [here](https://github.com/plivo/plivo-examples-java). Also refer to the [guides for configuring the Java Spring to run various scenarios](https://plivo.com/docs/sms/quickstart/java-spring/) & use it to test out your integration in under 5 minutes.

## Reporting issues
Report any feedback or problems with this version by [opening an issue on Github](https://github.com/plivo/plivo-java/issues).

## Local Development
> Note: Requires latest versions of Docker & Docker-Compose. If you're on MacOS, ensure Docker Desktop is running.
1. Export the following environment variables in your host machine:
```bash
export PLIVO_AUTH_ID=<your_auth_id>
export PLIVO_AUTH_TOKEN=<your_auth_token>
export PLIVO_API_DEV_HOST=<plivoapi_dev_endpoint>
export PLIVO_API_PROD_HOST=<plivoapi_public_endpoint>
```
2. Run `make build`. This will create a docker container in which the sdk will be setup and dependencies will be installed.
> The entrypoint of the docker container will be the `setup_sdk.sh` script. The script will handle all the necessary changes required for local development. It will also package the sdk and reinstall it as a dependecy for the test program.
3. The above command will print the docker container id (and instructions to connect to it) to stdout.
4. The test code can be added to `<sdk_dir_path>/java-sdk-test/Test.java` in host  
 (or `/usr/src/app/java-sdk-test/Test.java` in container)
5. The sdk directory will be mounted as a volume in the container. So any changes in the sdk code will also be reflected inside the container. However, when any change is made, the dependencies for the test program need to be re-installed. To do that:
    * Either restart the docker container
    * Or Run the `setup_sdk.sh` script
6. To run test code, run `make run CONTAINER=<cont_id>` in host. 
7. To run unit tests, run `make test CONTAINER=<cont_id>` in host.
> `<cont_id>` is the docker container id created in 2.
(The docker container should be running)

> Test code and unit tests can also be run within the container using
`make run` and `make test` respectively. (`CONTAINER` argument should be omitted when running from the container)
