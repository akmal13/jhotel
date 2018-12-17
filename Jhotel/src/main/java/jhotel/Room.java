package jhotel;

/**
 *   Class Room.
 *
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

public abstract class Room
{
    private Hotel hotel;
    private String nomor_kamar;
    protected double dailyTariff;
    private StatusKamar statuskamar;

    /**
     * Constructor Room
     *
     * @param hotel Menentukan hotel untuk Room
     * @param nomor_kamar Menentukan nomor kamar untuk Room
     */
    
    public Room (Hotel hotel,String nomor_kamar){
        this.hotel = hotel;
        this.nomor_kamar = nomor_kamar;
        statuskamar = StatusKamar.Vacant;
    }

    /**
     * getHotel Mengambil Hotel dari Room
     *
     * @return Hotel hotel dari Room
     */
    
    public Hotel gethotel(){
        return hotel;
    }

    /**
     * getNomorKamar Mengambil nomor kamar dari room
     *
     * @return String nomor kamar
     */
    
    public String getNomorKamar(){
        return nomor_kamar;
    }

    /**
     * getDailyTariff Mengambil tarif dari Room
     *
     * @return double tarif dari Room
     */
    
    public double getDailyTariff(){
        return dailyTariff;
    }

    /**
     * getStatusKamar Mengambil status kamar dari Room
     *
     * @return StatusKamar status dari room
     */

    public StatusKamar getStatusKamar(){
        return statuskamar;
    }

    public abstract TipeKamar getTipeKamar();

    /**
     * setHotel Mengatur hotel dari Room
     *
     * @param hotel input hotel
     */

    public void setHotel(Hotel hotel){
        this.hotel = hotel;
    }

    /**
     * setNomorKamar Menetapkan nomor kamar dari Room
     *
     * @param nomor_kamar nilai Nomor kamar
     */
    
    public void setNomorKamar(String nomor_kamar){
        this.nomor_kamar = nomor_kamar;
    }

    /**
     * setDailyTariff menetapkan tariff dari Room
     *
     * @param dailytariff nilai dari tariff
     */

    public void setDailyTariff(double dailytariff){
        this.dailyTariff = dailytariff;
    }

    /**
     * setStatusKamar menetapkan status kamar dari room
     *
     * @param status_kamar status kamar dariRoom
     */

    public void setStatusKamar(StatusKamar status_kamar){
        statuskamar = status_kamar;
    
    }
  
    public String toString(){
        if(true){
            String print = "\nNama Hotel : "+hotel.getNama()+
                           "\nTipe Kamar : "+getTipeKamar()+
                           "\nHarga : "+dailyTariff+
                           "\nStatus Kamar : "+statuskamar+".\n";
                           
            return print;
        }
        else{
             DatabasePesanan dp = new DatabasePesanan();
             String print = "\nNama Hotel : "+hotel.getNama()+
                            "\nTipe Kamar : "+getTipeKamar()+
                            "\nHarga : "+dailyTariff+
                            "\nStatus Kamar : "+statuskamar+
                            "\nPesanan : "+dp.getPesanan(hotel.getID()) ;
                            
             return print;
        }
    }
    
}
