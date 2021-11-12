package jokefetcher;



import utils.HttpUtils;

import java.io.IOException;


public class JokeFetcher
{
    public static void main(String[] args) throws IOException {


        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
        String c19 = HttpUtils.fetchData("https://covid-19-data.p.rapidapi.com/country/code?code=dk");
        String recipes = HttpUtils.fetchData("https://random-recipes.p.rapidapi.com/ai-quotes/1");
        
        System.out.println("JSON fetched from chucknorris:");
        System.out.println(chuck);
        System.out.println("JSON fetched from dadjokes:");
        System.out.println(dad);
        System.out.println("JSON fetched from c19:");
        System.out.println(c19);
        System.out.println("JSON fetched from recipes:");
        System.out.println(recipes);

       
    }
}
