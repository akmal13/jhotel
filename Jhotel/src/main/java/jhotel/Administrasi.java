package jhotel;
/**
 * Kelas Administrasi untuk melakukan pemrosesan pada
 * pesanan yang dilakukan pengguna
 *
 * @author Akmal
 * @version 1.8
 * @since 31-5-18
 */
public class Administrasi
{
    /**
     * Method Pesanan Ditugaskan untuk menugaskan pesanan dengan kamar
     *
     * @param pesan Menerima Pesanan untuk Ditugaskan
     * @param kamar Menerima Kamar yang sesuai dengan Pesanan
     */
   public static void pesananDitugaskan(Pesanan pesan,Room kamar) {
       if (kamar.getStatusKamar().equals(StatusKamar.Vacant)){
           kamar.setStatusKamar(StatusKamar.Booked);
           pesan.setStatusSelesai(false);
           pesan.setStatusDiproses(true);
           pesan.setRoom(kamar);
   }
       else{
           pesan.setStatusAktif(false);

       }
    }

    /**
     * Method Pesanan Dibatalkan membatalkan pesanan yang dilakukan oleh pengguna
     *
     * @param kamar Membatalkan pesanan dengan kamar sesuai input
     */
   public static void pesananDibatalkan(Room kamar){
       kamar.setStatusKamar(StatusKamar.Vacant);
       DatabasePesanan.getPesananAktif(kamar).setStatusSelesai(false);
       DatabasePesanan.getPesananAktif(kamar).setStatusAktif(false);
       DatabasePesanan.getPesananAktif(kamar).setStatusDiproses(false);
    }

    /**
     * Method pesananSelesai untuk menset status selesai
     *
     * @param kamar menyelesaikan pesanan dengan kamar yang sesuai
     */
   
   public static void pesananSelesai(Room kamar){
       kamar.setStatusKamar(StatusKamar.Vacant);
       DatabasePesanan.getPesananAktif(kamar).setStatusSelesai(true);
       DatabasePesanan.getPesananAktif(kamar).setStatusAktif(false);
       DatabasePesanan.getPesananAktif(kamar).setStatusDiproses(false);
   }

    /**
     * Method pesananDibatalkan membatalkan pesanan dengan pesanan yang sesuai
     *
     * @param pesan membatalkan pesanan dengan pesanan input
     */
   
   public static void pesananDibatalkan(Pesanan pesan){
       pesan.getRoom().setStatusKamar(StatusKamar.Vacant);
       pesan.setStatusSelesai(false);
       pesan.setStatusDiproses(false);
       pesan.setStatusAktif(false);
       pesan.setRoom(null);
       
    }

    /**
     * Method pesananSelesai menyelesaikan pesanan sesuai dengan input
     *
     * @param pesan menyelesaikan pesanan dengan pesanan input
     */
   public static void pesananSelesai(Pesanan pesan){
       pesan.getRoom().setStatusKamar(StatusKamar.Vacant);
       pesan.setStatusSelesai(true);
       pesan.setStatusDiproses(false);
       pesan.setStatusAktif(false);
    }
 
}
