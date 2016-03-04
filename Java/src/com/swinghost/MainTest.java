package com.swinghost;

import com.h2micro.webClient.WebClient;

public class MainTest {
	
	public static void main(String[] args){
		String data = "{\"data\":\"a\"}";
		WebClient w = new WebClient(data);
		w.sendRequest("http://52.32.13.117/SwingHost/getHosts.php");
	}

}
