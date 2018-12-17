package jhotel;

/**
 * Class Enum StatusKamar untuk Status untuk Room
 *
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

public enum StatusKamar
{
    Booked("Booked"),Processed("Processed"),Vacant("Vacant");
    
    private String statuskamar;
    
    StatusKamar(String statuskamar) {
        this.statuskamar = statuskamar;
    
    }
    
    public String toString(){
        return statuskamar;
    
    } 
}
