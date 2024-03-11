import java.util.ArrayList;
import java.util.Scanner;

public class TokoSepeda {

    private static ArrayList<Sepeda> daftarSepeda = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            tampilkanMenu();
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Menangani karakter newline

            switch (pilihan) {
                case 1:
                    tambahSepeda();
                    break;
                case 2:
                    lihatDaftarSepeda();
                    break;
                case 3:
                    ubahSepeda();
                    break;
                case 4:
                    hapusSepeda();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void tampilkanMenu() {
        System.out.println("=== Sistem Pendataan Toko Sepeda Aneka Sepeda ===");
        System.out.println("1. Tambah Sepeda");
        System.out.println("2. Lihat Daftar Sepeda");
        System.out.println("3. Ubah Sepeda");
        System.out.println("4. Hapus Sepeda");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static void tambahSepeda() {
        System.out.print("Masukkan merek: ");
        String merek = scanner.nextLine();
        System.out.print("Masukkan jenis: ");
        String jenis = scanner.nextLine();
        System.out.print("Masukkan harga: ");
        int harga = scanner.nextInt();
        System.out.print("Masukkan stok: ");
        int stok = scanner.nextInt();

        Sepeda sepedaBaru = new Sepeda(merek, jenis, harga, stok);
        daftarSepeda.add(sepedaBaru);

        System.out.println("Sepeda baru telah ditambahkan!");
    }

    private static void lihatDaftarSepeda() {
        if (daftarSepeda.isEmpty()) {
            System.out.println("Daftar sepeda masih kosong!");
        } else {
            for (Sepeda sepeda : daftarSepeda) {
                System.out.println("--------------------");
                System.out.println("Merek: " + sepeda.getMerek());
                System.out.println("Jenis: " + sepeda.getJenis());
                System.out.println("Harga: " + sepeda.getHarga());
                System.out.println("Stok: " + sepeda.getStok());
                System.out.println("--------------------");
            }
        }
    }

    private static void ubahSepeda() {
        System.out.print("Masukkan nomor sepeda yang ingin diubah: ");
        int nomorSepeda = scanner.nextInt();
        scanner.nextLine();  // Menangani karakter newline

        if (nomorSepeda <= 0 || nomorSepeda > daftarSepeda.size()) {
            System.out.println("Nomor sepeda tidak valid!");
            return;
        }

        Sepeda sepeda = daftarSepeda.get(nomorSepeda - 1);

        System.out.print("Masukkan merek baru: ");
        String merekBaru = scanner.nextLine();
        System.out.print("Masukkan jenis baru: ");
        String jenisBaru = scanner.nextLine();
        System.out.print("Masukkan harga baru: ");
        int hargaBaru = scanner.nextInt();
        System.out.print("Masukkan stok baru: ");
        int stokBaru = scanner.nextInt();

        sepeda.setMerek(merekBaru);
        sepeda.setJenis(jenisBaru);
        sepeda.setHarga(hargaBaru);
        sepeda.setStok(stokBaru);

        System.out.println("Sepeda telah diubah!");
    }

    private static void hapusSepeda() {
        System.out.print("Masukkan nomor sepeda yang ingin dihapus: ");
        int nomorSepeda = scanner.nextInt();
        scanner.nextLine();  // Menangani karakter newline

        if (nomorSepeda <= 0 || nomorSepeda > daftarSepeda.size()) {
            System.out.println("Nomor sepeda tidak valid!");
            return;
        }

        daftarSepeda.remove(nomorSepeda - 1);

        System.out.println("Sepeda telah dihapus!");
    }
}

class Sepeda {

    private String merek;
    private String jenis;
    private int harga;
    private int stok;

    public Sepeda(String merek, String jenis, int harga, int stok) {
        this.merek = merek;
        this.jenis = jenis;
        this.harga = harga;
        this.stok = stok;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
