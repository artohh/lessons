package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Film> filmList = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rView);
        FilmAdaptor adaptor = new FilmAdaptor(MainActivity.this, filmList);
        adaptor.notifyDataSetChanged();
        recyclerView.setAdapter(adaptor);

        getMovies();
  //      filmList.add(new Film(
  //              "Геи-нигеры из далекого космоса",
 //               "Геи-нигеры устроили холокост баб и евреев",
 //               "https://avatars.mds.yandex.net/get-kinopoisk-image/1773646/882998f1-9a98-4fd3-ac0e-dedc0b7fd160/600x900"));
    }
    public void getMovies(){
        String url = "http://cinema.areas.su/movies?filter=new";
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++){
                    try {
                        JSONObject object = response.getJSONObject(i);
                        filmList.add(new Film(
                                object.getString("name"),
                                object.getString("description"),
                                "http://cinema.areas.su/up/images/" + object.getString("poster")));
                                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        queue.add(request);
    }
}