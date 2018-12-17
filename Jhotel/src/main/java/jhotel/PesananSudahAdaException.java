package jhotel;

/**
 * Exception PesananSudahAdaException Jika Pesanan sudah ada pada Database
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

public class PesananSudahAdaException extends Exception {

    Pesanan pesanan_error;

    public PesananSudahAdaException (Pesanan pesanan_input){
        super("Pesanan yang dipesan oleh : ");
        pesanan_error = pesanan_input;


    }

    public String getPesan(){

        return super.getMessage() + pesanan_error.getPelanggan().getNama() + "\n--- Sudah melakukan pemesanan ---\n";

    }
}
