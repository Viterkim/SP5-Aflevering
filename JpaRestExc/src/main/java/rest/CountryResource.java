
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static com.sun.jersey.api.model.Parameter.Source.PATH;
import control.Facade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


@Path("country")
public class CountryResource
{
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Facade facade;
    
    @Context
    private UriInfo context;


    public CountryResource()
    {
        facade = new Facade();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCountries()
    {
        String str = gson.toJson(facade.getAllCountires());
        return str;
    }
    
    @GET
    @Path("/pop/{limit}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCountriesWithPopLimit(@PathParam("limit") int limit)
    {
        String str = gson.toJson(facade.getAllCountriesWithPopLimit(limit));
        return str;
    }


}
