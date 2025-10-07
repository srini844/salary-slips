package com.framework.restassured.api.testcase;

import java.util.HashMap;
import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;
import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class PassWordEncryption {

	@Test	
	public void encryption() {
		
		String password = "Athithi@2025";
	
		 Response res = RestAssured.
					given()
					.contentType("application/x-www-form-urlencoded")
					.formParam("pass2encyrpt",password)
							.when()
								.post("https://accsm-user-access-token-service.app.singdev1.paas.fedex.com/encryptpassword");
		 
		 	System.out.println(res.asPrettyString());
		 	String valRes = res.jsonPath().get("accessToken").toString();
		 	System.out.println("Value of access token is : "+valRes);
	}

}
