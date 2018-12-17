package com.example.akmal_pc.jhotel_android_akmal;

public interface API {
    String base = "http://10.0.2.2:8080/";
    String loginURL = base+"logincust";
    String registerURL = base+"newcustomer";
    String bookURL = base+"bookpesanan";
    String vacantRoomsURL = base+"/vacantrooms/";
    String fetchPesananURL = base+"/pesanancustomer/";
    String finishPesananURL = base+"finishpesanan";
    String cancelPesananURL = base+"cancelpesanan";
}
