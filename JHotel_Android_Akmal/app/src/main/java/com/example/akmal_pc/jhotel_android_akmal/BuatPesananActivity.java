package com.example.akmal_pc.jhotel_android_akmal;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class BuatPesananActivity extends AppCompatActivity {
    TextView room_number;
    TextView tariff;
    TextView total;
    EditText durasi;
    Button hitung;
    Button pesan;

    private int id_customer;
    private int id_hotel;
    private double dailyTariff;
    private String nomorKamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_pesanan);

        id_customer = getIntent().getIntExtra("id_customer", 0);
        id_hotel = getIntent().getIntExtra("id_hotel", 0);
        dailyTariff = getIntent().getDoubleExtra("tariff", 0);
        nomorKamar = getIntent().getStringExtra("nomor_kamar");

        room_number = findViewById(R.id.room_number);
        tariff = findViewById(R.id.tariff);
        total = findViewById(R.id.total_biaya);
        durasi = findViewById(R.id.durasi_hari);
        hitung = findViewById(R.id.hitung);
        pesan = findViewById(R.id.pesan);

        room_number.setText(nomorKamar);
        tariff.setText(Formatter.toCurrency(dailyTariff));
        total.setText("0");

        pesan.setVisibility(View.INVISIBLE);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!durasi.getText().toString().equals(""))
                {
                    total.setText(Formatter.toCurrency(dailyTariff*Integer.parseInt(durasi.getText().toString())));
                }
                hitung.setVisibility(View.INVISIBLE);
                pesan.setVisibility(View.VISIBLE);
            }
        });

        pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String> () {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            if(jsonResponse!=null) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(BuatPesananActivity.this);
                                builder.setMessage("Book Success.")
                                        .create()
                                        .show();
                                        
								Intent i = new Intent(BuatPesananActivity.this, MainActivity.class);
								i.putExtra("id", id_customer);
								startActivity(i);
                            }
                        } catch (JSONException e) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(BuatPesananActivity.this);
                            builder.setMessage("Book Failed.")
                                    .create()
                                    .show();
                        }
                    }
                };

                BuatPesananRequest buatPesananRequest = new BuatPesananRequest(Integer.parseInt(durasi.getText().toString()), id_customer, id_hotel, nomorKamar, responseListener);
                RequestQueue queue = Volley.newRequestQueue(BuatPesananActivity.this);
                queue.add(buatPesananRequest);
            }
        });
    }
}

class BuatPesananRequest extends StringRequest
{
    private Map<String, String> params;

    public BuatPesananRequest(int jumlah_hari, int id_customer, int id_hotel, String nomor_kamar, Response.Listener<String> listener) {
        super(Method.POST, API.bookURL, listener, null);
        params = new HashMap<>();
        params.put("hari", Integer.toString(jumlah_hari));
        params.put("idcustomer", Integer.toString(id_customer));
        params.put("idhotel", Integer.toString(id_hotel));
        params.put("nomorkamar", nomor_kamar);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
