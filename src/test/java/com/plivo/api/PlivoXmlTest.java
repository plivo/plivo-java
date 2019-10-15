package com.plivo.api;

import com.plivo.api.exceptions.PlivoXmlException;
import com.plivo.api.xml.Conference;
import com.plivo.api.xml.Dial;
import com.plivo.api.xml.GetDigits;
import com.plivo.api.xml.GetInput;
import com.plivo.api.xml.Message;
import com.plivo.api.xml.Number;
import com.plivo.api.xml.Play;
import com.plivo.api.xml.PlivoXml;
import com.plivo.api.xml.PreAnswer;
import com.plivo.api.xml.Record;
import com.plivo.api.xml.Response;
import com.plivo.api.xml.ResponseNestable;
import com.plivo.api.xml.Speak;
import com.plivo.api.xml.User;
import com.plivo.api.xml.Wait;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class PlivoXmlTest {
  @Test
  public void toStringShouldSucceed() throws Exception {
    assertEquals("<Response>\n<Speak>Plivo®</Speak>\n</Response>", new Response()
      .children(
        new Speak("Plivo®")
      ).toXmlString()
    );
  }

  private <T extends PlivoXml> T p(T t) {
    HashMap<String, Object> values = new HashMap<>();
    for (Method method : t.getClass().getMethods()) {
      if (method.getParameterCount() == 0) {
        String methodName = method.getName();
        try {
          t.getClass().getDeclaredField(methodName);
          values.put(methodName, method.invoke(t));
        } catch (NoSuchFieldException | SecurityException | IllegalAccessException | InvocationTargetException e) {
          //nop
        }
      }
    }
    for (Method method : t.getClass().getMethods()) {
      if (method.getParameterCount() == 1) {
        String methodName = method.getName();
        try {
          t.getClass().getDeclaredField(methodName);
          if(method.getName().equals("children"))
            continue;
          Object value = values.get(methodName);
          method.invoke(t, value);
        } catch (NoSuchFieldException | SecurityException | IllegalAccessException | InvocationTargetException e) {
          //nop
        }
      }
    }
    System.out.println(values);
    return t;
  }

  @Test
  public void constructionShouldSucceed() throws Exception {
    Response response = new Response()
      .children(
        p(new PreAnswer()
          .children(
            p(new Speak("test")),
            p(new Play("http://url.to.media")),
            p(new Wait())
          )),
        p(new Speak("test")),
        p(new Wait()),
        p(new Dial()
          .children(
            p(new Number("123")),
            p(new User("sip:test@sip.plivo.com"))
          )),
        p(new Message("123", "456", "content")),
        p(new Play("http://url.to.media")),
        p(new Record("http://action")),
        p(new GetDigits()
          .children(
            p(new Speak("getDigits")),
            p(new Play("http://url.to.media"))
          )),
        p(new GetInput()
          .children(
            p(new Speak("getInput")),
            p(new Play("http://url.to.media"))
          )),
        p(new Conference("test"))
      );
    response.toXmlString();
  }
}
