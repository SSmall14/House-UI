package com.example;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddController {
    public void findHouse(Integer id) throws IOException {
        // TODO add exception handling here if the API is down
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://localhost:8080/v1/house/");

        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
//        params.add(new BasicNameValuePair("house", "12345"));
//        params.add(new BasicNameValuePair("param-2", "Hello!"));
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        HttpResponse response = httpclient.execute(httppost);

        HttpEntity entity = response.getEntity();
    }
}
