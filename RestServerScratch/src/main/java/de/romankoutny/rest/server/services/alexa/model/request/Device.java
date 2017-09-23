package de.romankoutny.rest.server.services.alexa.model.request;
public class Device
{
    private String supportedInterfaces;

    public String getSupportedInterfaces ()
    {
        return supportedInterfaces;
    }

    public void setSupportedInterfaces (String supportedInterfaces)
    {
        this.supportedInterfaces = supportedInterfaces;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [supportedInterfaces = "+supportedInterfaces+"]";
    }
}