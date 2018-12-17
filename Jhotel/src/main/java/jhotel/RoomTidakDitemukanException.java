package jhotel;

/**
 * Exception RoomTidakDitemukanException Jika Room tidak ada pada saat remove Room
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

public class RoomTidakDitemukanException extends Exception {
    private Hotel hotel_error;
    private String room_error;

    public RoomTidakDitemukanException(Hotel hotel_input,String room_input){
        super("Kamar yang terletak di : ");
        hotel_error = hotel_input;
        room_error = room_input;
    }
    public String getPesan(){

        return super.getMessage() + hotel_error + "Dan dengan nomor kamar : " + room_error + "\n--- Tidak ditemukan ---\n";
    }
}
