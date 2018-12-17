package jhotel;
/**
 *   Class DatabaseCustomer database dari customer
 *
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */

import java.util.*;
public class DatabaseCustomer
{
   private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
   private static int LAST_CUSTOMER_ID = 0;

    /**
     * getCustomerDatabase untuk mengambil database dari
     *
     * @return ArrayList<Customer> memberi database dari customer
     */
   public static ArrayList<Customer> getCustomerDatabase(){
      return CUSTOMER_DATABASE;
   }

    /**
     * getLastCustomerID memberikan id customer terakhir
     *
     * @return int id customer terakhir
     */
   
   public static int getLastCustomerID(){
    return LAST_CUSTOMER_ID;
   } 
   
   /**
     * addCustomer menambah customer baru
    *
     * @param baru Customer baru untuk ditambahkan ke database
     * @return boolean Status proses Customer baru
     */
   
   public static boolean addCustomer(Customer baru) throws PelangganSudahAdaException{
       int i;
       int w = 0;
        for(i=0;i<CUSTOMER_DATABASE.size();i++){
           if(CUSTOMER_DATABASE.get(i).getid() == baru.getid()  || CUSTOMER_DATABASE.get(i).getEmail().equals(baru.getEmail())){
                    w++;
                }
         }
        if(w==0){
            CUSTOMER_DATABASE.add(baru);
            LAST_CUSTOMER_ID = baru.getid();
            return true;
        }

        throw new  PelangganSudahAdaException(baru);

    }
    
    /**
     * getCustomer Mengambil customer berdasarkan ID
     * @param id Id dari pengguna yang akan diambil
     * @return Customer mengembalikan customer yang ditemukan
     */
    
   public static Customer getCustomer(int id){
       int i;
        for(i=0;i<CUSTOMER_DATABASE.size();i++){
           if(CUSTOMER_DATABASE.get(i).getid() == id){
               return CUSTOMER_DATABASE.get(i);
            }
         }
       return null;
    
    }

    /**
     * removeCustomer menghapus customer dari database customer
     *
     * @param id id darri customer
     * @return boolean apakah berhasil dilakukan oleh method
     * @throws PelangganTidakDitemukanException jika tidak ditemukan customer dengan id berikut
     */

   public static boolean removeCustomer(int id) throws PelangganTidakDitemukanException{
       int i;
        for(i=0;i<CUSTOMER_DATABASE.size();i++){
           if(CUSTOMER_DATABASE.get(i).getid() == id){
                try {
                    DatabasePesanan.removePesanan(DatabaseCustomer.getCustomer(i));
                }catch(PesananTidakDitemukanException u){System.err.println(u.getPesan());}
               CUSTOMER_DATABASE.remove(i);
               return true;
            }
         }
       throw new PelangganTidakDitemukanException(id);

    }

    /**
     * getCustomerLogin mendapat customer dari password dan email pengguna
     *
     * @param email email input untuk mencari customer
     * @param password password email untuk mencari customer
     * @return Customer customer yang ditemukan
     */
    public static Customer getCustomerLogin(String email, String password){
       int i;
       for(i=0;i<CUSTOMER_DATABASE.size();i++){
           if(CUSTOMER_DATABASE.get(i).getEmail().equals(email) && CUSTOMER_DATABASE.get(i).getPassword().equals(password)){
               return CUSTOMER_DATABASE.get(i);

           }

       }
        return null;
    }
}
