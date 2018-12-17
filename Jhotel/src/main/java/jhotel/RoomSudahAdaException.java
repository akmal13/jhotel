package jhotel;

/**
 * Exception RoomSudahAdaException Jika Room sudah ada pada Database
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

public class RoomSudahAdaException extends Exception {

    private Room room_error;

    public RoomSudahAdaException(Room room_input){
        super("Kamar dengan nomor Ruang : ");
        room_error = room_input;
    }

    public String getPesan(){

        return super.getMessage() + room_error.getNomorKamar() + room_error.gethotel() +"--- Sudah terdaftar ---\n";
    }
}
