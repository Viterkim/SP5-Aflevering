
package control;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Facade implements IPersonFacade
{
    private EntityManagerFactory emf;
    private EntityManager em;

    public Facade()
    {
    }
    
    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf)
    {
        this.emf = emf;
        this.em = emf.createEntityManager();
    }

    @Override
    public Person addPerson(Person p)
    {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return p;
    }

    @Override
    public Person deletePeson(int id)
    {
        em.getTransaction().begin();
        Person p = getPerson(id);
        em.remove(p);
        em.getTransaction().commit();
        return p;
    }

    @Override
    public Person getPerson(int id)
    {
        Query query = em.createQuery("SELECT p FROM Person p WHERE p.id = :id");
        query.setParameter("id", id);
        Person p = (Person)query.getSingleResult();
        return p;
    }

    @Override
    public List<Person> getPersons()
    {
        Query query = em.createQuery("SELECT p FROM Person p");
        return query.getResultList();
    }
    
    @Override
    public Person editPerson(Person p)
    {
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        return p;
    }
    
}
