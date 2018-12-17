package jhotel;

/**
 * Exception HotelSudahAdaException Jika hotel sudah ada ketika ingin dilakukan add
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

public class HotelSudahAdaException extends Exception {
   private Hotel hotel_error;

   public HotelSudahAdaException(Hotel hotel_input){
       super("Hotel dengan nama: ");
       hotel_error = hotel_input;
   }

   public String getPesan(){

        return super.getMessage()+hotel_error.getNama()+"\n--- Sudah terdaftar ---\n";

   }

}
