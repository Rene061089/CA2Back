package utils;

import com.google.gson.Gson;
import dtos.*;
import edu.emory.mathcs.backport.java.util.Arrays;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HttpUtils
{

    private static Gson gson = new Gson();

    public static CombinedDTO fetchDataParallel() throws IOException, MalformedURLException, ExecutionException, InterruptedException
    {

        ExecutorService es = Executors.newCachedThreadPool();
        Future<ChuckDTO> chuckDTOFuture = es.submit(
                HttpUtils::singleChuckFetch
//                        gson.fromJson(HttpUtils.fetchData("https://api.chucknorris.io/jokes/random"), ChuckDTO.class)
        );

        Future<DadDTO> dadDTOFuture = es.submit(
                HttpUtils::singleDadFetch
//                        gson.fromJson(HttpUtils.fetchData("https://icanhazdadjoke.com"), DadDTO.class)
        );

        Future<Covid19DTO[]> c19DTOFuture = es.submit(
                () -> gson.fromJson(HttpUtils.fetchData("https://covid-19-data.p.rapidapi.com/country/code?code=dk"), Covid19DTO[].class)
        );

        Future<RandomRecipesDTO[]> rRDTOFuture = es.submit(
                () -> gson.fromJson(HttpUtils.fetchData("https://random-recipes.p.rapidapi.com/ai-quotes/1"), RandomRecipesDTO[].class)

        );


        ChuckDTO chuckDTO = chuckDTOFuture.get();
        DadDTO dadDTO = dadDTOFuture.get();
        List<Covid19DTO> covid19DTO = Arrays.asList(c19DTOFuture.get());
        List<RandomRecipesDTO> randomRecipesDTO = Arrays.asList(rRDTOFuture.get());
        CombinedDTO combinedDTO = new CombinedDTO(chuckDTO, dadDTO, covid19DTO, randomRecipesDTO);

        return combinedDTO;
    }

    public static DadDTO singleDadFetch() throws IOException
    {

        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
        DadDTO dadDTO = gson.fromJson(dad, DadDTO.class);


        return new DadDTO(dadDTO.getId(),dadDTO.getJoke());
    }

    public static ChuckDTO singleChuckFetch() throws IOException
    {

        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        ChuckDTO chuckDTO = gson.fromJson(chuck, ChuckDTO.class);


        return new ChuckDTO(chuckDTO.getUrl(), chuckDTO.getValue());
    }



    public static CombinedDTO fetchDataSequential() throws IOException
    {

        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
        String c19 = HttpUtils.fetchData("https://covid-19-data.p.rapidapi.com/country/code?code=dk");
        String recipes = HttpUtils.fetchData("https://random-recipes.p.rapidapi.com/ai-quotes/1");

        ChuckDTO chuckDTO = gson.fromJson(chuck, ChuckDTO.class);
        DadDTO dadDTO = gson.fromJson(dad, DadDTO.class);
        Covid19DTO[] covid19DTO = gson.fromJson(c19, Covid19DTO[].class);
        RandomRecipesDTO[] randomRecipesDTO = gson.fromJson(recipes, RandomRecipesDTO[].class);

        List<RandomRecipesDTO> recipesDTOList = new ArrayList<>();
        Collections.addAll(recipesDTOList, randomRecipesDTO);

        List<Covid19DTO> covid19DTOList = new ArrayList();
        Collections.addAll(covid19DTOList, covid19DTO);


        System.out.println(covid19DTOList.size());
//        System.out.println("chuk : " + chuckDTO.getValue());
//        System.out.println("dad " + dadDTO.getJoke());
        for (Covid19DTO dto : covid19DTOList)
        {
            System.out.println("covid " + dto.getCountry());
        }

        return new CombinedDTO(chuckDTO, dadDTO, covid19DTOList, recipesDTOList);
    }


    public static String fetchData(String _url) throws MalformedURLException, IOException
    {
        URL url = new URL(_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        //con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("User-Agent", "server");
        con.setRequestProperty("X-RapidAPI-Key", "aa545bf78bmsh17d32f407714b33p1b1bd7jsne825d44fd98e");

        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if (scan.hasNext())
        {
            jsonStr = scan.nextLine();
        }
        scan.close();
        return jsonStr;
    }

}
