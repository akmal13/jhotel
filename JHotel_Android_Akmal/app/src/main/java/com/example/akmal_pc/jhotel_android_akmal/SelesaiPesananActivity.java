package com.example.akmal_pc.jhotel_android_akmal;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SelesaiPesananActivity extends AppCompatActivity {
    private int currentUserId;
    private int id_pesanan;

    TextView    tvPesananId;
    TextView    tvJumlahHari;
    TextView    tvBiaya;
    TextView    tvTanggalPesan;
    Button      selesaikan;
    Button      batalkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selesai_pesanan);
        currentUserId = getIntent().getIntExtra("id", 0);

        tvPesananId = findViewById(R.id.pesananId);
        tvJumlahHari = findViewById(R.id.jumlahhari);
        tvBiaya= findViewById(R.id.biaya);
        tvTanggalPesan = findViewById(R.id.tanggalPesan);
        selesaikan = findViewById(R.id.selesaiBtn);
        batalkan = findViewById(R.id.cancelBtn);

        fetchPesanan();

        selesaikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String> () {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            if(jsonResponse!=null) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SelesaiPesananActivity.this);
                                builder.setMessage("Order Finished.")
                                        .create()
                                        .show();

                                Intent i = new Intent(SelesaiPesananActivity.this, MainActivity.class);
								i.putExtra("id", currentUserId);
								startActivity(i);
                            }
                        } catch (JSONException e) {
                        }
                    }
                };

                PesananSelesaiRequest pesananSelesaiRequest = new PesananSelesaiRequest(id_pesanan, responseListener);
                RequestQueue queue = Volley.newRequestQueue(SelesaiPesananActivity.this);
                queue.add(pesananSelesaiRequest);
            }
        });

        batalkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String> () {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            if(jsonResponse!=null) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SelesaiPesananActivity.this);
                                builder.setMessage("Order Canceled.")
                                        .create()
                                        .show();
                                        
								Intent i = new Intent(SelesaiPesananActivity.this, MainActivity.class);
								i.putExtra("id", currentUserId);
								startActivity(i);
                            }
                        } catch (JSONException e) {
                        }
                    }
                };

                PesananBatalRequest pesananBatalRequest= new PesananBatalRequest(id_pesanan, responseListener);
                RequestQueue queue = Volley.newRequestQueue(SelesaiPesananActivity.this);
                queue.add(pesananBatalRequest);
            }
        });
    }

    void fetchPesanan()
    {
        Response.Listener<String> responseListener = new Response.Listener<String> () {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonResponse = new JSONObject(response);
                    if(jsonResponse!=null) {
                        id_pesanan = jsonResponse.getInt("id");
                        tvPesananId.setText(Integer.toString(id_pesanan));
                        tvJumlahHari.setText(Integer.toString(jsonResponse.getInt("jumlahHari")));
                        tvBiaya.setText(Formatter.toCurrency(jsonResponse.getDouble("biaya")));
                        tvTanggalPesan.setText(Formatter.toDate(jsonResponse.getString("tanggalPesan")));
                    }
                } catch (JSONException e) {
					Intent i = new Intent(SelesaiPesananActivity.this, MainActivity.class);
					i.putExtra("id", currentUserId);
					startActivity(i);
                }
            }
        };

        PesananFetchRequest pesananFetchRequest = new PesananFetchRequest(currentUserId, responseListener);
        RequestQueue queue = Volley.newRequestQueue(SelesaiPesananActivity.this);
        queue.add(pesananFetchRequest);
    }
}

class PesananFetchRequest extends StringRequest
{
    public PesananFetchRequest(int id, Response.Listener<String> listener) {
        super(Request.Method.GET, API.fetchPesananURL+Integer.toString(id), listener, null);
    }
}

class PesananSelesaiRequest extends StringRequest
{
    private Map<String, String> params;

    public PesananSelesaiRequest(int id,  Response.Listener<String> listener) {
        super(Method.POST, API.finishPesananURL, listener, null);
        params = new HashMap<>();
        params.put("id", Integer.toString(id));
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

class PesananBatalRequest extends StringRequest
{
    private Map<String, String> params;

    public PesananBatalRequest(int id,  Response.Listener<String> listener) {
        super(Method.POST, API.cancelPesananURL, listener, null);
        params = new HashMap<>();
        params.put("id", Integer.toString(id));
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
