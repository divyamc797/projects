package com.divya.jwtservice.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DriverClass {

    public static void main(String[] args) throws IOException {
        String date = "20190101";
        List<Holding> holdings = getHoldings();
        List<MarketPrice> marketPrices = getMarketPrices();

        List<Holding> holdingsForDate = holdings.stream().filter(holding -> date.equals(holding.date)).collect(Collectors.toList());
        List<MarketPrice> marketPricesForDate = marketPrices.stream().filter(marketPrice -> date.equals(marketPrice.date)).collect(Collectors.toList());


        double nav = 0.0;
        for (Holding holding : holdingsForDate) {
            MarketPrice marketPrice = marketPricesForDate.stream()
                    .filter(mp -> mp.security.equals(holding.security))
                    .findFirst().orElse(null);
            if (marketPrice != null) {
                nav += holding.quantity * marketPrice.price;
            }
        }

        System.out.println(nav);
    }

    public static List<Holding> getHoldings() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding");
            Type listType = new TypeToken<ArrayList<Holding>>() {
            }.getType();
            InputStreamReader reader = new InputStreamReader(url.openStream());
            return new Gson().fromJson(reader, listType);
        } catch (Exception ex) {
            System.out.println("Exception while parsing holdings");
        }
        return Collections.emptyList();
    }

    public static List<MarketPrice> getMarketPrices() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing");
        Type listType = new TypeToken<ArrayList<MarketPrice>>() {
        }.getType();
        InputStreamReader reader = new InputStreamReader(url.openStream());
        return new Gson().fromJson(reader, listType);
    }

    public static class Holding {
        private String date;
        private String security;
        private double quantity;
        private String portfolio;
    }

    public static class MarketPrice {
        private String date;
        private String security;
        private double price;
    }
}
