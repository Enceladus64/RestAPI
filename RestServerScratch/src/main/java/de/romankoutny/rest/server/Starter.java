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
        
        String osname = System.getProperty("os.name").toLowerCase();
        boolean isLinux = osname.contains("linux");
        System.out.println("OS.Name " + osname);
        
        Server server = new Server(8888);

        String base = isLinux ? "/opt/Roman-Eclipse-WorkspaceLUNA/RestServerScratch/bin" :
                                "/Users/romankoutny/git/RestAPI/RestServerScratch/bin";
        
        String rootPath = base + "/WEB-INF/web.xml";
        WebAppContext webapp = new WebAppContext(); //rootPath, "");
        webapp.setResourceBase(base);
        webapp.setDescriptor(rootPath);
        server.setHandler(webapp);

        server.start();
        server.join();
        
    }
}
