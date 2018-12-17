package jhotel;
/**
 *   Class Lokasi.
 *
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

public class Lokasi
{
    private float x_coord;
    private float y_coord;
    private String deskripsiLokasi;

    /**
     * Constructor class Lokasi
     *
     * @param x_coord Menentukan nilai Koordinat X
     * @param y_coord Menentukan nilai Koordinat Y
     * @param deskripsiLokasi Menentukan deskripsiLokasi
     */

    public Lokasi(float x_coord,float y_coord,String deskripsiLokasi){
        this.x_coord = x_coord;
        this.y_coord = y_coord;
        this.deskripsiLokasi = deskripsiLokasi;

    }

    /**
     * getX Mengambil koordinat X dari Lokasi
     *
     * @return float Koordinat X yang akan diambil
     */
    
    public float getX (){
    
        return x_coord;
    }
    
    /**
    * getY Mengambil Koordinat Y dari Lokasi
     *
    * @return float Koordinat Y yang akan diambil
    */
    
    public float getY(){
    
        return y_coord;
    }
    
    /**
    * Menunjukkan deskripsi
    * @return Untuk menunjukkan Deskripsi
    */
    public String getDeskripsi(){
        
        return deskripsiLokasi;
    
    }
    /**
    * setX Menetapkan nilai x
     *
    * @param x_coord Untuk menetapkan X
    */
    public void setX(float x_coord){
    
        this.x_coord = x_coord;
    }
    /**
    * setY Menetapkan nilai Y
     *
    * @param y_coord Untuk menetapkan Y
    */
    public void setY(float y_coord){
    
        this.y_coord = y_coord;
    
    }
    
    /**
    * setDeskripsi Menetapkan Deskripsi lokasi
     *
    * @param deskripsiLokasi Untuk menetapkan deskripsi
    */
    
    public void setDeskripsi(String  deskripsiLokasi){
    
        this.deskripsiLokasi = deskripsiLokasi;
    
    }
    
    public String toString(){
        String print = "\nDeskripsi Lokasi : "+deskripsiLokasi+
                       "\nKoordinat X : "+x_coord+
                       "\nKoordinat Y : "+y_coord+".\n";
        
        return print;
    }
   
}
