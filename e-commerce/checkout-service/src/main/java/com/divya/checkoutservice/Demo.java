//package com.divya.checkoutservice;

//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.Map;

//public class Demo {
//    public static void main(String[] args) {
//        String url =  "https://jsonmock.hackerrank.com/api/moviesdata/search/?Title=" + "maze";
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(url, String.class);
//        int total = 0;
//        for(String sp : result.split(",")) {
//            if(sp.contains("total")) {
//                total = Integer.parseInt(sp.split(":")[1]);
//                break;
//            }
//        }
//        System.out.println(total);
//    }
//}


//    String url =  "https://jsonmock.hackerrank.com/api/moviesdata/search/?Title=" + "maze";
//    RestTemplate restTemplate = new RestTemplate();
//    String result = restTemplate.getForObject(url, String.class);
//    int total = 0;
//        for(String sp : result.split(",")) {
//                if(sp.contains("total")) {
//                total = Integer.parseInt(sp.split(":")[1]);
//                break;
//                }
//                }
//                System.out.println(total);
//                BufferedReader br = new BufferedReader(new InputStreamReader())
//                URL url = new URL(urlString);
//                reader = new BufferedReader(new InputStreamReader(url.openStream()));
//                StringBuffer buffer = new StringBuffer();
//                int read;
//                char[] chars = new char[1024];
//                while ((read = reader.read(chars)) != -1)
//                buffer.append(chars, 0, read);
//
//                return buffer.toString();
