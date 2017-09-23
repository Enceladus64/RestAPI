package de.romankoutny.rest.server.services.alexa.model.response;
public class SpeechletResponse
{
    private Reprompt reprompt;

    private OutputSpeech outputSpeech;

    private boolean shouldEndSession;

    public Reprompt getReprompt ()
    {
        return reprompt;
    }

    public void setReprompt (Reprompt reprompt)
    {
        this.reprompt = reprompt;
    }

    public OutputSpeech getOutputSpeech ()
    {
        return outputSpeech;
    }

    public void setOutputSpeech (OutputSpeech outputSpeech)
    {
        this.outputSpeech = outputSpeech;
    }

    public boolean getShouldEndSession ()
    {
        return shouldEndSession;
    }

    public void setShouldEndSession (boolean shouldEndSession)
    {
        this.shouldEndSession = shouldEndSession;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [reprompt = "+reprompt+", outputSpeech = "+outputSpeech+", shouldEndSession = "+shouldEndSession+"]";
    }
}