public class LibraryManager {
    PencarianBuku pencarianBuku;
    HitungDenda hitungDenda;
    CetakStrukDenda cetakStrukDenda;
    PeminjamanBuku peminjamanBuku;

    public LibraryManager() {
        pencarianBuku = new PencarianBuku();
        hitungDenda = new HitungDenda();
        cetakStrukDenda = new CetakStrukDendaTeks(); //Default cetak struk denda dalam teks
        peminjamanBuku = new PeminjamanBuku();
    }

    public void cariBuku(String judul) {
        pencarianBuku.cariBuku(judul);
    }

    public void pinjamBuku(String judul) {
        peminjamanBuku.pinjamBuku(judul);
    }

    public void cetakStrukDenda() {
        double denda = hitungDenda.hitungDenda(5); //Contoh: terlambat 5 hari
        cetakStrukDenda.cetakStrukDenda();
    }

}

public class PeminjamanBuku{
    public void pinjamBuku(String judul) {
        //Proses peminjaman buku
    }
}

public class CetakStrukDendaTeks implements CetakStrukDenda{
    @Override
    public void cetakStrukDenda() {
        //Dalam Teks
    }
}

public class CetakStrukDendaTabel implements CetakStrukDenda{
    @Override
    public void cetakStrukDenda() {
        //Dalam Tabel
    }
}

public interface CetakStrukDenda{
    public void cetakStrukDenda();
}

public class HitungDenda{
    public double hitungDenda(int hariTerlambat) {
        //Hitung denda berdasarkan hari terlambat
        return hariTerlambat * 500; //Contoh: denda Rp 500 per hari
    }
}

public class PencarianBuku{
    public void cariBuku(String judul) {
        //Print informasi buku yang dicari
    }
}