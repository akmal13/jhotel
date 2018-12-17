package jhotel;

/**
 * PremiumRoom sebagai Child Class dari Room
 *
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

public class PremiumRoom extends Room
{
    private double DISCOUNT = 0.3;
    private static final TipeKamar TIPE_KAMAR = TipeKamar.Premium;

    /**
     * Constructor untuk PremiumRoom
     *
     * @param hotel Menentukan Hotel untuk Room
     * @param nomor_kamar Menentukan Nomor Kamar untuk Room
     */

    public PremiumRoom(Hotel hotel,String nomor_kamar){
        super(hotel,nomor_kamar);
    }

    /**
     * getTipeKamar Mengambil Tipe kamar dari Room
     *
     * @return TipeKamar tipe dari kamar
     */

    public TipeKamar getTipeKamar(){
        return TIPE_KAMAR;
    }

    /**
     * getDiscount Mengambil discount dari Kamar tersebut
     *
     * @return double Discount dari kamar
     */

    public double getDiscount(){
        return DISCOUNT;
    
    }

    /**
     * setDailyTariff Menentukan nilai tariff dari kamar
     *
     * @param dailytariff Nilai dari tariff
     */

    public void setDailyTariff(double dailytariff){
        setDailyTariff(dailytariff*(1-DISCOUNT));
    }
   
}
