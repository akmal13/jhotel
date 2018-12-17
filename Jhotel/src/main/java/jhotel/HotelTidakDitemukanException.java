package jhotel;

/**
 * Exception HotelTidakDitemukanException Jika Hotel tidak ada ketika remove Hotel
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

public class HotelTidakDitemukanException extends Exception {

    private int hotel_error;

    public HotelTidakDitemukanException(int hotel_input){
        super("Hotel dengan ID : ");
        hotel_error = hotel_input;
    }

    public String getPesan(){

        return super.getMessage()+ hotel_error +"\n--- Tidak ditemukan ---\n";

    }

}
