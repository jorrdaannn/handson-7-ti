public class IntroToOOPPractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Introduction to OOP
         *
         * Instruksi: Lengkapi semua latihan di bawah ini untuk memahami
         * perbedaan antara pemrograman prosedural dan object-oriented.
         */

        // ===== SEBELUM OOP: CARA PROSEDURAL =====
        System.out.println("=== SEBELUM OOP: CARA PROSEDURAL ===");

        // Latihan 1: Data mahasiswa dengan variabel terpisah (cara lama)
        // Buat variabel untuk menyimpan data 3 mahasiswa
        // Setiap mahasiswa memiliki: nama, nim, jurusan, ipk

        String namaMhs1 = "Jordan"; // Isi dengan data mahasiswa 1
        String nimMhs1 = "2481033";
        String jurusanMhs1 = "Teknik Informatika";
        double ipkMhs1 = 3.7;

        String namaMhs2 = "Ivan"; // Isi dengan data mahasiswa 2
        String nimMhs2 = "2481051";
        String jurusanMhs2 = "Teknik Informatika";
        double ipkMhs2 = 3.8;

        String namaMhs3 = "Josch"; // Isi dengan data mahasiswa 3
        String nimMhs3 = "2481034";
        String jurusanMhs3 = "Teknik Informatika";
        double ipkMhs3 = 3.5;

        // Print semua data mahasiswa menggunakan cara prosedural
        System.out.println("Mahasiswa 1:");
        System.out.println("Nama: "+namaMhs1);
        System.out.println("NIM: " +nimMhs1);
        System.out.println("Jurusan: "+jurusanMhs1);
        System.out.println("IPK: " + ipkMhs1);
        System.out.println();

        System.out.println("Mahasiswa 2:");
        System.out.println("Nama: "+namaMhs2);
        System.out.println("NIM: " +nimMhs2);
        System.out.println("Jurusan: "+jurusanMhs2);
        System.out.println("IPK: " + ipkMhs2);
        System.out.println();

        System.out.println("Mahasiswa 3:");
        System.out.println("Nama: "+namaMhs3);
        System.out.println("NIM: " +nimMhs3);
        System.out.println("Jurusan: "+jurusanMhs3);
        System.out.println("IPK: " + ipkMhs3);
        System.out.println();



        // Implementasikan printing untuk semua mahasiswa


        System.out.println("\\n=== MASALAH DENGAN CARA PROSEDURAL ===");
        // Tuliskan dalam komentar 3 masalah yang Anda lihat dari cara di atas
        //menulis kode yang sama secra berulang.


        // ===== DENGAN OOP: CARA OBJECT-ORIENTED =====
        System.out.println("\\n=== DENGAN OOP: CARA OBJECT-ORIENTED ===");

        // Latihan 2: Menggunakan class Mahasiswa (akan dibuat di bawah)
        // Buat 3 object Mahasiswa
        // Set data untuk setiap mahasiswa
        // Print menggunakan method dari clas
        // Buat object mahasiswa dan isi datanya
        Mahasiswa mhs1 = new Mahasiswa("Jordan", "2481033","Teknik Informatika",3.7);
        Mahasiswa mhs2 = new Mahasiswa("Ivan", "2481051", "Teknik Informatika", 3.8);
        Mahasiswa mhs3 = new Mahasiswa("Josch", "2481034", "Teknik Informatika", 3.8);
        mhs1.tampilkanInfomhs();
        mhs2.tampilkanInfomhs();
        mhs3.tampilkanInfomhs();


        // ===== ANALOGI DUNIA NYATA =====
        System.out.println("\\n=== ANALOGI DUNIA NYATA ===");

        // Latihan 3: Implementasi analogi perpustakaan
        // Buat beberapa object Buku
        // Buat object Mahasiswa yang meminjam buku
        // Simulasikan proses peminjaman
        Buku buku1 = new Buku("10 Dosa Besar Soeharto", "Ivan", "098765432",1970, true );
        Buku buku2 = new Buku("Basis Data", "mante", "123456789",2021, true);
        Buku buku3 = new Buku("Pelangi", "yonri", "234567890", 2025, true);
        Mahasiswa peminjam = new Mahasiswa("Jordan", "2481014","Teknik Informatika",3.6);
        Perpustakaan perpustakaan = new Perpustakaan("Perpustakaan Kampus", "Jl. Kolonel Masturi*");
        perpustakaan.tambahBuku();
        perpustakaan.tambahBuku();
        perpustakaan.tambahBuku();
        perpustakaan.daftarkanAnggota();
        System.out.println("\ninformasi perpustakaan");
        perpustakaan.tampilkanInfoPerpustakaan();
        System.out.println("\nsimulasi peminjaman");
        buku1.pinjam();
        buku1.tampilkanInfoBuku();
        buku1.kembalikan();
        buku1.tampilkanInfoBuku();
        System.out.println("\nsebelum dipinjam");
        buku1.tampilkanInfoBuku();
        buku2.tampilkanInfoBuku();
        buku3.tampilkanInfoBuku();
        System.out.println("\nproses peminjaman");
        buku1.pinjam();
        buku2.pinjam();
        System.out.println("\nsetelah peminjaman");
        buku1.tampilkanInfoBuku();
        buku2.tampilkanInfoBuku();
        buku3.tampilkanInfoBuku();
        System.out.println("\nproses pengembalian");
        buku1.kembalikan();
        System.out.println("\nsetelah pengembalian");
        buku1.tampilkanInfoBuku();




        // Implementasikan analogi perpustakaan

        // ===== KEUNTUNGAN OOP =====
        System.out.println("\\n=== KEUNTUNGAN OOP ===");
        // Tuliskan dalam komentar 5 keuntungan OOP yang Anda rasakan
        // 1. Kode lebih terstruktur dan mudah dibaca.
        // 2. Reusable — bisa membuat banyak objek dari satu class.
        // 3. Mudah dikembangkan dan dirawat.// 4. Menghindari pengulangan kode.
        // 5. Representasi dunia nyata lebih jelas (buku, mahasiswa, perpustakaan).


    }
}

