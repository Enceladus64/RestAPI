package de.romankoutny.rest.server.services.alexa.model.request;
public class Application
{
    private String applicationId;

    public String getApplicationId ()
    {
        return applicationId;
    }

    public void setApplicationId (String applicationId)
    {
        this.applicationId = applicationId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [applicationId = "+applicationId+"]";
    }
}