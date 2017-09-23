package de.romankoutny.rest.server.services.alexa.model.request;
public class System
{
    private Application application;

    private Device device;

    private User user;

    public Application getApplication ()
    {
        return application;
    }

    public void setApplication (Application application)
    {
        this.application = application;
    }

    public Device getDevice ()
    {
        return device;
    }

    public void setDevice (Device device)
    {
        this.device = device;
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
        return "ClassPojo [application = "+application+", device = "+device+", user = "+user+"]";
    }
}