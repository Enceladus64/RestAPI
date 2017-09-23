package de.romankoutny.alexa.funksteckdose;

import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

public class FunksteckdoseSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler
{
    
    private static final Set<String> supportedApplicationIds;
    
    static 
    {
         supportedApplicationIds = new HashSet<String>();
    }

    public FunksteckdoseSpeechletRequestStreamHandler()
    {
        super(new FunksteckdoseSpeechlet(), supportedApplicationIds);
    }
    
    public FunksteckdoseSpeechletRequestStreamHandler(Speechlet speechlet, Set<String> supportedApplicationIds)
    {
        super(speechlet, supportedApplicationIds);
    }

}
