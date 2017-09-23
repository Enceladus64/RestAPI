package de.romankoutny.rest.server.services.alexa.model.request;
public class AudioPlayer
{
    private String playerActivity;

    public String getPlayerActivity ()
    {
        return playerActivity;
    }

    public void setPlayerActivity (String playerActivity)
    {
        this.playerActivity = playerActivity;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [playerActivity = "+playerActivity+"]";
    }
}