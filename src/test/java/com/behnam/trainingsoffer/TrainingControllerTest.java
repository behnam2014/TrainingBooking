package com.behnam.trainingsoffer;

import org.junit.Test;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.*;
import java.io.IOException;

public class TrainingControllerTest {
	
	@Test
	public void RESTAPI_getEvaluation_url_listofall() throws ClientProtocolException, IOException, JSONException {

		// Given
		HttpUriRequest request = new HttpGet("http://localhost:8080/api/training/1");

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		HttpEntity entity = httpResponse.getEntity();
		String json = EntityUtils.toString(entity);
		JSONObject evaluation = new JSONObject(json);

		// Then
		// check price
		String expectedvalue = "750";
		assertEquals(expectedvalue, evaluation.get("price"));
		System.out.print(evaluation);

	}
}






