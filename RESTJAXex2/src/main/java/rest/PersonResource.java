/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import control.Facade;
import control.JSONConverter;
import entity.Person;
import java.util.List;
import javax.persistence.Persistence;
import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import static org.eclipse.persistence.sdo.helper.extension.Token.POST;


@Path("person")
public class PersonResource
{

    @Context
    private UriInfo context;
    
    Facade facade;
    
    public PersonResource()
    {
        facade = new Facade();
        facade.addEntityManagerFactory(Persistence.createEntityManagerFactory("pu", null));
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonById(@PathParam("id") int id)
    {
        Person p = facade.getPerson(id);
        return JSONConverter.getJsonFromPerson(p);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonList()
    {
        List<Person> people = facade.getPersons();
        return JSONConverter.getJsonFromPeople(people);
    }

    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postPerson(String content)
    {
        Person p = JSONConverter.getPersonFromJson(content);
        facade.addPerson(p);
        return JSONConverter.getJsonFromPerson(p);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String putData(String content)
    {
        Person p = JSONConverter.getPersonFromJson(content);
        facade.editPerson(p);
        return JSONConverter.getJsonFromPerson(p);
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteData(String content, @PathParam("id") int id)
    {
        Person p = facade.deletePeson(id);
        return JSONConverter.getJsonFromPerson(p);
    }
}
