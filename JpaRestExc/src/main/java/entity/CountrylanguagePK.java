
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Embeddable
public class CountrylanguagePK implements Serializable
{

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CountryCode")
    private String countryCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Language")
    private String language;

    public CountrylanguagePK()
    {
    }
    
    public CountrylanguagePK(String countryCode, String language)
    {
        this.countryCode = countryCode;
        this.language = language;
    }
    
    public String getCountryCode()
    {
        return countryCode;
    }

    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

  
    
}
