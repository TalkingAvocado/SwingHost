package com.h2micro.webClient;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Hirsh Agarwal on 2/17/2016.
 */
public class WebClient{

    //Fields
    String data;
    private String returnData;

    public WebClient(String dataList){
        data = dataList;
    }


    public String sendRequest(String urlIn) {
        StringBuffer response = new StringBuffer();
        try {
            String url = urlIn;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //add request header
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("charset", "utf-8");
            con.setUseCaches (false);

            String urlParameters = "data=test";

            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(data);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
//            System.out.println("\nSending 'POST' request to URL : " + url);
//            System.out.println("Post parameters : " + urlParameters);
//            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
        } catch (Exception e){
            e.printStackTrace();
        }
//        System.out.println("RESPONSE --------------------------" +response.toString());
        returnData = response.toString();
        return response.toString();
    }

    public String getResponse(){
        return returnData;
    }
}
