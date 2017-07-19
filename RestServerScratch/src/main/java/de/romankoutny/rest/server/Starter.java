package de.romankoutny.rest.server;

import java.net.URL;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Starter
{

    public static void __main(String[] args) throws Exception
    {
        Server server = new Server(8888);

        server.setHandler(new FirstHandler());
        
        server.start();
        server.join();
    }

    
    public static void ___main(String[] args) throws Exception
    {
        new HttpServer().starteServer();
        
        synchronized (Starter.class)
        {
            Starter.class.wait();
        }
    }
    
    
    public static void main(String[] args) throws Exception 
    {
        URL url = Starter.class.getResource("/WEB-INF/web.xml");
        String fn = url.getFile();
        System.out.println("webxml file    " + fn);
        
        
        
        Server server = new Server(8888);

        String rootPath = "/opt/Roman-Eclipse-WorkspaceLUNA/RestServerScratch/bin/WEB-INF/web.xml";
        WebAppContext webapp = new WebAppContext(); //rootPath, "");
        webapp.setResourceBase("/opt/Roman-Eclipse-WorkspaceLUNA/RestServerScratch/bin");
        webapp.setDescriptor(rootPath);
        server.setHandler(webapp);

        server.start();
        server.join();
        
    }
}
