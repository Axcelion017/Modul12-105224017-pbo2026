interface InterfaceReservasi{
    void pesanTiket(Tiket tiket) throws TiketHabisException, RuteTidakDitemukanException;
    void tampilkanJadwal();
}


public class Reservasi implements InterfaceReservasi{
    private KeretaApiRepository keretaRepository;

    public Reservasi(KeretaApiRepository keretaRepository) {
        this.keretaRepository = keretaRepository;
    }

    public void pesanTiket(Tiket tiket) throws TiketHabisException, RuteTidakDitemukanException {
        KeretaApi kereta = keretaRepository.cariKode(tiket.getKodeKereta());
        
        if (kereta.getSisaKursi() < tiket.getJumlahTiket()) {
            throw new TiketHabisException(kereta.getNamaKereta(), kereta.getSisaKursi());
        }
        kereta.kurangiKursi(tiket.getJumlahTiket());
        System.out.println("Tiket berhasil dipesan untuk " + tiket.getPenumpang().getNama() + " pada kereta " + kereta.getNamaKereta() + ". Sisa kursi: " + kereta.getSisaKursi());
    }

    @Override
    public void tampilkanJadwal() {
        System.out.println("\n--- JADWAL KERETA API ---");
        for (KeretaApi kereta : keretaRepository.getAllKereta()) {
            System.out.println("Kode: " + kereta.getKode() + " | Nama: " + kereta.getNamaKereta() + " | Rute: " + kereta.getPerjalanan() + " | Sisa Kursi: " + kereta.getSisaKursi());
        }
    }
}


