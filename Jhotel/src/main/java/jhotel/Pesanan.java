package jhotel;
/**
 *   Class Pesanan.
 *
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */
import java.util.Date;
import java.util.*;
public class Pesanan
{
    private double biaya;
    private double jumlahHari;
    private Customer pelanggan;
    private boolean isdiproses;
    private boolean isselesai;
    private Room kamar;
    private Date tanggalPesan;
    private boolean isAktif = true;
    private int id;

    /**
     * Constructor Pesanan
     *
     * @param pelanggan Menentukan Pelanggan untuk pesanan
     * @param jumlahHari Menentukan Hari dari Pesanan
     */

    public Pesanan (Customer pelanggan,double jumlahHari){
        this.jumlahHari =jumlahHari;
        this.pelanggan = pelanggan;
        tanggalPesan = new Date();
        DatabasePesanan n = new DatabasePesanan();
        id = n.getLastPesananID() + 1; 
    }
    
    public Pesanan(GregorianCalendar time){
       
         tanggalPesan = new Date(time.get(Calendar.YEAR),time.get(Calendar.MONTH),time.get(Calendar.DATE));
    }

    /**
     * getId Mengambil ID dari PEsanan
     *
     * @return int ID dari Pesanan
     */
    
    public int getID(){
        
        return id;
    }

    /**
     * getBiaya Mengambil biaya dari pesanan
     *
     * @return double besar biaya
     */

    public double getBiaya (){
        
        return biaya;
    }

    /**
     * getJumlahHari mengambil jumlah hari dari pesanan
     *
     * @return double jumlah hari dari pesanan tersebut
     */

    public double getJumlahHari(){
        
        return jumlahHari;
    
    }
    
    /**
     * getPelanggan Menunjukkan pelanggan
     *
     * @return Customer Untuk menunjukkan pelanggan
     */

    public Customer getPelanggan(){

    
        return pelanggan;
    }

    /**
     * getStatusAktif Menunjukkan status Aktif
     *
     * @return boolean Menampilkan status apakah true or false
     */

    public boolean getStatusAktif (){
    
        return isAktif;
    } 
    
    /**
     * getStatusDiproses Menunjukkan status proses
     *
     * @return boolean Menampilkan status apakah true or false
     */

    public boolean getStatusDiproses (){
    
        return isdiproses;
    } 
    
    /**
     * getStatusSelesai Menunjukkan status selesai
     *
     * @return boolean Menunjukkan status apakah selesai
     */

     public boolean getStatusSelesai (){
    
        return isselesai;
    }

    /**
     * getRoom Mengambil Room dari Pesanan
     *
     * @return Room Room pada pesanan
     */
    
    public Room getRoom(){
        return kamar;
    }

    /**
     * getTanggalPesan Mengambil tanggal pesan Dari pesanan
     *
     * @return Date Tanggal dari pesanan
     */

    public Date getTanggalPesan(){
        return tanggalPesan;
    }

    /**
     * setID Menentukan id dari Pesanan
     *
     * @param id Id input
     */

    public void setID(int id){
        this.id=id;
    }

    /**
     *setBiaya Menentukan besar dari Biaya
     */

    public void setBiaya (){
        
        biaya = kamar.getDailyTariff() * jumlahHari;
           
    }

    /**
     * setJumlahHari Menentukan jumlah hari dari pesanan
     *
     * @param jumlahHari Hari dari pesanan
     */

    public void setJumlahHari(double jumlahHari){
    
        this.jumlahHari = jumlahHari;
    
    }
    
    /**
     * setPelanggan Menetapkan pelanggan
     *
     * @param pelanggan untuk menambah customer baru
     */

    public void setPelanggan(Customer pelanggan){
        
        this.pelanggan = pelanggan;
        
    }
    
    /**
     * setStatusDiproses Menetapkan status pemrosesan
     *
     * @param diproses Menetapkan status
     */
    public void setStatusDiproses(boolean diproses){
        
        isdiproses = diproses;
    }
    
    /**
     * setStatusSelesai Menetapkan status penyelesaian
     *
     * @param selesai untuk menetapkan status selesai
     */
    public void setStatusSelesai(boolean selesai){
    
        isselesai = selesai;
        
    }

    /**
     * setStatusAktif Menetapkan status aktif dari pesanan
     *
     * @param isAktif status dari aktif
     */

    public void setStatusAktif(boolean isAktif){
    
        this.isAktif = isAktif;
    }

    /**
     * setRoom menentukan Room untuk pesanan
     *
     * @param kamar Room untuk pesanan
     */

    public void setRoom(Room kamar){
        this.kamar = kamar;
    }

    /**
     * setTanggalPesan Menentuka tanggal pesanan
     *
     * @param tanggalPesan tanggal pesanan
     */
    
    public void setTanggalPesan(Date tanggalPesan){
        this.tanggalPesan = tanggalPesan;
    }
    
    public String toString(){
        String final_status = "KOSONG";
        if(isdiproses == true && isselesai == false){
            final_status = "DIPROSES";
        }
        else if(isdiproses == false && isselesai == false){
            final_status = "KOSONG";
        }
        else if(isdiproses == false && isselesai == true){
            final_status = "fi";
        }
        else{
            final_status = "SELESAI";
        }
        String print;
        if(kamar == null){
            print = " \nDibuat oleh : " +pelanggan.getNama() +
                    "\nProses Booking untuk : -"+
                    "\nKamar Nomor : -" +
                    "\nDengan Tipe kamar yang diinginkan : -" +
                    "\nStatus : "+final_status+".\n" ;

        }
        else {
             print = " \nDibuat oleh : " + pelanggan.getNama() +
                    "\nProses Booking untuk : " + kamar.gethotel() +
                    "\nKamar Nomor : " + kamar.getNomorKamar() +
                    "\nDengan Tipe kamar yang diinginkan : " + kamar.getTipeKamar() +
                    "\nStatus : " + final_status + ".\n";
        }
        return print;
        
    }
}
