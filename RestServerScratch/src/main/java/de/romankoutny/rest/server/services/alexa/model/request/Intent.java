package de.romankoutny.rest.server.services.alexa.model.request;
public class Intent
{
    private String slots;

    private String name;

    public String getSlots ()
    {
        return slots;
    }

    public void setSlots (String slots)
    {
        this.slots = slots;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [slots = "+slots+", name = "+name+"]";
    }
}