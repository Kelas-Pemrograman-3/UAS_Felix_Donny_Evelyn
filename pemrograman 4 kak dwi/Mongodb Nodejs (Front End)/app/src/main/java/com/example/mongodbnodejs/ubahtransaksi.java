package com.example.mongodbnodejs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import server.ConfigUrl;

public class ubahtransaksi extends AppCompatActivity {

    EditText ukuran, warna,jumlah;
    Button btnKirim;

    private RequestQueue mRequestQueue;

    private ProgressDialog pDialog;

    Intent intent;
    String detailorupdate, _id, strukuran, strwarna, strjumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubahtransaksi);

        mRequestQueue = Volley.newRequestQueue(this);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        ukuran = (EditText) findViewById(R.id.ukuran);
        warna = (EditText) findViewById(R.id.warna);
        jumlah = (EditText) findViewById(R.id.jumlah);
        btnKirim = (Button) findViewById(R.id.btnKirim);

        intent = getIntent();
        detailorupdate = intent.getStringExtra("detailorupdate");
        _id         = intent.getStringExtra("_id");
        strukuran     = intent.getStringExtra("ukuran");
        strwarna   = intent.getStringExtra("warna");
        strjumlah      = intent.getStringExtra("jumlah");

        ukuran.setText(strukuran);
        warna.setText(strwarna);
        jumlah.setText(strjumlah);

        if(detailorupdate.equals("detail")){
            ukuran.setEnabled(false);
            warna.setEnabled(false);
            jumlah.setEnabled(false);
            btnKirim.setVisibility(View.GONE);
        }
        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strukuran = ukuran.getText().toString();
                String strwarna = warna.getText().toString();
                String strjumlah = jumlah.getText().toString();
                if (strukuran.isEmpty()){
                    Toast.makeText(getApplicationContext(), "ukuran Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }else if(strwarna.isEmpty()){
                    Toast.makeText(getApplicationContext(), "warna Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }else if(strjumlah.isEmpty()){
                    Toast.makeText(getApplicationContext(), "jumlah Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                ubahtransaksi(strukuran, strwarna, strjumlah);
            }
        });
    }

    private void ubahtransaksi(String ukuran, String warna, String jumlah){

        // Post params to be sent to the server
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("ukuran", ukuran);
        params.put("warna", warna);
        params.put("jumlah", jumlah);

        pDialog.setMessage("Mohon tunggu");
        showDialog();
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.PUT,ConfigUrl.ubahT + _id, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        hideDialog();
                        try {
                            boolean status = response.getBoolean("error");
                            String msg;
                            if(status == true){
                                msg = response.getString("pesan");
                            }else {
                                msg = response.getString("pesan");
                                Intent i = new Intent(ubahtransaksi.this,
                                        Listtransaksi.class);
                                startActivity(i);
                                finish();
                            }
                            Toast.makeText(getApplicationContext(), msg,
                                    Toast.LENGTH_LONG).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
                hideDialog();
            }
        });

        // add the request object to the queue to be executed
        // ApplicationController.getInstance().addToRequestQueue(req);
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
    public void onBackPressed() {
        Intent i = new Intent(ubahtransaksi.this, Listtransaksi.class);
        startActivity(i);
        finish();
    }
}
