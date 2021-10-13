package com.example;

import org.json.JSONArray;

public class Methods {

  public static String createRoomsList(JSONArray rooms_array) {
    String room_types = null;
    for (int x = 0; x < rooms_array.length(); x++) {
      if (room_types == null) {
        room_types = rooms_array.getJSONObject(x).getString("type");
      } else {
        room_types = room_types + ", " + (rooms_array.getJSONObject(x).getString("type"));
      }
    }
    return room_types;
  }

  public static String createOwnersList(JSONArray owners_array) {
    String owner_types = null;
    for (int x = 0; x < owners_array.length(); x++) {
      if (owner_types == null) {
        owner_types = owners_array.getJSONObject(x).getString("name");
      } else {
        owner_types = owner_types + (owners_array.getJSONObject(x).getString("name"));
      }
    }
    return owner_types;
  }
}
