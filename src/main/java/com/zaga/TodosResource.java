package com.zaga;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.panache.common.Sort;


@Produces(MediaType.APPLICATION_JSON)
@Path("/hello")
public class TodosResource {
 
    @GET
    public List<Todo> list(){
        return Todo.listAll(Sort.by("title"));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @RolesAllowed("admin")
    public Todo add(Todo todo){
        todo.persist();
        return todo;
    }
    
    @Transactional
    @DELETE
    public void clearAll (){
     Todo.clearCompleted();
    } 

    @GET
    @Path("search/{title}")
    public List<Todo> findByTitle(@PathParam("title") String title){
        return Todo.findByTiltle(title);
    }
}
