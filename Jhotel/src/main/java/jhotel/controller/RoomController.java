package jhotel;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class RoomController {

    @RequestMapping("/vacantrooms")
    public ArrayList<Room> vacantRooms(){
        return DatabaseRoom.getVacantRooms();
    }
    @RequestMapping("/getroom/{id}/{no}")
    public Room getRoom(@PathVariable int id , @PathVariable String no){
        return DatabaseRoom.getRoom(DatabaseHotel.getHotel(id),no);
    }

}
