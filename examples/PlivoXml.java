import com.plivo.bridge.to.command.ApplicationResponse;
import com.plivo.bridge.to.command.Speak;
import javax.xml.bind.Marshaller;


public class PlivoXml {
    public static void main(String[] args) {

        ApplicationResponse response = new ApplicationResponse();

        Speak speakElement = new Speak();
        speakElement.setVoice("MAN");

        speakElement.setLanguage("en_US");
        speakElement.setLoop(8);

        response.setSpeak(speakElement);

    }
}




