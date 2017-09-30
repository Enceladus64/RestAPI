package de.romankoutny.rest.server.services.alexa;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.romankoutny.rest.server.services.alexa.model.request.AlexaRequest;
import de.romankoutny.rest.server.services.alexa.model.response.AlexaResponse;
import de.romankoutny.rest.server.services.alexa.model.response.OutputSpeech;
import de.romankoutny.rest.server.services.alexa.model.response.Reprompt;
import de.romankoutny.rest.server.services.alexa.model.response.Response;
import de.romankoutny.rest.server.services.alexa.model.response.SpeechletResponse;

//curl -X POST "http://localhost:8888/jersey/alexa/funksteckdose"

@Path("/alexa")
public class AlexaFunksteckdoseService
{
    private static final String HOST = "192.168.2.167";
    private static final int PORT = 81;
    private static final String TEMPLATE = "http://%s:%d/%s";

    private static final String NICHT_VERSTANDEN = "ich habe dich leider nicht verstanden";
    private static final String PLAIN_TEXT = "PlainText";
    
    private static enum Command {AN, AUS};

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/funksteckdose")
    public AlexaResponse execService(final AlexaRequest body)
    {
        logger.info("ALEXA Body: " + body);
        
        String intentName = body.getRequest().getIntent().getName();
        String answerText;
        
        try
        {
            switch(intentName)
            {
                case "steckdoseAn":
                    answerText = "ich schalte die Funksteckdose ein.";
                    sendFunksteckdosenCommand(Command.AN);
                    break;
                case "steckdoseAus":
                    answerText = "ich schalte die Funksteckdose aus.";
                    sendFunksteckdosenCommand(Command.AUS);
                    break;
                case "AMAZON.StopIntent":
                    answerText = "Servus.";
                    break;
                case "AMAZON.HelpIntent":
                    answerText = "Schalte die Funksteckdose ein oder aus";
                    break;
                default:
                    answerText = "Ich kann die Funksteckdose nun für dich steuern.";
            }
        }
        catch(Exception ex)
        {
            answerText = "etwas ist gerade fürchterlich schief gelaufen.";
        }
        
        AlexaResponse aResp = new AlexaResponse();
        Response resp = new Response();
        OutputSpeech outputSpeech = new OutputSpeech();
        outputSpeech.setText(answerText);
        outputSpeech.setType(PLAIN_TEXT);
        
        resp.setOutputSpeech(outputSpeech);
        
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(new OutputSpeech());
        reprompt.getOutputSpeech().setText(NICHT_VERSTANDEN);
        reprompt.getOutputSpeech().setType(PLAIN_TEXT);
        
        resp.setReprompt(reprompt);
        
        SpeechletResponse speechletResponse = new SpeechletResponse();
        speechletResponse.setOutputSpeech(new OutputSpeech());
        speechletResponse.getOutputSpeech().setText(answerText);
        speechletResponse.setReprompt(new Reprompt());
        speechletResponse.getReprompt().setOutputSpeech(new OutputSpeech());
        speechletResponse.getReprompt().getOutputSpeech().setText(NICHT_VERSTANDEN);
        speechletResponse.setShouldEndSession(false);
        
        resp.setSpeechletResponse(speechletResponse);
        
        aResp.setVersion("1.0");
        aResp.setSessionAttributes(null);
        aResp.setResponse(resp);
        
        return aResp;
    }
    
    
    private void sendFunksteckdosenCommand(final Command cmd)
    {
        Thread t = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                sendFunksteckdosenCommandSub(cmd);
            }
        });
        
        t.setDaemon(true);
        t.start();
    }
    
    private void sendFunksteckdosenCommandSub(final Command cmd)
    {
        String url = String.format(TEMPLATE, HOST, PORT, cmd.toString());

        logger.info("Funksteckdose Kommando {}  url: {}", cmd, url);

        try
        {
            URLConnection conn = new URL(url).openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(false);
    
            conn.connect();
            logger.info("Funksteckdose Connect OK");
            
            InputStream is = conn.getInputStream();
            while(is.available() > 0)
            {
                is.read();
            }
            
            logger.info("Funksteckdose vor Close");
            is.close();
        }
        catch(Exception ioex)
        {
            logger.error("Fehler bei ESP8266 Kommunikation", ioex);
        }
                
    }

}


/* REQUEST
{
  "session": {
    "new": true,
    "sessionId": "SessionId.cc4c0269-e804-4d1b-8ab0-50c5d882ea4f",
    "application": {
      "applicationId": "amzn1.ask.skill.6eb3e4a4-2306-4e15-8022-1d89e4af3db5"
    },
    "attributes": {},
    "user": {
      "userId": "amzn1.ask.account.AFQUNFLTHDRFJNVAYD33F55LL2CRK7XXGIE3GK6ZUAG6B5DENGSWE7CL3P2QWPP6UOHPBEN65YGCFMOO25VPCL5E64ONFVJRHGXYXLNJMOF5VIIPYK2TOEKBSF6RMGNSIH54ML6FLQAYPPWVWVC53YSPZJR6JVWVJO4SN3WCSZRNXF6KTLHFCPXO5QF7YLXTE4OCJMRW6LCPQ5A"
    }
  },
  "request": {
    "type": "IntentRequest",
    "requestId": "EdwRequestId.c6892fc6-9bf2-4004-a976-e8865d03bacd",
    "intent": {
      "name": "steckdoseAn",
      "slots": {}
    },
    "locale": "de-DE",
    "timestamp": "2017-09-23T10:35:25Z"
  },
  "context": {
    "AudioPlayer": {
      "playerActivity": "IDLE"
    },
    "System": {
      "application": {
        "applicationId": "amzn1.ask.skill.6eb3e4a4-2306-4e15-8022-1d89e4af3db5"
      },
      "user": {
        "userId": "amzn1.ask.account.AFQUNFLTHDRFJNVAYD33F55LL2CRK7XXGIE3GK6ZUAG6B5DENGSWE7CL3P2QWPP6UOHPBEN65YGCFMOO25VPCL5E64ONFVJRHGXYXLNJMOF5VIIPYK2TOEKBSF6RMGNSIH54ML6FLQAYPPWVWVC53YSPZJR6JVWVJO4SN3WCSZRNXF6KTLHFCPXO5QF7YLXTE4OCJMRW6LCPQ5A"
      },
      "device": {
        "supportedInterfaces": {}
      }
    }
  },
  "version": "1.0"
}
     */
    
/*    RESPONSE
{
  "version": "1.0",
  "response": {
    "outputSpeech": {
      "text": "ich schalte die Funksteckdose AUS.",
      "type": "PlainText"
    },
    "reprompt": {
      "outputSpeech": {
        "text": "ich habe dich leider nicht verstanden",
        "type": "PlainText"
      }
    },
    "speechletResponse": {
      "outputSpeech": {
        "text": "ich schalte die Funksteckdose AUS."
      },
      "reprompt": {
        "outputSpeech": {
          "text": "ich habe dich leider nicht verstanden"
        }
      },
      "shouldEndSession": false
    }
  },
  "sessionAttributes": {}
}


STOP RESPONSE
{
  "version": "1.0",
  "response": {
    "outputSpeech": {
      "text": "Servus.",
      "type": "PlainText"
    },
    "speechletResponse": {
      "outputSpeech": {
        "text": "Servus."
      }
    }
  },
  "sessionAttributes": {}
}


 */
