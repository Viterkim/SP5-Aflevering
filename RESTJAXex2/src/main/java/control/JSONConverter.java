
package control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import java.util.List;


public class JSONConverter
{
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    public static Person getPersonFromJson(String js)
    {
        Person p = gson.fromJson(js, Person.class);
        return p;
    }
    
    public static String getJsonFromPerson(Person p)
    {
        String str = gson.toJson(p);
        return str;
    }
    
    public static String getJsonFromPeople(List<Person> persons)
    {
        String str = gson.toJson(persons);
        return str;
    }
}
