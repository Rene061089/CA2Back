package dtos;

import java.util.List;

public class CombinedDTO
{


    private List <Covid19DTO> covid;
    private String covidReference;
    private List <RandomRecipesDTO> recipes;



    public CombinedDTO(List <Covid19DTO> covid19DTO, List <RandomRecipesDTO> randomRecipesDTO)
    {

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



}
