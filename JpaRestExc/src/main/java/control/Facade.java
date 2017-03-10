
package control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.City;
import entity.Country;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Facade
{
    private EntityManagerFactory emf;
    private EntityManager em;

    public Facade()
    {
        this.emf = Persistence.createEntityManagerFactory("pu", null);
        this.em = emf.createEntityManager();
    }
    
    public List getAllCitiesFromCountry(String cc)
    {
        //WIP GL Imorgen
        Query query = em.createQuery("SELECT c.name, c.population FROM City c WHERE c.countryCode = :cc");
        query.setParameter("cc", cc);
        return query.getResultList();
    }
    
    //Caching måske?
    public List getAllCountires()
    {
        Query query = em.createQuery("SELECT c.code, c.name, c.continent, c.localName FROM Country c");
        return query.getResultList();
    }
    
    public List getAllCountriesWithPopLimit(int populationLimit)
    {
        Query query = em.createQuery("SELECT c.code, c.name, c.continent, c.localName FROM Country c WHERE c.population > :populationLimit");
        query.setParameter("populationLimit", populationLimit);
        return query.getResultList();
    }
    
}
