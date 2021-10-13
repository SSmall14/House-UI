package com.example;

import com.gluonhq.charm.glisten.control.BottomNavigationButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
  @FXML TableView<JSONObject> table;
  @FXML TableColumn<JSONObject, String> house_id;
  @FXML TableColumn<JSONObject, String> house_name;
  @FXML TableColumn<JSONObject, String> house_category;
  @FXML TableColumn<JSONObject, String> rooms;
  @FXML TableColumn<JSONObject, String> owner;

  @FXML private BottomNavigationButton home;
  @FXML private BottomNavigationButton add;
  @FXML private BottomNavigationButton find;
  @FXML private BottomNavigationButton edit;
  @FXML private BottomNavigationButton delete;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    try {

      HttpClient httpclient = HttpClients.createDefault();
      HttpGet httpget = new HttpGet("http://localhost:8080/v1/house/");
      HttpResponse response = httpclient.execute(httpget);
      HttpEntity entity = response.getEntity();
      String houses = EntityUtils.toString(entity);

      JSONObject obj = new JSONObject(houses);
      JSONArray arr = obj.getJSONArray("content");

      // This is an array full of objects.

      for (int i = 0; i < arr.length(); i++) {
          JSONObject house = arr.getJSONObject(i);

          System.out.print(arr.getJSONObject(i).getString("name"));
          System.out.print(arr.getJSONObject(i).getInt("id"));
          System.out.print(arr.getJSONObject(i).getString("category"));

        house_id.setCellValueFactory(cellData -> new SimpleStringProperty (Integer.toString(house.getInt("id"))));
        house_name.setCellValueFactory(cellData ->
                new SimpleStringProperty(house.getString("name")));
        house_category.setCellValueFactory(cellData ->
                new SimpleStringProperty(house.getString("category")));


          table.getItems().add(arr.getJSONObject(i));
      }



    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // TODO add exception handling here if the API is down
  public void populateDatabase() throws IOException {
    HttpClient httpclient = HttpClients.createDefault();
    HttpGet httpget = new HttpGet("http://localhost:8080/v1/house/");
    HttpResponse response = httpclient.execute(httpget);
    HttpEntity entity = response.getEntity();
    String houses = EntityUtils.toString(entity);
    System.out.print(houses);

    JSONObject obj = new JSONObject(houses);
    JSONArray arr = obj.getJSONArray("content"); // notice that `"posts": [...]`
    // This is an array full of objects.

    for (int i = 0; i < arr.length(); i++) {
      String id = arr.getJSONObject(i).getString("name");
      System.out.print("ID" + id);

    }

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
