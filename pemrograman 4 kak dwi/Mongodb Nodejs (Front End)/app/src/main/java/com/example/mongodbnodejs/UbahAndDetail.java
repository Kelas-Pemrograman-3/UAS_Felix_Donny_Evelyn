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

public class UbahAndDetail extends AppCompatActivity {

    EditText id, nama,password, email, alamat, nohp;
    Button btnKirim;

    private RequestQueue mRequestQueue;

    private ProgressDialog pDialog;

    Intent intent;
    String detailorupdate, _id, strid, strnama, strpassword, stremail, stralamat, strnohp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_and_detail);

        mRequestQueue = Volley.newRequestQueue(this);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        id = (EditText) findViewById(R.id.id);
        nama = (EditText) findViewById(R.id.nama);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        alamat = (EditText) findViewById(R.id.alamat);
        nohp = (EditText) findViewById(R.id.nohp);
        btnKirim = (Button) findViewById(R.id.btnKirim);

        intent = getIntent();
        detailorupdate = intent.getStringExtra("detailorupdate");
        _id         = intent.getStringExtra("_id");
        strid     = intent.getStringExtra("id");
        strnama   = intent.getStringExtra("nama");
        strpassword      = intent.getStringExtra("password");
        stremail     = intent.getStringExtra("email");
        stralamat  = intent.getStringExtra("alamat");
        strnohp     = intent.getStringExtra("nohp");

        id.setText(strid);
        nama.setText(strnama);
        password.setText(strpassword);
        email.setText(stremail);
        alamat.setText(stralamat);
        nohp.setText(strnohp);

        if(detailorupdate.equals("detail")){
            id.setEnabled(false);
            nama.setEnabled(false);
            password.setEnabled(false);
            email.setEnabled(false);
            alamat.setEnabled(false);
            nohp.setEnabled(false);
            btnKirim.setVisibility(View.GONE);
        }
        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strid = id.getText().toString();
                String strnama = nama.getText().toString();
                String strpassword = password.getText().toString();
                String stremail = email.getText().toString();
                String stralamat = alamat.getText().toString();
                String strnohp = nohp.getText().toString();
                if (strid.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Kode Matakuliah Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }else if(strnama.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Nama Matakuliah Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }else if(strpassword.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Jam Matakuliah Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }else if(stremail.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Hari Matakuliah Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }else if(stralamat.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ruang Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }else if(strnohp.isEmpty()){
                    Toast.makeText(getApplicationContext(), "No HP Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                ubahtokobaju(strid, strnama, strpassword, stremail, stralamat, strnohp);
            }
        });
    }

    private void ubahtokobaju(String id, String nama, String password, String email, String alamat, String nohp){

        // Post params to be sent to the server
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        params.put("nama", nama);
        params.put("password", password);
        params.put("email", email);
        params.put("alamat", alamat);
        params.put("nohp", nohp);

        pDialog.setMessage("Mohon tunggu");
        showDialog();
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.PUT,ConfigUrl.ubahMk + _id, new JSONObject(params),
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
                                Intent i = new Intent(UbahAndDetail.this,
                                        Listtokobaju.class);
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
        Intent i = new Intent(UbahAndDetail.this, Listtokobaju.class);
        startActivity(i);
        finish();
    }
}
