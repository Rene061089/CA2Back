package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.EMF_Creator;
import facades.FacadeExample;
import utils.HttpUtils;

import javax.persistence.EntityManagerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutionException;


//Todo Remove or change relevant parts before ACTUAL use
@Path("fetch")
public class FetcherResource
{

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final FacadeExample FACADE = FacadeExample.getFacadeExample(EMF);
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
        result2 = result2.replaceAll("[@]","");
        LocalTime end2 = LocalTime.now();
        System.out.println("resultat 2 Parallel " +ChronoUnit.MILLIS.between(start2,end2));

        return result2;

    }

}
