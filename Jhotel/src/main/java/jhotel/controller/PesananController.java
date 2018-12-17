package jhotel;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class PesananController {

    @RequestMapping("/pesanancustomer/{id}")
    public Pesanan pesananCust(@PathVariable int id){
        return DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(id));
    }
    @RequestMapping("/pesanan/{id}")
    public Pesanan getPesanan(@PathVariable int id){
        return DatabasePesanan.getPesanan(id);
    }
    @RequestMapping(value = "/bookpesanan",method = RequestMethod.POST)
    public Pesanan buatPesanan(@RequestParam(value="hari") int jumlah_hari,@RequestParam(value ="idcustomer") int id_customer,@RequestParam(value="idhotel") int id_hotel,@RequestParam(value="nomorkamar") String nomor_kamar){
        Pesanan pes = new Pesanan(DatabaseCustomer.getCustomer(id_customer),jumlah_hari);
        Administrasi.pesananDitugaskan(pes,DatabaseRoom.getRoom(DatabaseHotel.getHotel(id_hotel),nomor_kamar));
        Date date = new Date();
        pes.setTanggalPesan(date);
        pes.setBiaya();
        try{DatabasePesanan.addPesanan(pes);
        }catch (PesananSudahAdaException a) {a.getPesan();}

        return DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(id_customer));
    }

    @RequestMapping(value = "/cancelpesanan",method = RequestMethod.POST)
    public Pesanan batalkanPesanan(@RequestParam(value ="id") int id){
        Administrasi.pesananDibatalkan(DatabasePesanan.getPesanan(id));
        return DatabasePesanan.getPesanan(id);
    }

    @RequestMapping(value = "/finishpesanan",method = RequestMethod.POST)
    public Pesanan selesaikanPesanan(@RequestParam(value ="id") int id){
        Administrasi.pesananSelesai(DatabasePesanan.getPesanan(id));
        return DatabasePesanan.getPesanan(id);
    }

}
