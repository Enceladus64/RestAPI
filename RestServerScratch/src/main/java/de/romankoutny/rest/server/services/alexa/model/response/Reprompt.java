package de.romankoutny.rest.server.services.alexa.model.response;
public class Reprompt
{
    private OutputSpeech outputSpeech;

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
        return "ClassPojo [outputSpeech = "+outputSpeech+"]";
    }
}