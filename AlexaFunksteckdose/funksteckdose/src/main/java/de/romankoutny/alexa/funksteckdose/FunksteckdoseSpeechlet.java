package de.romankoutny.alexa.funksteckdose;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;



public class FunksteckdoseSpeechlet implements Speechlet
{
    private static final Logger log = LoggerFactory.getLogger(FunksteckdoseSpeechlet.class);

    private static final String HOST = "romankoutny.servebeer.com";
    private static final int PORT = 22666;
    private static final String TEMPLATE = "http://%s:%d/%s";
    
    private static final String  INTENT_AN = "steckdoseAn";
    private static final String  INTENT_AUS = "steckdoseAus";
    
    private static enum Command {AN, AUS};
    

    
    @Override
    public void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException
    {
        log.info("Funksteckdose onSessionStarted requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());
    }

    @Override
    public SpeechletResponse onLaunch(LaunchRequest request, Session session) throws SpeechletException
    {
        log.info("Funksteckdose onLaunch requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText("Ich kann die Funksteckdose nun für dich steuern.");
        return SpeechletResponse.newAskResponse(speech, createRepromptSpeech());
    }

    @Override
    public SpeechletResponse onIntent(IntentRequest request, Session session) throws SpeechletException
    {
        log.info("Funksteckdose onIntent requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());
        String intentName = request.getIntent().getName();
        log.info("Session:"+session+ " Intent: "+intentName);
        if (INTENT_AN.equals(intentName)) 
        {
            return handleCommand(session, Command.AN);
        } 
        else if (INTENT_AUS.equals(intentName)) 
        {
            return handleCommand(session, Command.AUS);
        } 
        else if ("AMAZON.HelpIntent".equals(intentName)) 
        {
            return handleHelpIntent();
        } 
        else if ("AMAZON.StopIntent".equals(intentName)) 
        {
            return handleStopIntent();
        } 
        else 
        {
            throw new SpeechletException("Invalid Intent");
        }
    }

    @Override
    public void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException
    {
        log.info("Funksteckdose onSessionEnded requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());
    }

    private SpeechletResponse handleCommand(final Session session, final Command cmd)
    {
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText("ich schalte die Funksteckdose " + cmd.toString() + "."); 
        
        sendFunksteckdosenCommand(cmd);
        
        return SpeechletResponse.newAskResponse(speech, createRepromptSpeech());
    }
    
    private SpeechletResponse handleStopIntent() 
    {
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText("Servus.");
        return SpeechletResponse.newTellResponse(speech);
    }

    private SpeechletResponse handleHelpIntent() 
    {
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText("Schalte die Funksteckdose ein oder aus");
        return SpeechletResponse.newTellResponse(speech);
    }

    private Reprompt createRepromptSpeech() 
    {
        PlainTextOutputSpeech repromptSpeech = new PlainTextOutputSpeech();
        repromptSpeech.setText("ich habe dich leider nicht verstanden");
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(repromptSpeech);
        return reprompt;
    }
    
    
    private void sendFunksteckdosenCommand(final Command cmd)
    {
        String url = String.format(TEMPLATE, HOST, PORT, cmd.toString());

        log.info("Funksteckdose Kommando {}  url: {}", cmd, url);

        try
        {
            URLConnection conn = new URL(url).openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(false);
    
            conn.connect();
            log.info("Funksteckdose Connect OK");
            
            InputStream is = conn.getInputStream();
            while(is.available() > 0)
            {
                is.read();
            }
            
            log.info("Funksteckdose vor Close");
            is.close();
        }
        catch(Exception ioex)
        {
            log.error("Fehler bei ESP8266 Kommunikation", ioex);
        }
                
    }

}
