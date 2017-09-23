package de.romankoutny.rest.server.services.alexa.model.request;
public class Context
{
    private AudioPlayer AudioPlayer;

    private System System;

    public AudioPlayer getAudioPlayer ()
    {
        return AudioPlayer;
    }

    public void setAudioPlayer (AudioPlayer AudioPlayer)
    {
        this.AudioPlayer = AudioPlayer;
    }

    public System getSystem ()
    {
        return System;
    }

    public void setSystem (System System)
    {
        this.System = System;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [AudioPlayer = "+AudioPlayer+", System = "+System+"]";
    }
}