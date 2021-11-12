package dtos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RandomRecipesDTO
{

    private String title;
    private List ingredients;
    private List instructions;
    private String image ;

    public RandomRecipesDTO(String title, List ingredients, List instructions, String image)
    {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.image = image;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public List getIngredients()
    {
        return ingredients;
    }

    public void setIngredients(List ingredients)
    {
        this.ingredients = ingredients;
    }

    public List getInstructions()
    {
        return instructions;
    }

    public void setInstructions(List instructions)
    {
        this.instructions = instructions;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }
}
