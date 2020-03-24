package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    final static String WARNING = "VOLLEYERROR";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter mAdapter;
    RecyclerView rvPokemon;
    StarwarsAdapter adapter;
    GridLayoutManager mLayoutManager;


    private RequestQueue mRequestQueue;


    ArrayList<FilmsModel> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                mLayoutManager = new GridLayoutManager(this,1);
            }else{
                mLayoutManager = new GridLayoutManager(this,3);
            }
            recyclerView.setLayoutManager(mLayoutManager);
            sendRequest();


    }
    public final static String LIST_STATE_KEY = "recycler_list_state";
    Parcelable listState;

    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        // Save list state
        listState = mLayoutManager.onSaveInstanceState();
        state.putParcelable(LIST_STATE_KEY, listState);
    }

    protected void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
        // Retrieve list state and list/item positions
        if(state != null)
            listState = state.getParcelable(LIST_STATE_KEY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (listState != null) {
            mLayoutManager.onRestoreInstanceState(listState);
        }
    }


    private void sendRequest(){
        VolleyLog.DEBUG = true;

        StringRequest stringRequest = new StringRequest("https://swapi.co/api/films/",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        final ArrayList<FilmsModel> filmsList = new ArrayList<FilmsModel>();
                        JSONObject jsonObj = null;
                        try {
                            jsonObj = new JSONObject(response);
                            JSONArray results = jsonObj.getJSONArray("results");
                            for (int i = 0; i< results.length();i++){
                                final JSONObject n = results.getJSONObject(i);
                                Log.d("TITLE: ", n.getString("title"));
                                filmsList.add(new FilmsModel(n.getString("title"), n.getString("episode_id"), n.getString("director"), n.getString("producer"), n.getString("release_date"), n.getString("opening_crawl")));
                            }
                            Log.d("FINISHED +++++++++++++++++++++++ ", String.valueOf(filmsList.get(0).title));
                            mAdapter = new StarwarsAdapter(filmsList);
                            recyclerView.setAdapter(mAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}
