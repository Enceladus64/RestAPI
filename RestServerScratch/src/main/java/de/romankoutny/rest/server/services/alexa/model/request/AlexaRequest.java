package de.romankoutny.rest.server.services.alexa.model.request;

public class AlexaRequest
{
    private Session session;

    private Request request;

    private Context context;

    private String version;

    public Session getSession ()
    {
        return session;
    }

    public void setSession (Session session)
    {
        this.session = session;
    }

    public Request getRequest ()
    {
        return request;
    }

    public void setRequest (Request request)
    {
        this.request = request;
    }

    public Context getContext ()
    {
        return context;
    }

    public void setContext (Context context)
    {
        this.context = context;
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
        return "ClassPojo [session = "+session+", request = "+request+", context = "+context+", version = "+version+"]";
    }
}