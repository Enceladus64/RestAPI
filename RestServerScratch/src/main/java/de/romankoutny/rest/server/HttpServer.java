package de.romankoutny.rest.server;


import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpServer
{
    private static final String WEB_CONTEXT = "/jetty";
    private static final String SERVLET_PATH = "/";


    private static int PORT = 8888;;
    
    private static Server server;   // Jetty Server

    
    public void starteServer() throws Exception
    {
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath(WEB_CONTEXT);
        handler.addServlet(FirstServlet.class, SERVLET_PATH);
        server = new Server(PORT);
        Logger logger = LoggerFactory.getLogger(getClass());
        
        server.setHandler(handler);
        server.start();
        
        Thread.sleep(300);
        logger.info("Test startup in browser. Link localhost: " + PORT + " " + WEB_CONTEXT + " " + SERVLET_PATH );
    }
    
    
    public void stopServer() throws Exception
    {
        server.stop();
    }
}
