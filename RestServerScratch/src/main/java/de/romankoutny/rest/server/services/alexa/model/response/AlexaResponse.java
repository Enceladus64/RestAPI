package de.romankoutny.rest.server.services.alexa.model.response;
public class AlexaResponse
{
    private Response response;

    private String sessionAttributes;

    private String version;

    public Response getResponse ()
    {
        return response;
    }

    public void setResponse (Response response)
    {
        this.response = response;
    }

    public String getSessionAttributes ()
    {
        return sessionAttributes;
    }

    public void setSessionAttributes (String sessionAttributes)
    {
        this.sessionAttributes = sessionAttributes;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [response = "+response+", sessionAttributes = "+sessionAttributes+", version = "+version+"]";
    }
}