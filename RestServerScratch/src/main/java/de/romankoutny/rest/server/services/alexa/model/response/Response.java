package de.romankoutny.rest.server.services.alexa.model.response;
public class Response
{
    private Reprompt reprompt;

    private SpeechletResponse speechletResponse;

    private OutputSpeech outputSpeech;

    private boolean shouldEndSession;

    
    /**
     * @return the shouldEndSession
     */
    public boolean isShouldEndSession()
    {
        return shouldEndSession;
    }

    /**
     * @param shouldEndSession the shouldEndSession to set
     */
    public void setShouldEndSession(boolean shouldEndSession)
    {
        this.shouldEndSession = shouldEndSession;
    }

    public Reprompt getReprompt ()
    {
        return reprompt;
    }

    public void setReprompt (Reprompt reprompt)
    {
        this.reprompt = reprompt;
    }

    public SpeechletResponse getSpeechletResponse ()
    {
        return speechletResponse;
    }

    public void setSpeechletResponse (SpeechletResponse speechletResponse)
    {
        this.speechletResponse = speechletResponse;
    }

    public OutputSpeech getOutputSpeech ()
    {
        return outputSpeech;
    }

    public void setOutputSpeech (OutputSpeech outputSpeech)
    {
        this.outputSpeech = outputSpeech;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [reprompt = "+reprompt+", speechletResponse = "+speechletResponse+", outputSpeech = "+outputSpeech+"]";
    }
}