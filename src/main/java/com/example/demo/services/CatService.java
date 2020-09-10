package com.example.demo.services;
import com.example.demo.models.CatFact;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;


public class CatService {
    public String mapCatFact() throws IOException {
        //Choose what API to consume
        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
        //Instantiate a Buffered Reader to consume the InputStream from the URL
        BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));
        //Map the data from Json to an object
        CatFact data = new Gson().fromJson(inputFromCatURL, CatFact.class);
        //Close the BufferedReader
        inputFromCatURL.close();

        return data.toString();
    }

    public String getTen() throws IOException {
        ArrayList<CatFact> catList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
            BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));
            CatFact data = new Gson().fromJson(inputFromCatURL, CatFact.class);
            catList.add(data);
            inputFromCatURL.close();
        }
        return catList.toString();
    }

    public String getSorted() throws IOException {
        ArrayList<CatFact> catList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
            BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));
            CatFact data = new Gson().fromJson(inputFromCatURL, CatFact.class);
            catList.add(data);
            inputFromCatURL.close();
        }

        Collections.sort(catList);
        return catList.toString();
    }

    public String getParamFact(char c, int n) throws IOException {
        //Choose what API to consume
        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
        //Instantiate a Buffered Reader to consume the InputStream from the URL
        BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));
        //Map the data from Json to an object
        CatFact data = new Gson().fromJson(inputFromCatURL, CatFact.class);
        //Close the BufferedReader
        inputFromCatURL.close();
        int count = 0;

        for (int i = 0; i < data.getText().length(); i++) {
            if (data.getText().charAt(i) == c) {
                count++;
            }
        }

        if(count == n){
            return data.toString();
        }


        return "Beklager, der blev ikke fundet et CatFact med " + n + " stk " + c + "'er i denne omgang. Prøv igen";
    }
}
