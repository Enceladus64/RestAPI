package de.romankoutny.rest.server.services.alexa.model.request;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;

public class Session
{
    private Application application;

    private boolean newSession;

    private String sessionId;

    private String attributes;

    private User user;

    public Application getApplication ()
    {
        return application;
    }

    public void setApplication (Application application)
    {
        this.application = application;
    }

    @JsonProperty("new")
    public boolean getNew ()
    {
        return newSession;
    }

    @JsonProperty("new")
    public void setNew (boolean newSession)
    {
        this.newSession = newSession;
    }

    public String getSessionId ()
    {
        return sessionId;
    }

    public void setSessionId (String sessionId)
    {
        this.sessionId = sessionId;
    }

    public String getAttributes ()
    {
        return attributes;
    }

    public void setAttributes (String attributes)
    {
        this.attributes = attributes;
    }

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [application = "+application+", new = "+newSession+", sessionId = "+sessionId+", attributes = "+attributes+", user = "+user+"]";
    }
}