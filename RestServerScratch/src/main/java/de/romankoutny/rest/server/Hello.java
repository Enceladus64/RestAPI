package de.romankoutny.rest.server;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

// http://localhost:8888/jersey/hello
// curl -X GET "http://localhost:8888/jersey/hello/plain" -H Accept:text/plain
// curl -X GET "http://localhost:8888/jersey/hello/html/Roman" -H Accept:text/html
// curl -X GET "http://localhost:8888/jersey/hello/html/Roman?id=XXX" -H Accept:text/html
// curl -X GET "http://localhost:8888/jersey/hello/html/Roman?id=XXX" -H Accept:text/html -H MYHDR:VVVV

// @Consumes   @Provider 

//Sets the path to base URL + /hello
@Path("/hello")
public class Hello 
{

  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/plain")
  public String sayPlainTextHello() {
    return "Hello Jersey";
  }

  // This method is called if XML is request
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello() {
    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
  }

  // This method is called if HTML is request
  @GET
  @Produces(MediaType.TEXT_HTML)
  @Path("/html/{id}")
  public String sayHtmlHello(@PathParam("id") String id, @QueryParam("id") String id2, @HeaderParam("MYHDR") String hdr) {
    return "<html> " + "<title>" + "Hello " + id + " / " + id2 + " / " + hdr + "</title>"
        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
  }

}