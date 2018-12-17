package jhotel;

/**
 * Exception PelangganTidakDitemukanException Jika Pelanggan tidak ada ketika remove Pelanggan
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

public class PelangganTidakDitemukanException extends Exception {

    int pelanggan_error;

    public PelangganTidakDitemukanException(int pelanggan_input){
        super("Data Customer dengan ID : ");
        pelanggan_error = pelanggan_input;
    }
    public String getPesan(){

        return super.getMessage() + pelanggan_error + "\n--- Tidak ditemukan ---\n";
    }
}
