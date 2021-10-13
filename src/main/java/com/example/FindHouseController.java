package com.example;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class FindHouseController {

  public void findHouse(Integer id) throws IOException {
    // TODO add exception handling here if the API is down
    HttpClient httpclient = HttpClients.createDefault();
    HttpGet httpget = new HttpGet("http://localhost:8080/v1/house/" + id);
    HttpResponse response = httpclient.execute(httpget);

    HttpEntity entity = response.getEntity();
    String house = EntityUtils.toString(entity);
  }
}
