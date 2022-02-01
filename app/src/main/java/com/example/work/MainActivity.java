package com.example.work;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String url_kolkata  = "https://api.weatherapi.com/v1/current.json?key=&q=Kolkata&aqi=no";
    String url_Banglore = "https://api.weatherapi.com/v1/current.json?key=&q=Bangalore&aqi=no";
    String url_Delhi = "https://api.weatherapi.com/v1/current.json?key=&q=Delhi&aqi=no";

    TextView tvd,tvb,tvk,avg;

    EditText ek,ed,eb;

//    String nameD,nameK,nameB;
    Button button;

    double ak,ad,ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        tvd = findViewById(R.id.p_Delhi);
        tvb = findViewById(R.id.p_Bangalore);
        tvk = findViewById(R.id.p_Kolkata);

        ek = findViewById(R.id.ek);
        eb = findViewById(R.id.eb);
        ed = findViewById(R.id.ed);


        button = findViewById(R.id.button);

        RequestQueue requestQueue = Volley.newRequestQueue(this);


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url_kolkata, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object = response.getJSONObject("current");
//                    Log.d("Main","good to go :------ "+object.getString("pressure_in"));
                    tvk.setText(object.getString("pressure_in"));
                    ek.setText(object.getString("pressure_in"));
//                    String nameK = ed.getText().toString();
//                    try{
//                        ak = Double.parseDouble(nameK);
//                    }catch (Exception e){
//                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Turn on Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonObjectRequest);


        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.GET, url_Banglore, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object = response.getJSONObject("current");
//                    Log.d("Main","good to go :------ "+object.getString("pressure_in"));
                    tvb.setText(object.getString("pressure_in"));
                    eb.setText(object.getString("pressure_in"));
//                    String nameB = ed.getText().toString();
//                    try{
//                        ab = Double.parseDouble(nameB);
//                    }catch (Exception e){
//                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Turn on Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonObjectRequest1);

        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.GET, url_Delhi, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object = response.getJSONObject("current");
//                    Log.d("Main","good to go :------ "+object.getString("pressure_in"));
                    tvd.setText(object.getString("pressure_in"));
                    ed.setText(object.getString("pressure_in"));
//                    String nameD = ed.getText().toString();
//                    try{
//                        ad = Double.parseDouble(nameD);
//                    }catch (Exception e){
//                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Turn on Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonObjectRequest2);


//        Toast.makeText(MainActivity.this, "value is "+ak, Toast.LENGTH_LONG).show();

        avg = findViewById(R.id.average);
//        double avg1 = (ak+ad+ab)/3;

        //Toast.makeText(MainActivity.this, "Average is "+avg1, Toast.LENGTH_LONG).show();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ek.getText().toString();
                float kol = (float) Double.parseDouble(name);
                String name2 = eb.getText().toString();
                float ban = (float) Double.parseDouble(name2);
                String name3 = ed.getText().toString();
                float del = (float) Double.parseDouble(name3);
                float avg1 = (kol+ban+del)/3;
                avg.setText(""+avg1);
                Toast.makeText(MainActivity.this, "Average is :"+avg1, Toast.LENGTH_SHORT).show();
            }
        });


    }

}