public class Penumpang {
    private String nama, nik;

    public Penumpang(String nama, String nik) throws DataPenumpangTidakValidException {
        setNama(nama);
        setNik(nik);
    }

    public String getNama() {
        return nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNama(String nama) throws DataPenumpangTidakValidException {
        if(nama == null || nama.trim().isEmpty()){
            throw new DataPenumpangTidakValidException("Nama penumpang tidak boleh kosong.");
        }
        this.nama = nama;
    }

    public void setNik(String nik) throws DataPenumpangTidakValidException {
        if(nik.length() != 16 || !nik.matches("[0-9]+")){
            throw new DataPenumpangTidakValidException("Data NIK harus mengandung 16 angka.");
        }
        this.nik = nik;
    }
}
