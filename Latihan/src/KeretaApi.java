import java.util.ArrayList;
import java.util.List;

public class KeretaApi {
    private String kode, namaKereta, perjalanan;
    private int sisaKursi;

    KeretaApi(String kode, String namaKereta, String perjalanan, int kapasitas){
        this.kode = kode;
        this.namaKereta = namaKereta;
        this.perjalanan = perjalanan;
        this.sisaKursi = kapasitas;
    }

    public String getKode() {
        return kode;
    }

    public String getNamaKereta() {
        return namaKereta;
    }

    public String getPerjalanan() {
        return perjalanan;
    }

    public int getSisaKursi(){
        return sisaKursi;
    }

    public void kurangiKursi(int jumlah) {
        this.sisaKursi -= jumlah;
    }
}

interface KeretaApiRepository {
    List<KeretaApi> getAllKereta();
    KeretaApi cariKode(String kode);
}

class KeretaRepositoryImpl implements KeretaApiRepository {
    private List<KeretaApi> daftarKereta;

    public KeretaRepositoryImpl() {
        daftarKereta = new ArrayList<>();
        daftarKereta.add(new KeretaApi("K01", "Argo Bromo", "JKT - SBY", 50));
        daftarKereta.add(new KeretaApi("K02", "Parahyangan", "JKT - BDG", 15));
    }

    @Override
    public List<KeretaApi> getAllKereta() {
        return daftarKereta;
    }

    @Override
    public KeretaApi cariKode(String kode) {
        for (KeretaApi k : daftarKereta) {
            if (k.getKode().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }
}
