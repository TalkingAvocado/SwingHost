package com.swinghost;

import org.json.JSONException;
import org.json.JSONObject;

import com.h2micro.webClient.WebClient;

public class MainTest {
	
	public static void main(String[] args){
		String data = "{\"data\":\"a\"}";
		WebClient w = new WebClient(data);
		w.sendRequest("http://52.32.13.117/SwingHost/getHosts.php");
		String response = w.getResponse();
		JSONObject j = null;
		try {
			j = new JSONObject(response);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		try{
			System.out.println(j.getString("test"));
		} catch (JSONException e){
			e.printStackTrace();
		}
		
	}

}
