package dtos;

public class DadDTO
{
    private String id;
    private String joke;

    public DadDTO(String id, String joke)
    {
        this.id = id;
        this.joke = joke;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getJoke()
    {
        return joke;
    }

    public void setJoke(String joke)
    {
        this.joke = joke;
    }

}
