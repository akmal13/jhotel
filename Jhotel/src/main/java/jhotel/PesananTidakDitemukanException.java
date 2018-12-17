package jhotel;

/**
 * Exception PesananTidakDitemukanException Jika Pesanan tidak ada ketika remove Pesanan
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

public class PesananTidakDitemukanException extends Exception {

    private Customer pelanggan_error;

    public PesananTidakDitemukanException(Customer pelanggan_input){
        super("Pesanan yang dipesan oleh : ");
        pelanggan_error = pelanggan_input;
    }
    public String getPesan(){

        return super.getMessage()+ pelanggan_error.getNama() +"\n--- Tidak ditemukan ---\n";
    }

}
