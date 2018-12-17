package jhotel;

/**
 * Single Room sebagai Child Class dari Room
 *
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

public class SingleRoom extends Room
{
      private static final TipeKamar TIPE_KAMAR = TipeKamar.Single;

    /**
     * Constructor untuk Single Room
     *
     * @param hotel input hotel untuk Room
     * @param nomor_kamar nomor kamar dari Room
     */

    public SingleRoom(Hotel hotel,String nomor_kamar){
       super(hotel,nomor_kamar);
    }
       
       public TipeKamar getTipeKamar(){
        
        return TIPE_KAMAR;
        }

}
