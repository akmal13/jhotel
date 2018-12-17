package jhotel;
/**
 * Double Room sebagai Child Class dari Room
 *
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */
public class DoubleRoom extends Room
{
   private Customer customer2;
   private static final TipeKamar TIPE_KAMAR = TipeKamar.Double;

    /**
     * Constructor dari Double Room
     *
     * @param hotel Room dari Hotel yang ingin menjadi Double room
     * @param nomor_kamar Nomor kamar dari room
     */

   public DoubleRoom(Hotel hotel,String nomor_kamar){
       super(hotel,nomor_kamar);
    }

    /**
     * getCustomer2 Mengambil Customer Dari DoubleRoom
     *
     * @return Customer dari Room tersebut
     */

   public Customer getCustomer2(){
       return customer2;
    }

    /**
     * getTipeKamar Mengambil tipe kamar dari Sebuah Room
     *
     * @return TipeKamar tipe kamar dari room tersebut
     */
   
    public TipeKamar getTipeKamar(){
        
        return TIPE_KAMAR;
    }

    /**
     * setCustomer2 Menentukan customer dari room tersebut
     *
     * @param customer2 menetukan customer dari Room
     */
    
    public void setCustomer2(Customer customer2){
    
        this.customer2 = customer2;
    }
        
   
}
