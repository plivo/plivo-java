# plivo-java

[![UnitTests](https://github.com/plivo/plivo-java/actions/workflows/unitTests.yml/badge.svg?branch=master)](https://github.com/plivo/plivo-java/actions/workflows/unitTests.yml)

The Plivo Java SDK makes it simpler to integrate communications into your Java applications using the Plivo REST API. Using the SDK, you will be able to make voice calls, send SMS and generate Plivo XML to control your call flows.

**Supported Java versions:** This SDK works with Java 1.8 & 1.9 i.e., JDK 8 and JDK 9. While using the SDK with Java 1.9, you may have to use the `--add-modules java.se.ee` flag to include modules that are no longer present by default.

## Installation

### To Install Stable release

You can use this SDK by adding it as a dependency in your dependency management tool. Alternatively, you can use the [JAR file](https://search.maven.org/remotecontent?filepath=com/plivo/plivo-java/5.46.0/plivo-java-5.46.0.jar).


If you are using Maven, use the following XML to include the Plivo SDK as a dependency.

```xml
<dependency>
  <groupId>com.plivo</groupId>
  <artifactId>plivo-java</artifactId>
  <version>5.46.0</version>
</dependency>
```

If you are using Gradle, use the following line in your dependencies.
```
compile 'com.plivo:plivo-java:5.45.6'
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

## WhatsApp Messaging
Plivo's WhatsApp API allows you to send different types of messages over WhatsApp, including templated messages, free form messages and interactive messages. Below are some examples on how to use the Plivo Go SDK to send these types of messages.

### Templated Messages
Templated messages are a crucial to your WhatsApp messaging experience, as businesses can only initiate WhatsApp conversation with their customers using templated messages.

WhatsApp templates support 4 components:  `header` ,  `body`,  `footer`  and `button`. At the point of sending messages, the template object you see in the code acts as a way to pass the dynamic values within these components.  `header`  can accomodate `text` or `media` (images, video, documents) content.  `body`  can accomodate text content.  `button`  can support dynamic values in a `url` button or to specify a developer-defined payload which will be returned when the WhatsApp user clicks on the `quick_reply` button. `footer`  cannot have any dynamic variables.

Example 1:
```java
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;
import com.plivo.api.models.message.MessageType;
import com.fasterxml.jackson.databind.ObjectMapper;

class Test
{
    public static void main(String [] args)
    {
        Plivo.init("<auth_id>", "<auth_token>");
        try {
            String templateJson = "{\"name\":\"plivo_movieticket_confirmation\",\"language\":\"en_US\",\"components\":[{\"type\":\"header\",\"parameters\":[{\"type\":\"media\",\"media\":\"https://media.geeksforgeeks.org/wp-content/uploads/20190712220639/ybearoutput-300x225.png\"}]},{\"type\":\"body\",\"parameters\":[{\"type\":\"text\",\"text\":\"Harry Potter\"},{\"type\":\"text\",\"text\":\"06:00 PM\"},{\"type\":\"text\",\"text\":\"Bengaluru\"},{\"type\":\"text\",\"text\":\"2\"}]}]}";

          MessageCreateResponse response = Message.creator("+14156667778","+14156667777").type(MessageType.WHATSAPP).template_json_string(templateJson).create();
          ObjectMapper ow = new ObjectMapper();
          String json_output = ow.writeValueAsString(response);
          System.out.println(json_output);
        }
        catch (PlivoRestException | IOException e) {
            e.printStackTrace();
        }
    }
}
```

Example 2:
```java
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;
import com.plivo.api.models.message.MessageType;
import com.fasterxml.jackson.databind.ObjectMapper;

class Test
{
    public static void main(String [] args)
    {
        Plivo.init("<auth_id>", "<auth_token>");
        try {
          Template template = new Template();
          template.setName("plivo_movieticket_confirmation");
          template.setLanguage("en_US");

          List<Component> components = new ArrayList<>();
          Component headerComponent = new Component();
          headerComponent.setType("header");
          List<Parameter> headerParameters = new ArrayList<>();
          Parameter headerMediaParameter = new Parameter();
          headerMediaParameter.setType("media");
          headerMediaParameter.setMedia("https://media.geeksforgeeks.org/wp-content/uploads/20190712220639/ybearoutput-300x225.png");
          headerParameters.add(headerMediaParameter);

          headerComponent.setParameters(headerParameters);
          components.add(headerComponent);

          Component bodyComponent = new Component();
          bodyComponent.setType("body");
          List<Parameter> bodyParameters = new ArrayList<>();
          Parameter bodyTextParameter1 = new Parameter();
          bodyTextParameter1.setType("text");
          bodyTextParameter1.setText("Harry Potter");
          bodyParameters.add(bodyTextParameter1);

          Parameter bodyTextParameter2 = new Parameter();
          bodyTextParameter2.setType("text");
          bodyTextParameter2.setText("06:00 PM");
          bodyParameters.add(bodyTextParameter2);

          Parameter bodyTextParameter3 = new Parameter();
          bodyTextParameter3.setType("text");
          bodyTextParameter3.setText("Bengaluru");
          bodyParameters.add(bodyTextParameter3);

          Parameter bodyTextParameter4 = new Parameter();
          bodyTextParameter4.setType("text");
          bodyTextParameter4.setText("2");
          bodyParameters.add(bodyTextParameter4);

          bodyComponent.setParameters(bodyParameters);
          components.add(bodyComponent);

          template.setComponents(components)
          MessageCreateResponse response = Message.creator("+14156667778","+14156667777").type(MessageType.WHATSAPP).template(template).create();
          ObjectMapper ow = new ObjectMapper();
          String json_output = ow.writeValueAsString(response);
          System.out.println(json_output);
        }
        catch (PlivoRestException | IOException e) {
            e.printStackTrace();
        }
    }
}
```
> Note: It is also possible to create and manage objects directly within the SDK for whatsapp, providing a structured approach to message creation.

### Free Form Messages
Non-templated or Free Form WhatsApp messages can be sent as a reply to a user-initiated conversation (Service conversation) or if there is an existing ongoing conversation created previously by sending a templated WhatsApp message.

#### Free Form Text Message
Example:
```java
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;
import com.plivo.api.models.message.MessageType;

class Test
{
    public static void main(String [] args)
    {
        Plivo.init("<auth_id>", "<auth_token>");
        try {
          MessageCreateResponse response = Message.creator("+14156667778","+14156667777","Hey! This is a sample Text.").type(MessageType.WHATSAPP).create();
          System.out.println(response);
        }
        catch (PlivoRestException | IOException e) {
            e.printStackTrace();
        }
    }
}

```

#### Free Form Media Message
Example:
```java
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;
import com.plivo.api.models.message.MessageType;

class Test
{
    public static void main(String [] args)
    {
        Plivo.init("<auth_id>", "<auth_token>");
        String[] media = {"https://sample-videos.com/img/Sample-png-image-1mb.png"};
        try {
          MessageCreateResponse response = Message.creator("+14156667778","+14156667777","WA -text").log(false).type(MessageType.WHATSAPP).media_urls(media).create()
          System.out.println(response);
        }
        catch (PlivoRestException | IOException e) {
            e.printStackTrace();
        }
    }
}

```

### Interactive Messages
This guide shows how to send non-templated interactive messages to recipients using Plivo’s APIs.

#### Quick Reply Buttons
Quick reply buttons allow customers to quickly respond to your message with predefined options.

Example:
```java
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;
import com.plivo.api.models.message.MessageType;
import com.fasterxml.jackson.databind.ObjectMapper;

class Test
{
    public static void main(String [] args)
    {
        Plivo.init("<auth_id>", "<auth_token>");
        try {
            String interactiveJson = "{\"type\":\"button\",\"header\":{\"type\":\"media\",\"media\":\"https://media.geeksforgeeks.org/wp-content/uploads/20190712220639/ybearoutput-300x225.png\"},\"body\":{\"text\":\"Make your selection\"},\"action\":{\"buttons\":[{\"title\":\"Click here\",\"id\":\"bt1j1k2j\"},{\"title\":\"Know More\",\"id\":\"bt1j1k2jkjk\"},{\"title\":\"Request Callback\",\"id\":\"bt1j1kfd2jkjk\"}]}}";

          MessageCreateResponse response = Message.creator("+14156667778","+14156667777").type(MessageType.WHATSAPP).interactive_json_string(interactiveJson).create();
          ObjectMapper ow = new ObjectMapper();
          String json_output = ow.writeValueAsString(response);
          System.out.println(json_output);
        }
        catch (PlivoRestException | IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### Interactive Lists
Interactive lists allow you to present customers with a list of options.

Example:
```java
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;
import com.plivo.api.models.message.MessageType;
import com.fasterxml.jackson.databind.ObjectMapper;

class Test
{
    public static void main(String [] args)
    {
        Plivo.init("<auth_id>", "<auth_token>");
        try {
            String interactiveJson = "{\"type\":\"list\",\"header\":{\"type\":\"text\",\"text\":\"Welcome to Plivo\"},\"body\":{\"text\":\"You can review the list of rewards we offer\"},\"footer\":{\"text\":\"Yours Truly\"},\"action\":{\"buttons\":[{\"title\":\"Clickhere\"}],\"sections\":[{\"title\":\"SECTION_1_TITLE\",\"rows\":[{\"id\":\"SECTION_1_ROW_1_ID\",\"title\":\"SECTION_1_ROW_1_TITLE\",\"description\":\"SECTION_1_ROW_1_DESCRIPTION\"},{\"id\":\"SECTION_1_ROW_2_ID\",\"title\":\"SECTION_1_ROW_2_TITLE\",\"description\":\"SECTION_1_ROW_2_DESCRIPTION\"}]},{\"title\":\"SECTION_2_TITLE\",\"rows\":[{\"id\":\"SECTION_2_ROW_1_ID\",\"title\":\"SECTION_2_ROW_1_TITLE\",\"description\":\"SECTION_2_ROW_1_DESCRIPTION\"},{\"id\":\"SECTION_2_ROW_2_ID\",\"title\":\"SECTION_2_ROW_2_TITLE\",\"description\":\"SECTION_2_ROW_2_DESCRIPTION\"}]}]}}";

          MessageCreateResponse response = Message.creator("+14156667778","+14156667777").type(MessageType.WHATSAPP).interactive_json_string(interactiveJson).create();
          ObjectMapper ow = new ObjectMapper();
          String json_output = ow.writeValueAsString(response);
          System.out.println(json_output);
        }
        catch (PlivoRestException | IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### Interactive CTA URLs
CTA URL messages allow you to send links and call-to-action buttons.

Example:
```java
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;
import com.plivo.api.models.message.MessageType;
import com.fasterxml.jackson.databind.ObjectMapper;

class Test
{
    public static void main(String [] args)
    {
        Plivo.init("<auth_id>", "<auth_token>");
        try {
            String interactiveJson = "{\"type\":\"cta_url\",\"header\":{\"type\":\"media\",\"media\":\"https://media.geeksforgeeks.org/wp-content/uploads/20190712220639/ybearoutput-300x225.png\"},\"body\":{\"text\":\"Know More\"},\"footer\":{\"text\":\"Plivo\"},\"action\":{\"buttons\":[{\"title\":\"Click here\",\"cta_url\":\"https:plivo.com\"}]}}";

           MessageCreateResponse response = Message.creator("+14156667778","+14156667777").type(MessageType.WHATSAPP).interactive_json_string(interactiveJson).create();
          ObjectMapper ow = new ObjectMapper();
          String json_output = ow.writeValueAsString(response);
          System.out.println(json_output);

        }
        catch (PlivoRestException | IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Location Messages
This guide shows how to send templated and non-templated location messages to recipients using Plivo’s APIs.

#### Templated Location Messages
Example:
```java
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;
import com.plivo.api.models.message.MessageType;
import com.fasterxml.jackson.databind.ObjectMapper;

class Test
{
    public static void main(String [] args)
    {
        Plivo.init("<auth_id>", "<auth_token>");
        try {
            String templateJson = "{\"name\":\"plivo_order_pickup\",\"language\":\"en_US\",\"components\":[{\"type\":\"header\",\"parameters\":[{\"type\":\"location\",\"location\":{\"longitude\":\"122.148981\",\"latitude\":\"37.483307\",\"name\":\"PabloMorales\",\"address\":\"1HackerWay,MenloPark,CA94025\"}}]},{\"type\":\"body\",\"parameters\":[{\"type\":\"text\",\"text\":\"Harry\"}]}]}";

          MessageCreateResponse response = Message.creator("+14156667778","+14156667777").type(MessageType.WHATSAPP).template_json_string(templateJson).create();
          ObjectMapper ow = new ObjectMapper();
          String json_output = ow.writeValueAsString(response);
          System.out.println(json_output);
        }
        catch (PlivoRestException | IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### Non-Templated Location Messages
Example:
```java
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;
import com.plivo.api.models.message.MessageType;
import com.fasterxml.jackson.databind.ObjectMapper;

class Test
{
    public static void main(String [] args)
    {
        Plivo.init("<auth_id>", "<auth_token>");
        try {
            String locationJson = "{\"longitude\":\"122.148981\",\"latitude\":\"37.483307\",\"name\":\"PabloMorales\",\"address\":\"1HackerWay,MenloPark,CA94025\"}";

          MessageCreateResponse response = Message.creator("+14156667778","+14156667777").type(MessageType.WHATSAPP).location_json_string(locationJson).create();
          ObjectMapper ow = new ObjectMapper();
          String json_output = ow.writeValueAsString(response);
          System.out.println(json_output);
        }
        catch (PlivoRestException | IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### Templated WhatsApp Messages With Named Parameter
This guide shows how to send templated WhatsApp messages with named parameters.

Example:
```java
import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;
import com.plivo.api.models.message.MessageType;
import com.fasterxml.jackson.databind.ObjectMapper;

class Test
{
    public static void main(String [] args)
    {
        Plivo.init("<auth_id>", "<auth_token>");
        try {
            String templateJson = "{\"name\":\"template_name\",\"language\":\"en_US\",\"components\":[{\"type\":\"header\",\"parameters\":[{\"type\":\"text\",\"parameter_name\":\"header_title\",\"text\":\"WA-header\"}]},{\"type\":\"body\",\"parameters\":[{\"type\":\"text\",\"parameter_name\":\"user_name\",\"text\":\"Saurabh\"}]}]}";

          MessageCreateResponse response = Message.creator("+14156667778","+14156667777").type(MessageType.WHATSAPP).template_json_string(templateJson).create();
          ObjectMapper ow = new ObjectMapper();
          String json_output = ow.writeValueAsString(response);
          System.out.println(json_output);
        }
        catch (PlivoRestException | IOException e) {
            e.printStackTrace();
        }
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
