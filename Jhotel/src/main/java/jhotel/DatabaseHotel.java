package jhotel;
/**
 * Class Databasehotel merupakan database yang menyimpan hotel.
 *
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */
import java.util.*;
public class DatabaseHotel
{
   private static ArrayList<Hotel> HOTEL_DATABASE = new ArrayList<Hotel> ();
   private static int LAST_HOTEL_ID = 0;

    /**
     * getHotelDatabase memberi database hotel
     *
     * @return ArrayList<Hotel> Return Database Hotel
     */
   
   public static ArrayList<Hotel> getHotelDatabase(){
      return HOTEL_DATABASE;
   }

    /**
     * getLastHotelID memberi id terakhir dari database hotel
     *
     * @return int id hotel terakhir
     */
   public static int getLastHotelID(){
    return LAST_HOTEL_ID;
   }

    /**
     * addHotel menambah database hotel
     *
     * @param baru hotel baru yang akan ditambahkan
     * @return boolean status penambahan database
     * @throws HotelSudahAdaException jika hotel sudah ada di database
     */

   public static boolean addHotel(Hotel baru) throws HotelSudahAdaException{
       int besar = HOTEL_DATABASE.size();
       int i= 0;
       int w= 0;
       
       for(i=0;i<besar;i++){
           
               if(HOTEL_DATABASE.get(i).getID() == (baru.getID()) || HOTEL_DATABASE.get(i).getLokasi().equals(baru.getLokasi())){
                   w++;
                }
        }
       if (w>0){

           throw new HotelSudahAdaException(baru);
        }
       else{
           LAST_HOTEL_ID = baru.getID();
           HOTEL_DATABASE.add(baru);
       return true ;
      }
    }

    /**
     * getHotel untuk mengambil hotel berdasakan id hotel
     *
     * @param id id hotel yang akan diambil
     * @return Hotel mengembalikan hotel yang telah ditemukan berdasarkan ID
     */
    
   public static Hotel getHotel(int id){
       int besar = HOTEL_DATABASE.size();
       int i= 0;
       int w= 0;
       
       for(i=0;i<besar;i++){
           if(HOTEL_DATABASE.get(i).getID() == id){
               return HOTEL_DATABASE.get(i);
            }
        }
        return null;
   }

    /**
     * removeHotel Menremove hotel sesuai dengan id input
     *
     * @param id id dari hotel yang ingin diremove
     * @return boolean Status dari remove hotel
     * @throws HotelTidakDitemukanException Exception jika tidak ditemukan Hotel pada database
     */
    
   public static boolean removeHotel(int id)throws HotelTidakDitemukanException{
       DatabaseRoom dr = new DatabaseRoom();
       int besar = HOTEL_DATABASE.size();
       int i= 0;
       int w= 0;
       int bdathot = dr.getRoomFromHotel(getHotel(id)).size();
       for(i=0;i<besar;i++){
           if(HOTEL_DATABASE.get(i).getID() == id){
              for(w=0;w<bdathot;w++){
                try {
                    dr.removeRoom(HOTEL_DATABASE.get(i), dr.getRoomFromHotel(getHotel(id)).get(w).getNomorKamar());
                    return true;
                }catch(RoomTidakDitemukanException a){}
              }
              
            }
        }
       throw new HotelTidakDitemukanException(id);


    }
   
   
}
