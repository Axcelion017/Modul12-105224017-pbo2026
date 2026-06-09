import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KeretaApiRepository repository = new KeretaRepositoryImpl();
        Reservasi reservasi = new Reservasi(repository);
        boolean isRunning = true;

        System.out.println("  SISTEM RESERVASI TIKET KERETA API \"JAVA EXPRESS\"  ");

        while (isRunning) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Lihat Jadwal Kereta");
            System.out.println("2. Pesan Tiket");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");

            try {
                int menu = scanner.nextInt();
                scanner.nextLine(); // Membersihkan buffer

                switch (menu) {
                    case 1:
                        reservasi.tampilkanJadwal();
                        break;
                    case 2:
                        System.out.println("\n--- PESAN TIKET ---");
                        System.out.print("Masukkan Kode Kereta: ");
                        String kodeKereta = scanner.nextLine();
                        System.out.print("Masukkan NIK Penumpang (16 digit angka): ");
                        String nik = scanner.nextLine();
                        System.out.print("Masukkan Nama Penumpang: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Jumlah Tiket: ");
                        int jumlahTiket = scanner.nextInt();
                        scanner.nextLine(); // Membersihkan buffer

                        try {
                            Penumpang penumpang = new Penumpang(nama, nik);
                            Tiket tiket = new Tiket(penumpang, kodeKereta, jumlahTiket);
                            reservasi.pesanTiket(tiket);
                        } catch (DataPenumpangTidakValidException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        } catch (RuteTidakDitemukanException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        } catch (TiketHabisException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Terjadi kesalahan: " + e.getMessage());
                        }
                        break;
                    case 3:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan masukkan angka 1, 2, atau 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Input harus berupa angka. Silakan coba lagi.");
                scanner.nextLine(); // Membersihkan buffer input agar tidak terjadi infinite loop
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            } finally {
                if (!isRunning) {
                    System.out.println("\nMenutup sistem...");
                    System.out.println("Terima kasih telah menggunakan JAVA EXPRESS!");
                }
            }
        }
        scanner.close();
    }
}
