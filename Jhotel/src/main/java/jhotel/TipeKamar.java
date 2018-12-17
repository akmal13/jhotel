package jhotel;

/**
 * Class Enum TipeKamar untuk tipe dari Room
 *
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

public enum TipeKamar
{
    Single("Single"),Double("Double"),Premium("Premium");
    
    private String tipekamar;
    
    TipeKamar(String tipekamar) {
        this.tipekamar = tipekamar;
    
    }
    
    public String toString(){
        return tipekamar;
    
    } 
    
}
