package com.example;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class DeleteController {
    public void deleteHouse(Integer id) throws IOException {
        // TODO add exception handling here if the API is down
        HttpClient httpclient = HttpClients.createDefault();
        HttpDelete httpdelete = new HttpDelete("http://localhost:8080/v1/house/" + id);
        HttpResponse response = httpclient.execute(httpdelete);

        HttpEntity entity = response.getEntity();
    }
}
