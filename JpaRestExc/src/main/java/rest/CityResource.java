
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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


@Path("city")
public class CityResource
{
    private Facade facade;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;


    public CityResource()
    {
        facade = new Facade();
    }

    @GET
//    @Path("{CC}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCitiesFromCountryCode()
    {
        return gson.toJson(facade.getAllCitiesFromCountry("PHL"));
    }

}
