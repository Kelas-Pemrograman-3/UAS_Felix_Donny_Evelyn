package com.example.mongodbnodejs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.circularreveal.cardview.CircularRevealCardView;

import session.SessionManager;

public class MainActivity extends AppCompatActivity {

    private SessionManager session;

    private CircularRevealCardView cardKeluar, cardTambahData, cardLihatData , cardLihatDataT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(this);

        cardKeluar = (CircularRevealCardView)
                findViewById(R.id.cardKeluar);
//        cardTambahData = (CircularRevealCardView)
//                findViewById(R.id.cardTambahData);
        cardLihatData = (CircularRevealCardView)
                findViewById(R.id.cardLihatData);
        cardLihatDataT = (CircularRevealCardView)
                findViewById(R.id.cardLihatDataT);


//        cardTambahData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent a = new Intent(MainActivity.this, Inputtokobaju.class);
//                startActivity(a);
//                finish();
//            }
//        });

        cardLihatData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Listtokobaju.class);
                startActivity(a);
                finish();
            }
        });

        cardLihatDataT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Listtransaksi.class);
                startActivity(a);
                finish();
            }
        });


        cardKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setLogin(false);
                session.setSkip(false);
                session.setSessid(0);
                Intent i = new Intent(MainActivity.this,
                        LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

//    private void fetchJsonResponse() {
//        // Pass second argument as "null" for GET requests
//        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, ConfigUrl.getAllMhs, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            String result = response.getString("data");
//                            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
//
//                            JSONArray res = new JSONArray(result);
//                            for (int i = 0; i < res.length(); i++){
//                                JSONObject jObj = res.getJSONObject(i);
//                                txtData.append("Npm  = " + jObj.getString("npm") + "\n"+
//                                               "Nama = " + jObj.getString("nama") + "\n\n");
//                            }
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.e("Error: ", error.getMessage());
//            }
//        });
//
//        /* Add your Requests to the RequestQueue to execute */
//        mRequestQueue.add(req);
//    }
}
