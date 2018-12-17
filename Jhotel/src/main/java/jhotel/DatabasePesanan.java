package jhotel;
/**
 *   Class DatabasePesanan menyimpan seluruh pesanan yang dibuat.
 *
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

import java.util.ArrayList;
import java.util.Scanner;

public class DatabasePesanan
{
    private static ArrayList<Pesanan> PESANAN_DATABASE = new ArrayList<>();
    private static int LAST_PESANAN_ID = 0;

    /**
     * getPesananDatabase Memberi database pesanan
     *
     * @return ArrayList<Pesanan> Database Pesanan
     */
    public static ArrayList<Pesanan> getPesananDatabase(){
    
        return PESANAN_DATABASE;
    }

    /**
     * getLastPesananID memberi id pesanan terakhir
     *
     * @return int id terakhir dari database
     */
    
    public static int getLastPesananID(){
        return LAST_PESANAN_ID;
    }
    
    
    /**
     * addPesanan Menambah pesanan kepada database
     *
     * @return Untuk status apakah true atau tidak
     * @exception PesananSudahAdaException jika sudah ada pesanan pada database
     */
    public static  boolean addPesanan(Pesanan baru) throws PesananSudahAdaException{

            for(int i=0;i<PESANAN_DATABASE.size();i++) {
                if (PESANAN_DATABASE.get(i).getPelanggan().equals(baru.getPelanggan())) {
                    throw new PesananSudahAdaException(baru);
                }
            }
            PESANAN_DATABASE.add(baru);
            LAST_PESANAN_ID = baru.getID();
            return true;
    }

    /**
     * getPesanan mengambil pesanan yang memiliki id yang sama
     *
     * @param id id dari pesanan yang ingin diambil
     * @return Pesanan pesanan yang ditemukan
     */

    public static Pesanan getPesanan(int id){
       int besar = PESANAN_DATABASE.size();
       int i= 0;
       int w= 0;
       for(i=0;i<besar;i++){
             if(PESANAN_DATABASE.get(i).getID() == id){
                   return PESANAN_DATABASE.get(i);
                }
        }
        return null;
    }

    /**
     * getPesananAktif mengambil pesanan aktif yang sesuai dengan kamar
     *
     * @param kamar sebagai input ntuk mencari pesanan
     * @return Pesanan pesanan yang ditemukan
     */

    public static Pesanan getPesananAktif(Room kamar){
       int besar = PESANAN_DATABASE.size();
       int i= 0;
       for(i=0;i<besar;i++){
             if(PESANAN_DATABASE.get(i).getRoom().equals(kamar) && PESANAN_DATABASE.get(i).getStatusAktif()){
                   return PESANAN_DATABASE.get(i);

                }
        }
        return null;
    }

    /**
     * getPesananAktif Mengambil pesanan aktif berdasarkan customer
     *
     * @param pelanggan pesanan aktif yang memiliki pelanggan tersbut
     * @return Pesanan Pesanan yang ditemukan berdasarkan pelanggan
     */
    
    public static Pesanan getPesananAktif(Customer pelanggan){
       int besar = PESANAN_DATABASE.size();
       int i= 0;
       for(i=0;i<besar;i++){
             if(PESANAN_DATABASE.get(i).getStatusAktif() && PESANAN_DATABASE.get(i).getPelanggan().equals(pelanggan)){
                   return PESANAN_DATABASE.get(i);
                }
        }
        return null;
    }

    /**
     * removePesanan pesanan yang akan dihapus dari database
     *
     * @param pelanggan pelanggan yang akan dihapus dari database
     * @return boolean apakah berhasil di remove
     * @throws PesananTidakDitemukanException exception jika pesanan tidak ditemukan pada database
     */


    public static boolean removePesanan(Customer pelanggan) throws PesananTidakDitemukanException
    {
        for (Pesanan var : PESANAN_DATABASE)
        {
            if (var.getPelanggan().equals(pelanggan))
            {
                if(var.getRoom()!=null){
                    Administrasi.pesananDibatalkan(var.getRoom());
                }
                else{
                    var.setStatusAktif(false);
                }
                PESANAN_DATABASE.remove(pelanggan.getid()-1);
                return true;
            }
        }
        throw new PesananTidakDitemukanException(pelanggan);

    }



}
