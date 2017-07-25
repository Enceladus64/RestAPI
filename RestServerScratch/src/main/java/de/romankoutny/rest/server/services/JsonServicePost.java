package de.romankoutny.rest.server.services;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.romankoutny.rest.server.NameContainer;

// " um json identifier herum sind wichtig"""""""
// curl -X POST "http://localhost:8888/jersey/sub/name/Bello" -H Accept:application/json -H "Content-Type:application/json" --data '{"bodyid":"Lupo"}'

@Path("/sub")
public class JsonServicePost {

	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/name/{name}")
	public NameContainer execService(@PathParam("name") String name, final PostBody body)
	{
		NameContainer nc = new NameContainer();
		nc.name = "Subpackage " + name + "   id: " + body.bodyid;
		nc.ts = System.currentTimeMillis();
		return nc;
	}
	
//    @POST
//    @Path("/name")
//    public NameContainer execService(final PostBody body)
//    {
//        NameContainer nc = new NameContainer();
//        nc.name = "Subpackage " + "name" + "   id: " + body.bodyid;
//        nc.ts = System.currentTimeMillis();
//        return nc;
//    }
    
}