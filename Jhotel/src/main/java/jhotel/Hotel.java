package jhotel;
/**
 *   Class Hotel untuk menyimpan hotel
 *
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

public class Hotel
{
  private String nama;
  private Lokasi lokasi;
  private int bintang;
  private int id;

    /**
     * Contructor dari hotel
     *
     * @param nama Menentukan nama dari Hotel tersebut
     * @param lokasi Menentukan lokasi dari hotel
     * @param bintang Menentukan bintang hotel
     */
  
  public Hotel(String nama,Lokasi lokasi,int bintang){
      DatabaseHotel dh = new DatabaseHotel();
      id = dh.getLastHotelID() + 1;
      this.nama = nama;
      this.lokasi = lokasi;
      this.bintang = bintang;
    }

    /**
     * getID Mengambil ID dari hotel
     *
     * @return int ID dari hotel
     */
    
  public int getID(){
    return id;
    } 
    
    /**
     * getBintang Menunjukkan bintang dari hotel
     * @return int Menunjukkan nilai bintang
     */

  public int getBintang(){
    
      return bintang;
    }
    
    /**
     * getNama Menunjukkan nama
     * @return String Menampilkan nama
     */
    
  public String getNama(){
    
      return nama;
    }

    /**
     * getLokasi Menunjukkan lokasi
     *
     * @return Lokasi Menunjukkan Lokasi dari Hotel
     */

  public Lokasi getLokasi(){
    
      return lokasi;
    }

    /**
     * setID Menentukan id dari Hotel
     *
     * @param id ID dari hotel yang ingin ditentukan
     */
    
  public void setID(int id){
    this.id = id;
    }  
    
    /**
     * setNama Menetapkan nama dari hotel
     *
     * @param nama menetapkan nama dari hotel
     */
    
  public void setNama(String nama){
    
      this.nama = nama;
    }
    
    /**
     * setLokasi Menetapkan Lokasi dari Hotel
     *
     * @param lokasi menetapkan lokasi dari hotel
     */
    
  public void setLokasi(Lokasi lokasi){
    
      this.lokasi = lokasi;
    
    }
    
    /**
     * setBintang Menetapkan bintang dari Hotel
     *
     * @param bintang menetapkan nilai bintang
     */
    
  public void setBintang(int bintang){
    
      this.bintang = bintang;
    
    }
    
  public String toString(){
      String print = "\nNama dari Hotel adalah : "+nama+
                     "\nHotel berbintang : "+bintang+
                     "\nDeskripsi hotel adalah : "+lokasi.getDeskripsi()+".\n";
      
      return print; 
    }
}