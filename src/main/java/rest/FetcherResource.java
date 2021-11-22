package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.RecipesDTO;
import facades.RecipesFacade;
import utils.EMF_Creator;
import facades.FacadeExample;
import utils.HttpUtils;

import javax.persistence.EntityManagerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutionException;


//Todo Remove or change relevant parts before ACTUAL use
@Path("fetch")
public class FetcherResource
{

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private final RecipesFacade recipesFacade = RecipesFacade.getRecipesFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    Gson gson = new Gson();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJokes() throws IOException, ExecutionException, InterruptedException
    {
//        LocalTime start = LocalTime.now();
//        String result = gson.toJson(HttpUtils.fetchDataSequential());
//        LocalTime end = LocalTime.now();
//        System.out.println("resultat 1  Sequential " + ChronoUnit.MILLIS.between(start,end));

//        Thread.sleep(5000);

        LocalTime start2 = LocalTime.now();
        String result2 = gson.toJson(HttpUtils.fetchDataParallel());
        result2 = result2.replaceAll("[@]", "");
        LocalTime end2 = LocalTime.now();
        System.out.println("resultat 2 Parallel " + ChronoUnit.MILLIS.between(start2, end2));

        return result2;

    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response setRecipesToUser(String r)
    {
        RecipesDTO recipesDTO = GSON.fromJson(r, RecipesDTO.class);
        RecipesDTO result = recipesFacade.setRecipes(recipesDTO);
        return Response.ok().entity(GSON.toJson(result)).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRecipesById(@PathParam("id") String id)
    {
        RecipesDTO recipesDTO = recipesFacade.getRecipes(id);
        return Response.ok().entity(GSON.toJson(recipesDTO)).build();
    }

    @Path("dad")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getdadJokes() throws IOException, ExecutionException, InterruptedException
    {
        String result = gson.toJson(HttpUtils.singleDadFetch());
        return result;
    }

    @Path("chuck")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getChuckJokes() throws IOException, ExecutionException, InterruptedException
    {
        String result = gson.toJson(HttpUtils.singleChuckFetch());
        return result;
    }

    @Path("covid")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCovid() throws IOException, ExecutionException, InterruptedException
    {
        String result = gson.toJson(HttpUtils.singleCovidFetch());
        return result;
    }


    @Path("recipes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRecipes() throws IOException, ExecutionException, InterruptedException
    {
        String result = gson.toJson(HttpUtils.singleRecipesFetch());
        result = result.replaceAll("@type", "type");
        return result;
    }
}
