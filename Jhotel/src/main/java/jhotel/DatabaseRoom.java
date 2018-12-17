package jhotel;

/**
 *  DatabaseRoom database dari ruangan yang tersedia
 *
 * @author  Akmal
 * @version 1.8
 * @since 31-5-18
 */

import java.util.*;
public class DatabaseRoom
{
    private static ArrayList<Room> ROOM_DATABASE = new ArrayList<Room> ();

    /**
     * getRoomDatabase Method untuk mengambil database room
     *
     * @return Arraylist<Room> Database untuk menyimpan list room
     */
    public static ArrayList<Room> getRoomDatabase(){
        return ROOM_DATABASE;
    }

    /**
     * addRoom Menambah Room kepada Database room
     *
     * @param baru memasukkan room baru sebagai entry database
     * @return boolean Menyatakan status penambahan database
     * @throws RoomSudahAdaException Exception jika sudah terdapat Room
     */
    
    public static boolean addRoom(Room baru) throws RoomSudahAdaException{
        if(baru.gethotel() != null){
            int i;
            int w = 0;
            for(i=0;i<ROOM_DATABASE.size();i++){
                if(ROOM_DATABASE.get(i).getNomorKamar().equals(baru.getNomorKamar())){
                    w++;
                }
            }
            if(w == 0){
            ROOM_DATABASE.add(baru);
            return true;
            }
        }
        throw new RoomSudahAdaException(baru);

    }

    /**
     * getRoom mengambil room dari databes
     *
     * @param hotel Hotel dari room
     * @param nomor_kamar nomor kamar Room dari hotel tersebut
     * @return Room yang ditemukan pada database
     */

    public static Room getRoom(Hotel hotel,String nomor_kamar){
        int i;
        int w = 0;
        for(i=0;i<ROOM_DATABASE.size();i++){
            if(ROOM_DATABASE.get(i).getNomorKamar().equals(nomor_kamar)){
                    return ROOM_DATABASE.get(i);
             }
         }
        return null;
    }

    /**
     * getRoomFromHotel mengambil seluruh Room dari Hotel yang menjadi input
     *
     * @param hotel hotel yang menjadi input untuk arraylist
     * @return Arraylist<Room> Daftar Room pada hotel tersebut
     */

    public static ArrayList<Room> getRoomFromHotel(Hotel hotel){
        ArrayList<Room> listhotel = new ArrayList<Room>(); 
        int i;
        int w = 0;
        for(i=0;i<ROOM_DATABASE.size();i++){
            if(ROOM_DATABASE.get(i).gethotel().equals(hotel)){
                    listhotel.add(ROOM_DATABASE.get(i));
             }
         }
         return listhotel;
    }

    /**
     * getVacantRooms Vacant room yang terdapat pada sekuruh database
     *
     * @return ArrayList<Room> Daftar Room Vacant dari Database
     */

    public static ArrayList<Room> getVacantRooms(){
       ArrayList<Room> list_vacant = new ArrayList<Room>(); 
        int i;
        for(i=0;i<ROOM_DATABASE.size();i++){
            if(ROOM_DATABASE.get(i).getStatusKamar().equals(StatusKamar.Vacant)){
                    list_vacant.add(ROOM_DATABASE.get(i));
             }
         }
        return list_vacant;
    }

    /**
     * removeRoom Menghapus Room dari Database
     *
     * @param hotel Hotel yang merupakan bagian dari room tesebut
     * @param nomor_kamar nomor kamar dari room yang dihapus
     * @return boolean Status apakah Room telah dihapus
     * @throws RoomTidakDitemukanException Exception jika Room tidak ditemukan
     */
    
    public static boolean removeRoom(Hotel hotel,String nomor_kamar)throws RoomTidakDitemukanException{
        int i;
        Administrasi a = new Administrasi();
        for(i=0;i<ROOM_DATABASE.size();i++){
            if(ROOM_DATABASE.get(i).getNomorKamar().equals(nomor_kamar)){
                    a.pesananDibatalkan(ROOM_DATABASE.get(i));
                    ROOM_DATABASE.remove(i);
                    return true;
             }
         }
         throw new RoomTidakDitemukanException(hotel,nomor_kamar);

    }
 
}
