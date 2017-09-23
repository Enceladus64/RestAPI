package de.romankoutny.rest.server.services.alexa.model.response;
public class OutputSpeech
{
    private String text;

    private String type;

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [text = "+text+", type = "+type+"]";
    }
}