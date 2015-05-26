package com.demoapp.demo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Application {
    	static Client client;
    	static WebResource webResource;
    	static String baseuri = "http://localhost:8080/SimpleWebServiceApplication/user/1";
    	ClientResponse response;
    	String output = null;

    	
    	
    	public static void main(String[] args) {

    	    try {
    	        Client client = Client.create();

    	        WebResource webResource = client.resource(baseuri);

    	        String input = "{\"username\": \"pravin\"}";
    	        
    	        // POST method
    	        ClientResponse response = webResource.accept("application/json")
    	                .type("application/json").post(ClientResponse.class, input);

    	        // check response status code	
    	        if (response.getStatus() != 200) {
    	            throw new RuntimeException("Failed : HTTP error code : "
    	                    + response.getStatus());
    	        }

    	        // display response
    	        String output = response.getEntity(String.class);
    	        System.out.println("Output from Server .... ");
    	        System.out.println(output + "\n");
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }

    	}
}
 