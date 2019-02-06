package com.todo.webApplication.todo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.internal.support.FileReader;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class BusinessLogicOfStepDefinition {

	public void RetriveUsers() throws URISyntaxException {
		URI uri = new URI("http://localhost:9090/users");
		Response response = RestAssured.when().get(uri);
		int responseCode = response.getStatusCode();
		if(responseCode==200) {
			String listofUser =  response.getBody().asString();
			System.out.println(listofUser);
		}
	}
	
	public void CreateUser() throws URISyntaxException, ParseException, FileNotFoundException, IOException {
		RestAssured.baseURI= "http://localhost:9090/users";
		RequestSpecification request = RestAssured.given();
		request.headers("Content-Type","application/json");
		JSONObject requestParams = JSONReaderAndParsor("/newUser.json");
		request.body(requestParams);
		Response response = request.post();
		int responseCode = response.getStatusCode();
		if(responseCode == 201) {
			System.out.println("user created successfully");
		}
	}
	
	public JSONObject JSONReaderAndParsor(String filename) throws ParseException, FileNotFoundException, IOException {
		JSONParser parsor = new JSONParser();
		String filePath = this.getClass().getResource(filename).getPath();
		StringBuilder sb = new StringBuilder(filePath);
		sb.deleteCharAt(0);
	    JSONObject obj= (JSONObject) parsor.parse(new InputStreamReader(new FileInputStream(sb.toString())));
		return obj;		
	}
	
	
}
