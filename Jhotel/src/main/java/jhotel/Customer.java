package jhotel;
/**
 *   Class Customer untuk Menyimpan Customer
 *
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */
import java.util.Date;
import java.util.Date.*;
import java.util.regex.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Customer
{

     protected int id;
     protected String nama;
     protected String email;
     protected Date dob;
     protected String password;

    /**
     * Constructor untuk customer memberi nilai awal pada saat objek customer dibuat
     *
     * @param nama       memberi nama sesuai input
     * @param tanggal    memberi tanggal lahir sesuai input
     * @param bulan      memberi bulan lahir sesuai input
     * @param tahun      memberi tahun lahir sesuai input
     * @param ema        memberi email sesuai input
     * @param password   memberi password sesuai input
     */
     
     public Customer(String nama,int tanggal,int bulan,int tahun,String ema,String password){
         id = DatabaseCustomer.getLastCustomerID() + 1;
         this.nama = nama;
         dob = new Date((tahun-1900),bulan,tanggal);
         this.password = password;
         setEmail(ema);
     
        }

    /**
     * Constructor untuk customer memberi input awal customer
     *
     * @param nama      memberi nama untuk customer
     * @param time      memberi waktu dibuat customer
     * @param ema       memberi email dari customer tersebut
     * @param password  memberi paasword dari customer tersebut
     */
     public Customer(String nama,Date time,String ema,String password){
         id = DatabaseCustomer.getLastCustomerID() + 1;
         this.nama = nama;
         this.password = password;
         this.dob = time;
         setEmail(ema);
        }
        
        
        /**
         * getid untuk memberikan id dari customer
         *
         * @return int Untuk menampilkan id
         */   
        
     public int getid(){

        return id;
        
        }
        
        /**
         *  getNama untuk memberikan nama dari customer
         *
         * @return String nama dari customer
         */

    public String getNama(){

        
        return nama;
        }

    /**
     *  getEmail untuk memberikan email dari customer
     *
     * @return String Email dari customer
     */

    public String getEmail(){
        return email;
        }

    /**
     * getDob untuk memberikan tanggal lahir customer
     */

    public void getDob(){
        
         System.out.printf("%1$s %2$tB %2$td,%2$tY","Tanggal : ",dob);
        }
        
        /**
         * setID untuk menetapkan id dari customer
         *
         * @param id Untuk menetapkan id
         */   
    
     public void setID(int id){
        
         this.id = id;

       }
    
        /**
         * setNama untuk menetapkan
         * @param nama Untuk menetapkan nama
         */  
      
     public void setNama(String nama){
        
        this.nama = nama;
       }

    /**
     * setEmail untuk menetapkan email dari customer
     *
     * @param email untuk menetapkan email
     */

    public void setEmail(String email){
        Pattern pattern = Pattern.compile("/[a-z]{2}\\-[0-9]{3}", 5);
        Matcher matcher = pattern.matcher("aa098hkasjdh786sda sdb76ads");

        while (matcher.find())
        {
            System.out.println(matcher.group()+"");
        }
         
         this.email = email;
        }

    /**
     * setDOB Menset tanggal lahir customer
     *
     * @param dob tanggal lahir input
     */
    public void setDOB(Date dob){
        this.dob =dob;
        }
       
     public String toString(){
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        if(DatabasePesanan.getPesanan(id) != null){
        String print =  "\nCustomer ID    : "+id+
                        "\nName           : "+nama+
                        "\nE-Mail         : "+email+
                        "\nDate of Birth  : "+format.format(this.dob)+
                        "\n Booking order is in progress\n";
        return print;
       }
       else{
           String print =  "\nCustomer ID    : "+id+
                        "\nName           : "+nama+
                        "\nE-Mail         : "+email+
                        "\nDate of Birth  : "+format.format(this.dob)+
                        "\n";
           return print;
        }
	}

    /**
     * getPassword untuk memberikan password dari customer
     *
     * @return String password dari customer
     */
        public String getPassword(){
            return password;
         }

         public void setPassword(String password){
            this.password = password;
         }

}
