package de.romankoutny.rest.spring;

import java.net.URL;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Starter
{
    public static void main(String[] args) throws Exception 
    {
        String webxml = "/WEB-INF/web.xml";
        
        URL url = Starter.class.getResource(webxml);
        String rootPath = url.getFile();
        
        Logger logger = LoggerFactory.getLogger(Starter.class);
        logger.info("webxml file:  {}", rootPath);
        
        Server server = new Server(8888);

        String base = rootPath.substring(0, rootPath.length()-webxml.length());
        
        WebAppContext webapp = new WebAppContext();
        webapp.setResourceBase(base);
        webapp.setDescriptor(rootPath);
        // webapp.setContextPath("/CTX");  //damit:   http://localhost:8888/CTX/jersey/hello/html/Roman
        server.setHandler(webapp);

        server.start();
        server.join();
    }

}