// ===== DEFINISI CLASS =====

// Buat class Mahasiswa dengan struktur berikut:
class Mahasiswa {
    // Instance variables
    // Definisikan instance variables untuk nama, nim, jurusan, ipk
    String nama;
    String nim;
    String jurusan;
    double ipk;

    // Constructor
    // Buat constructor untuk inisialisasi data mahasiswa
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Methods
    // Buat method untuk menampilkan informasi mahasiswa
    public void tampilkanInfomhs() {
        System.out.println("INFORMASI MAHASISWA");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Jurusan: " + jurusan);
        System.out.println("IPKa: " + ipk);
        System.out.println("Status: " + (isLulus() ? "LULUS" : "TIDAK LULUS"));
        System.out.println("Predikat: " + hitungPredikat());
    }

    // Buat method untuk mengecek apakah mahasiswa lulus (IPK >= 2.75)
    public boolean isLulus() {
        return ipk >= 2.75;
        // Buat method untuk menghitung predikat berdasarkan IPK
    }

    public String hitungPredikat() {
        if (ipk >= 3.75) {
            return "Summa Cum Laude";
        } else if (ipk >= 3.50) {
            return "Magna Cum Laude";
        } else if (ipk >= 3.00) {
            return "Cum Laude";
        } else if (ipk >= 2.75) {
            return "Memuaskan";
        } else {
            return "Tidak Lulus";
        }
    }
}

// Buat class Buku dengan struktur berikut:
class Buku {
    // Instance variables
    // Definisikan variables untuk judul, penulis, isbn, tahunTerbit, tersedia
    String judul;
    String penulis;
    String isbn;
    int tahunTerbit;
    boolean tersedia;

    // Constructor
    public Buku(String judul, String penulis, String isbn, int tahunTerbit, boolean tersedia) {
        this.judul = judul;
        this.penulis = penulis;
        this.isbn = isbn;
        this.tahunTerbit = tahunTerbit;
        this.tersedia = tersedia;
    }

    // Buat constructor
    public void tampilkanInfoBuku() {
        System.out.println("Judul: " + judul + " | Penulis: " + penulis +
                " | ISBN: " + isbn + " | Tahun: " + tahunTerbit +
                " | Status: " + (tersedia ? "Tersedia" : "Dipinjam"));
    }


    // Methods
    // Buat method untuk menampilkan info buku
    // Buat method untuk meminjam buku
    // Buat method untuk mengembalikan buku
    public void pinjam(){
        if (tersedia){
            tersedia=false;
            System.out.println("Buku '" + judul + "' berhasil dipinjam.");
        }else {
            System.out.println("Maaf, buku '" + judul + "' sedang dipinjam.");
        }
    }
    public void kembalikan(){
        if (!tersedia){
            tersedia=true;
            System.out.println("Buku '" + judul + "' berhasil dikembalikan.");
        }else{
            System.out.println("Buku '" + judul + "' sudah tersedia.");
        }
    }
}

// Buat class Perpustakaan yang mengelola buku dan peminjaman
class Perpustakaan {
    // Implementasikan class perpustakaan
    String namaPerpustakaan;
    String alamat;
    int jumlahBuku;
    int jumlahAnggota;

    public Perpustakaan(String nama, String alamat) {
        this.namaPerpustakaan = nama;
        this.alamat = alamat;
        this.jumlahBuku = 0;
        this.jumlahAnggota = 0;
    }
public void tambahBuku(){
        jumlahBuku++;
        System.out.println("Buku baru ditambahkan. total buku: "+jumlahBuku);
}
    public void daftarkanAnggota() {
        jumlahAnggota++;
        System.out.println("Anggota baru terdaftar. Total anggota: " + jumlahAnggota);

}
public void tampilkanInfoPerpustakaan(){
    System.out.println("Perpustakaan: " + namaPerpustakaan);
    System.out.println("Alamat: " + alamat);
    System.out.println("Jumlah Buku: " + jumlahBuku);
    System.out.println("Jumlah Anggota: " + jumlahAnggota);
    }
}
