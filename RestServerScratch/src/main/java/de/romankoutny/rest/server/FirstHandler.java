package de.romankoutny.rest.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;


/*

 curl -X POST "http://localhost:8888/somepath?qq=aa&rr=bb" -d "{abc:13}" -H header1:val1 -H header2:val2


curl --data "@/path/to/filename" http://...
cat file.txt | curl --data "@-"

 */
public class FirstHandler extends AbstractHandler
{

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        System.out.println("Target: " + target);
        System.out.println("Method: " + baseRequest.getMethod());
        System.out.println("QueryStr: " + baseRequest.getQueryString());
        System.out.println("Body::: ");
        BufferedReader br = baseRequest.getReader();
        while(br != null)
        {
            String s = br.readLine();
            if(s == null)
            {
                br.close();
                break;
            }
            System.out.println(s);
        }
        System.out.println("::: Body");
        
        System.out.println("Header1: " + baseRequest.getHeader("header1"));
        System.out.println("Header2: " + baseRequest.getHeader("header2"));
        
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();

        out.println("<h1> FirstServlet </h1>");

        baseRequest.setHandled(true);
    }

}
