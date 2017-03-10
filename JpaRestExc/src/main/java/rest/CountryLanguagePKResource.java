
package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;


@Path("generic")
public class CountryLanguagePKResource
{

    @Context
    private UriInfo context;

    public CountryLanguagePKResource()
    {
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson()
    {
        return "lort";
    }

}
