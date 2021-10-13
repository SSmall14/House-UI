package com.example;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class EditController {
    public void editHouse(Integer id) throws IOException {
        // TODO add exception handling here if the API is down
        HttpClient httpclient = HttpClients.createDefault();
        HttpPut httpput = new HttpPut("http://localhost:8080/v1/house/" + id);
        HttpResponse response = httpclient.execute(httpput);

        HttpEntity entity = response.getEntity();
    }
}
