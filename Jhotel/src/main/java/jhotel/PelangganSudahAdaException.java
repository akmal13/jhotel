package jhotel;

/**
 * Exception PelangganSudahAdaException Jika Hotel sudah ada pada Database
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

public class PelangganSudahAdaException extends Exception {

    private Customer pelanggan_error;

   public PelangganSudahAdaException(Customer pelanggan_input){
        super("Pelanggan dengan data : ");
        pelanggan_error = pelanggan_input;
   }

   public String getPesan(){

        return super.getMessage()+ pelanggan_error + "--- Sudah terdaftar ---\n";
   }

}
