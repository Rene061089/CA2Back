package dtos;

import entities.Recipes;

import java.util.ArrayList;
import java.util.List;

public class RecipesDTO
{

    private String dto_title;
    private String dto_ingredients;
    private String dto_img_reference;
    private String dto_recipes_id;
    private String dto_user;

    public RecipesDTO()
    {
    }

    public RecipesDTO(Recipes r)
    {
        if(r.getRecipes_id() != null){}
        this.dto_recipes_id = r.getRecipes_id();
        this.dto_title = r.getTitle();
        this.dto_ingredients = r.getIngredients();
        this.dto_img_reference = r.getImg_reference();
        this.dto_user = r.getUser().getUserName();

    }

    public static List<RecipesDTO> getDtos(List<Recipes> recipes){
        List<RecipesDTO> recipesDTOList = new ArrayList();
        recipes.forEach(r -> recipesDTOList.add(new RecipesDTO(r)));
        return recipesDTOList;
    }

    public String getDto_user()
    {
        return dto_user;
    }

    public void setDto_user(String dto_user)
    {
        this.dto_user = dto_user;
    }

    public String getDto_title()
    {
        return dto_title;
    }

    public void setDto_title(String dto_title)
    {
        this.dto_title = dto_title;
    }

    public String getDto_ingredients()
    {
        return dto_ingredients;
    }

    public void setDto_ingredients(String dto_ingredients)
    {
        this.dto_ingredients = dto_ingredients;
    }

    public String getDto_img_reference()
    {
        return dto_img_reference;
    }

    public void setDto_img_reference(String dto_img_reference)
    {
        this.dto_img_reference = dto_img_reference;
    }

    public String getDto_recipes_id()
    {
        return dto_recipes_id;
    }

    public void setDto_recipes_id(String dto_recipes_id)
    {
        this.dto_recipes_id = dto_recipes_id;
    }
}
