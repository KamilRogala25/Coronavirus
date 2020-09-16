package com.example.Coronavirus;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Coronavirus {

    public double getActiveCases() {
        try {
            Document document = Jsoup.connect(
                    "https://www.worldometers.info/coronavirus/country/poland/").get();
            String text = document.getElementsByClass(
                    "number-table-main").first().text();
            return Double.parseDouble(text.replace(",","."));
        } catch (IOException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        Coronavirus coronavirus = new Coronavirus();
        coronavirus.getActiveCases();
    }

}
