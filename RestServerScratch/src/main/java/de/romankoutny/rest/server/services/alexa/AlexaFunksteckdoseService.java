package de.romankoutny.rest.server.services.alexa;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

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

    @POST
    @Path("/funksteckdose")
    public AlexaResponse execService(final AlexaRequest body)
    {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("ALEXA Body: " + body);
        
        AlexaResponse aResp = new AlexaResponse();
        Response resp = new Response();
        OutputSpeech outputSpeech = new OutputSpeech();
        outputSpeech.setText("ich schalte die Funksteckdose AUS.");
        outputSpeech.setType("PlainText");
        
        resp.setOutputSpeech(outputSpeech);
        
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(new OutputSpeech());
        reprompt.getOutputSpeech().setText("ich habe dich leider nicht verstanden");
        reprompt.getOutputSpeech().setType("PlainText");
        
        resp.setReprompt(reprompt);
        
        SpeechletResponse speechletResponse = new SpeechletResponse();
        speechletResponse.setOutputSpeech(new OutputSpeech());
        speechletResponse.getOutputSpeech().setText("ich schalte die Funksteckdose AUS.");
        speechletResponse.setReprompt(new Reprompt());
        speechletResponse.getReprompt().setOutputSpeech(new OutputSpeech());
        speechletResponse.getReprompt().getOutputSpeech().setText("ich habe dich leider nicht verstanden");
        speechletResponse.setShouldEndSession(false);
        
        resp.setSpeechletResponse(speechletResponse);
        
        aResp.setVersion("1.0");
        aResp.setSessionAttributes(null);
        aResp.setResponse(resp);
        
        return aResp;
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
