package de.romankoutny.rest.spring.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.romankoutny.rest.spring.model.NameContainer;
import de.romankoutny.rest.spring.model.PostBody;


//curl -X POST "http://localhost:8888/spring/sub/name/Bello" -H Accept:application/json -H "Content-Type:application/json" --data '{"bodyid":"Lupo"}'


@RestController
@RequestMapping("sub")
public class Controller
{
    // @RequestMapping(value = "/name/{name}", method = RequestMethod.POST,headers="Accept=application/json")
    @RequestMapping(value = "/name/{name}", method = RequestMethod.POST,consumes="application/json",produces="application/json")
    public NameContainer execService(@PathVariable String name, @RequestBody final PostBody body)
    {
        NameContainer nc = new NameContainer();
        nc.name = "Subpackage " + name + "   id: " + body.bodyid;
        nc.ts = System.currentTimeMillis();
        
        Logger logger = LoggerFactory.getLogger(Controller.class);
        logger.info("Response Springcall:  {}   {}", nc.name, nc.ts);

        return nc;
    }

    
    // @RequestParam(value="query", required=false)
    // @RequestHeader
}
