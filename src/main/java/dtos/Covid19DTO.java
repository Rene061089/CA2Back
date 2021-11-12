package dtos;

public class Covid19DTO
{

    private String country;
    private String code;
    private String confirmed;
    private String recovered;
    private String critical;
    private String deaths;


    public Covid19DTO(String country, String code, String confirmed, String recovered, String critical, String deaths)
    {
        this.country = country;
        this.code = code;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.critical = critical;
        this.deaths = deaths;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getConfirmed()
    {
        return confirmed;
    }

    public void setConfirmed(String confirmed)
    {
        this.confirmed = confirmed;
    }

    public String getRecovered()
    {
        return recovered;
    }

    public void setRecovered(String recovered)
    {
        this.recovered = recovered;
    }

    public String getCritical()
    {
        return critical;
    }

    public void setCritical(String critical)
    {
        this.critical = critical;
    }

    public String getDeaths()
    {
        return deaths;
    }

    public void setDeaths(String deaths)
    {
        this.deaths = deaths;
    }
}
