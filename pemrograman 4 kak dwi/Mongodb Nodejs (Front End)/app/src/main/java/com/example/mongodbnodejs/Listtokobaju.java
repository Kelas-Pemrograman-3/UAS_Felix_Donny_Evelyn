package com.example.mongodbnodejs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import adapter.Adaptertokobaju;
import model.tokobajuModel;
import server.ConfigUrl;

public class Listtokobaju extends AppCompatActivity {

    ProgressDialog pDialog;

    Adaptertokobaju adapter;
    ListView list;

    ArrayList<tokobajuModel> newsList = new ArrayList<tokobajuModel>();

    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tokobaju);

        mRequestQueue = Volley.newRequestQueue(this);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        list = (ListView) findViewById(R.id.array_list);
        newsList.clear();
        adapter = new Adaptertokobaju(Listtokobaju.this, newsList, mRequestQueue, pDialog);
        list.setAdapter(adapter);
        getAllData();
    }

    private void getAllData() {
        // Pass second argument as "null" for GET requests
        pDialog.setMessage("Loading");
        showDialog();
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, ConfigUrl.getMk, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        hideDialog();
                        try {
                            boolean status = response.getBoolean("error");
                            if (status == false) {
                                String data = response.getString("data");
                                JSONArray jsonArray = new JSONArray(data);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    tokobajuModel tokobaju = new tokobajuModel();
                                    tokobaju.set_id(jsonObject.getString("_id"));
                                    tokobaju.setId(jsonObject.getString("id"));
                                    tokobaju.setNama(jsonObject.getString("nama"));
                                    tokobaju.setPassword(jsonObject.getString("password"));
                                    tokobaju.setEmail(jsonObject.getString("email"));
                                    tokobaju.setAlamat(jsonObject.getString("alamat"));
                                    tokobaju.setNohp(jsonObject.getString("nohp"));
                                    newsList.add(tokobaju);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
                hideDialog();
            }
        });

        /* Add your Requests to the RequestQueue to execute */
        mRequestQueue.add(req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }


    @Override
    public void onBackPressed(){
        Intent i = new Intent(Listtokobaju.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
