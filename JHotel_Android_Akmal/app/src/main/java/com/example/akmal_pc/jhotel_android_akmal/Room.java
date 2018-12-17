package com.example.akmal_pc.jhotel_android_akmal;

public class Room
{
    private String roomNumber;
    private String statusKamar;
    private double dailyTariff;
    private  String tipeKamar;

    public Room(String roomNumber, String statusKamar, double dailyTariff,String tipeKamar)
    {
        this.dailyTariff = dailyTariff;
        this.roomNumber = roomNumber;
        this.statusKamar = statusKamar;
        this.tipeKamar = tipeKamar;
    }

    public double getDailyTariff() {
        return dailyTariff;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getStatusKamar() {
        return statusKamar;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public void setDailyTariff(double dailyTariff) {
        this.dailyTariff = dailyTariff;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setStatusKamar(String statusKamar) {
        this.statusKamar = statusKamar;
    }

    public void setTipeKamar(String tipeKamar) {
        this.tipeKamar = tipeKamar;
    }
}
