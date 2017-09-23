package de.romankoutny.alexa.funksteckdose;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;



public class ESP8266ConnectTest
{
    private static final String HOST = "192.168.2.167";
    private static final int PORT = 81;
    private static final String TEMPLATE = "http://%s:%d/%s";

    private static enum Command {AN, AUS};

    
    public static void main(String[] args) throws Exception
    {
        connect(Command.AN);
        
        Thread.sleep(3000);
        
        connect(Command.AUS);
    }
    
    
    private static void connect(final Command cmd) throws Exception
    {
        String url = String.format(TEMPLATE, HOST, PORT, cmd.toString());
        
        URLConnection conn = new URL(url).openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(false);
        
        conn.connect();
//        OutputStream os = conn.getOutputStream();
//        os.flush();
//        os.close();
        
        InputStream is = conn.getInputStream();
        while(is.available() > 0)
        {
            is.read();
        }
        
        is.close();
    }

}
