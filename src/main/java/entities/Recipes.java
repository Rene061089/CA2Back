package entities;

import javax.persistence.*;
import java.util.ArrayList;

@Table(name = "recipes")
@Entity
public class Recipes
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipes_id", nullable = false)
    private String recipes_id;
    private String title;
    private String ingredients;
    private String img_reference;
//    private Long instrutions;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private User user;

    public Recipes(User user)
    {
        this.user = user;
    }


    public Recipes(String title, String ingredients, String img_reference)
    {
        this.title = title;
        this.ingredients = ingredients;
        this.img_reference = img_reference;
    }

    public Recipes()
    {

    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
        if(user != null){
            user.setRecipes(new ArrayList<>());
    }
    }

    public String getRecipes_id()
    {
        return recipes_id;
    }

    public void setRecipes_id(String recipes_id)
    {
        this.recipes_id = recipes_id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getIngredients()
    {
        return ingredients;
    }

    public void setIngredients(String ingredients)
    {
        this.ingredients = ingredients;
    }

    public String getImg_reference()
    {
        return img_reference;
    }

    public void setImg_reference(String img_reference)
    {
        this.img_reference = img_reference;
    }
}