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

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
  @FXML TableView<JSONObject> table;
  @FXML TableColumn<JSONObject, String> house_id;
  @FXML TableColumn<JSONObject, String> house_name;
  @FXML TableColumn<JSONObject, String> house_category;
  @FXML TableColumn<JSONObject, String> rooms;
  @FXML TableColumn<JSONObject, String> owners;

  @FXML private BottomNavigationButton home;
  @FXML private BottomNavigationButton add;
  @FXML private BottomNavigationButton find;
  @FXML private BottomNavigationButton edit;
  @FXML private BottomNavigationButton delete;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    try {
      // TODO add exception handling here if the API is down
      HttpClient httpclient = HttpClients.createDefault();
      HttpGet httpget = new HttpGet("http://localhost:8080/v1/house/");
      HttpResponse response = httpclient.execute(httpget);
      HttpEntity entity = response.getEntity();
      String houses = EntityUtils.toString(entity);

      JSONObject obj = new JSONObject(houses);
      //This is an array full of objects.
      JSONArray arr = obj.getJSONArray("content");

      for (int i = 0; i < arr.length(); i++) {
        JSONObject house = arr.getJSONObject(i);
        JSONArray rooms_array = house.getJSONArray("rooms");
        JSONArray owners_array = house.getJSONArray("owner");

        house_id.setCellValueFactory(
            cellData -> new SimpleStringProperty(Integer.toString(house.getInt("id"))));
        house_name.setCellValueFactory(
            cellData -> new SimpleStringProperty(house.getString("name")));
        house_category.setCellValueFactory(
            cellData -> new SimpleStringProperty(house.getString("category")));

        String owner_types_constant = Methods.createOwnersList(owners_array);
        rooms.setCellValueFactory(cellData -> new SimpleStringProperty(owner_types_constant));

        String room_types_constant = Methods.createRoomsList(rooms_array);
        rooms.setCellValueFactory(cellData -> new SimpleStringProperty(room_types_constant));

        table.getItems().add(arr.getJSONObject(i));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
