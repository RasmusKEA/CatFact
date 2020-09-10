package com.example.demo.controllers;

import com.example.demo.models.CatFact;
import com.example.demo.services.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class CatController{
    CatService cs = new CatService();
    @GetMapping("/")
    @ResponseBody
    public String welcomeMsg(){
        return "Hello and welcome to this Cat Facts API service. Use the following URLS for funny cat facts: " +
                "\n /getSingle to get a single fact" +
                "\n /getTen to get ten facts" +
                "\n /getTenSortByDate to get ten facts sorted by date of creation" +
                "\n /contains?char=x&amount=n to get 1 fact if the characters you want appears n amount of times";
    }

    @GetMapping("/getSingle")
    @ResponseBody
    public String getSingle() throws IOException {
        return cs.mapCatFact();
    }

    @GetMapping("/getTen")
    @ResponseBody
    public String getTen() throws IOException {
        return cs.getTen();
    }

    @GetMapping("/getTenSortByDate")
    @ResponseBody
    public String getTenSortByDate() throws IOException {
        return cs.getSorted();
    }

    @GetMapping("/contains")
    @ResponseBody
    public String contains(@RequestParam char c, @RequestParam int amount) throws IOException {
        return cs.getParamFact(c, amount);
    }

}
