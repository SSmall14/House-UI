package com.example;

import com.gluonhq.charm.glisten.control.BottomNavigationButton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML private TableView<House> tableView;
    @FXML private TableColumn<House, String> house_id;
    @FXML private TableColumn<House, String>house_name;
    @FXML private TableColumn<House, String> house_category;
    @FXML private TableColumn<House, String> rooms;
    @FXML private TableColumn<House, String> owner;

    @FXML private BottomNavigationButton home;
    @FXML private BottomNavigationButton add;
    @FXML private BottomNavigationButton find;
    @FXML private BottomNavigationButton edit;
    @FXML private BottomNavigationButton delete;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        house_id.setCellValueFactory(new PropertyValueFactory<House, String>("id"));
        house_name.setCellValueFactory(new PropertyValueFactory<House, String>("name"));
        house_category.setCellValueFactory(new PropertyValueFactory<House, String>("active"));

//        tableView.getItems().setAll(parseUserList());
    }

    public void populateDatabase() throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://localhost:8080/v1/house/");
        HttpGet httpget = new HttpGet("http://localhost:8080/v1/house/");

//        // Request parameters and other properties.
//        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
//        params.add(new BasicNameValuePair("param-1", "12345"));
//        params.add(new BasicNameValuePair("param-2", "Hello!"));
//        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"))

        //Execute and get the response.
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();

        System.out.print("RETURN" + entity);

//        if (entity != null) {
//            try (InputStream instream = entity.getContent()) {
//                // do something useful
//            }
//        }



    }
//    /**
//     * Task to fetch details from JSONURL
//     * @param <V>
//     */
//
//
//    private List<House> parseUserList(){
//        // parse and construct User datamodel list by looping your ResultSet rs
//        // and return the list
//
//
//    }
}