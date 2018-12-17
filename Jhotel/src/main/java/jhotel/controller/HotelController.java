package jhotel;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HotelController {

    @RequestMapping("/gethotellist")
    public ArrayList<Hotel> hotelsList(){
        return DatabaseHotel.getHotelDatabase();
    }
    @RequestMapping("/gethotel/{id}")
    public Hotel getHotel(@PathVariable int id){
        return DatabaseHotel.getHotel(id);
    }
}
