package de.romankoutny.rest.server.services2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.romankoutny.rest.server.model.NameContainer;

//   curl -X GET "http://localhost:8888/jersey/json/name/Bello" -H Accept:application/json -H MYHDR:VVVV


@Path("/json")
public class JsonService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/name/{name}")
	public NameContainer execService(@PathParam("name") String name)
	{
		NameContainer nc = new NameContainer();
		nc.name = name;
		nc.ts = System.currentTimeMillis();
		return nc;
	}
	
}
