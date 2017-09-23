package de.romankoutny.rest.server.services.alexa.model.response;
public class Response
{
    private Reprompt reprompt;

    private SpeechletResponse speechletResponse;

    private OutputSpeech outputSpeech;

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