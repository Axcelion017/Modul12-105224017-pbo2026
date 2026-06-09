public class Tiket {
    private Penumpang penumpang;
    private String kodeKereta;
    private int jumlahTiket;

    public Tiket(Penumpang penumpang, String kodeKereta, int jumlahTiket) {
        this.penumpang = penumpang;
        this.kodeKereta = kodeKereta;
        this.jumlahTiket = jumlahTiket;
    }

    public String getKodeKereta() {
        return kodeKereta;
    }

    public int getJumlahTiket() {
        return jumlahTiket;
    }

    public Penumpang getPenumpang() {
        return penumpang;
    }

    public void setKodeKereta(String kodeKereta) {
        this.kodeKereta = kodeKereta;
    }
}