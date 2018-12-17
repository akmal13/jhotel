package com.example.akmal_pc.jhotel_android_akmal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Hotel> listHotel = new ArrayList<>();
    private ArrayList<Room> listRoom = new ArrayList<>();
    private HashMap<Hotel, ArrayList<Room>> childMapping = new HashMap<>();
    private int currentUserId;
    ExpandableListView expandableListView;
    Button pesananBtn;
    MenuListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentUserId = getIntent().getIntExtra("id", 0);

        expandableListView = (ExpandableListView) findViewById(R.id.lvExp);
        pesananBtn = findViewById(R.id.pesananBtn);

        refreshList();

        pesananBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SelesaiPesananActivity.class);
                i.putExtra("id", currentUserId);
                startActivity(i);
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Room selected = childMapping.get(listHotel.get(groupPosition)).get(childPosition);
                Intent i = new Intent(MainActivity.this, BuatPesananActivity.class);
                i.putExtra("id_customer", currentUserId);
                i.putExtra("nomor_kamar", selected.getRoomNumber());
                i.putExtra("tariff", selected.getDailyTariff());
                i.putExtra("id_hotel", listHotel.get(groupPosition).getId());
                startActivity(i);
                return false;
            }
        });
    }

    void refreshList()
    {
        Response.Listener<String> responseListener = new Response.Listener<String> () {
            @Override
            public void onResponse(String response) {
                try{
                    JSONArray jsonResponse = new JSONArray(response);
                    if(jsonResponse!=null) {
                        JSONObject hotel = jsonResponse.getJSONObject(0).getJSONObject("hotel");
                        JSONObject lokasi = hotel.getJSONObject("lokasi");
                        Lokasi newLokasi = new Lokasi(
                                lokasi.getDouble("x"),
                                lokasi.getDouble("y"),
                                lokasi.getString("deskripsi")
                        );
                        Hotel newHotel = new Hotel(
                                hotel.getInt("id"),
                                hotel.getString("nama"),
                                newLokasi,
                                hotel.getInt("bintang")
                        );
                        listHotel.add(newHotel);
                        for (int i = 0 ; i< jsonResponse.length(); i++)
                        {
                            JSONObject room = jsonResponse.getJSONObject(i);
                            Room newRoom = new Room(
                                    room.getString("nomorKamar"),
                                    room.getString("statusKamar"),
                                    room.getDouble("dailyTariff"),
                                    room.getString("tipeKamar")
                            );
                            listRoom.add(newRoom);
                        }

                        childMapping.put(listHotel.get(0), listRoom);

                        listAdapter = new MenuListAdapter(MainActivity.this, listHotel, childMapping);
                        expandableListView.setAdapter(listAdapter);
                    }
                } catch (JSONException e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Load Data Failed.")
                            .create()
                            .show();
                }
            }
        };

        MenuRequest menuRequest = new MenuRequest(responseListener);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(menuRequest);
    }
}

class MenuRequest extends StringRequest
{
    public MenuRequest(Response.Listener<String> listener) {
        super(Request.Method.GET, API.vacantRoomsURL, listener, null);
    }
}

class MenuListAdapter extends BaseExpandableListAdapter
{
    private Context _context;
    private ArrayList<Hotel> _listDataHeader;
    private HashMap<Hotel, ArrayList<Room>> _listDataChild;

    public MenuListAdapter(Context context, ArrayList<Hotel> listDataHeader,
                           HashMap<Hotel, ArrayList<Room>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final Room childText = (Room) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.layout_room, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.child);

        String s = childText.getRoomNumber() +" "+childText.getTipeKamar();
        txtListChild.setText(s);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        Hotel headerTitle = (Hotel) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.layout_hotel, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.groupHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle.getNama());

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}