package facades;

import dtos.RecipesDTO;
import entities.Recipes;
import entities.User;
import security.errorhandling.AuthenticationException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class RecipesFacade
{

    private static EntityManagerFactory emf;
    private static RecipesFacade instance;

    public RecipesFacade()
    {
    }

    /**
     * @param _emf
     * @return the instance of this facade.
     */
    public static RecipesFacade getRecipesFacade(EntityManagerFactory _emf)
    {
        if (instance == null)
        {
            emf = _emf;
            instance = new RecipesFacade();
        }
        return instance;
    }


    public RecipesDTO getRecipes(String id)
    {
        EntityManager em = emf.createEntityManager();

        return new RecipesDTO(em.find(Recipes.class, id));

    }

    public RecipesDTO setRecipes(RecipesDTO r)
    {

        EntityManager em = emf.createEntityManager();

        Recipes recipes = new Recipes();
        recipes.setTitle(r.getDto_title());
        recipes.setIngredients(r.getDto_ingredients());
        recipes.setImg_reference(r.getDto_img_reference());

        User user = em.find(User.class, r.getDto_user());
        recipes.setUser(user);



        em.getTransaction().begin();
        em.persist(recipes);
        em.getTransaction().commit();

        return new RecipesDTO(recipes);

    }


}
