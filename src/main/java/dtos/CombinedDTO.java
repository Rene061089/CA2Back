package dtos;

import java.util.List;

public class CombinedDTO
{

    private String joke1;
    private String joke1Reference;
    private String joke2;
    private String joke2Reference;
    private List <Covid19DTO> covid;
    private String covidReference;
    private List <RandomRecipesDTO> recipes;



    public CombinedDTO(ChuckDTO chuckDTO, DadDTO dadDTO, List <Covid19DTO> covid19DTO, List <RandomRecipesDTO> randomRecipesDTO)
    {
        joke1 = chuckDTO.getValue();
        joke1Reference = chuckDTO.getUrl();
        joke2 = dadDTO.getJoke();
        joke2Reference = "https://icanhazdadjoke.com/j/" + dadDTO.getId();
        covid = covid19DTO;
        for (Covid19DTO dto : covid19DTO) {
            covidReference = "https://covid-19-data.p.rapidapi.com/country/code?code=" + dto.getCode();
        }
        recipes = randomRecipesDTO;

    }


    public List<RandomRecipesDTO> getRecipes()
    {
        return recipes;
    }

    public void setRecipes(List<RandomRecipesDTO> recipes)
    {
        this.recipes = recipes;
    }

    public List<Covid19DTO> getCovid() {
        return covid;
    }

    public void setCovid(List<Covid19DTO> covid) {
        this.covid = covid;
    }

    public String getCovidReference() {
        return covidReference;
    }

    public void setCovidReference(String covidReference) {
        this.covidReference = covidReference;
    }

    public String getJoke1()
    {
        return joke1;
    }

    public void setJoke1(String joke1)
    {
        this.joke1 = joke1;
    }

    public String getJoke1Reference()
    {
        return joke1Reference;
    }

    public void setJoke1Reference(String joke1Reference)
    {
        this.joke1Reference = joke1Reference;
    }

    public String getJoke2()
    {
        return joke2;
    }

    public void setJoke2(String joke2)
    {
        this.joke2 = joke2;
    }

    public String getJoke2Reference()
    {
        return joke2Reference;
    }

    public void setJoke2Reference(String joke2Reference)
    {
        this.joke2Reference = joke2Reference;
    }

}
