package jhotel;

import javax.xml.crypto.Data;
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jhotel
{
    public static void main(String[] args) {
        Lokasi loo = new Lokasi(23, 14, "NN");
        Lokasi poo = new Lokasi(22, 11, "KJ");
        Lokasi moo = new Lokasi(26,12,"KH");
        try {
            DatabaseHotel.addHotel(new Hotel("A", loo, 5));
            DatabaseHotel.addHotel(new Hotel("B", poo, 6));
            DatabaseHotel.addHotel(new Hotel("C",moo,7));
            DatabaseRoom.addRoom(new SingleRoom(DatabaseHotel.getHotel(1), "12"));
            DatabaseRoom.addRoom(new DoubleRoom(DatabaseHotel.getHotel(1), "13"));
            DatabaseRoom.addRoom(new PremiumRoom(DatabaseHotel.getHotel(2), "23"));
            DatabaseRoom.addRoom(new DoubleRoom(DatabaseHotel.getHotel(3),"34"));
            DatabaseCustomer.addCustomer(new Customer("akm",12,4,1997,"akm@ma.com","pass"));
            DatabaseRoom.getRoom(DatabaseHotel.getHotel(1),"12").setDailyTariff(14);
            DatabaseRoom.getRoom(DatabaseHotel.getHotel(3),"34").setDailyTariff(35);
        } catch (Exception e) {
        }


        SpringApplication.run(Jhotel.class, args);

    }
        public Jhotel(){

        }
    }

 

