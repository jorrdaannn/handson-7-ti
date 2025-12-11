import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Comprehensive OOP Project
         *
         * Instruksi: Implementasikan sistem manajemen perpustakaan lengkap
         * yang menerapkan semua konsep OOP yang telah dipelajari.
         */

        // ===== SETUP LIBRARY SYSTEM =====
        System.out.println("=== LIBRARY MANAGEMENT SYSTEM ===");

        // Latihan 1: Setup library dengan berbagai tipe buku dan member
        // Buat library instance
        Library perpustakaan=new Library("Perpustakaan kota", 3,14);
        // Tambahkan berbagai buku
        perpustakaan.addBook(new Book("978-001", "Laskar Pelangi", "Andrea Hirata", "Bentang", 2005, BookCategory.FICTION));
        perpustakaan.addBook(new Book("978-002", "Bumi Manusia", "Pramoedya", "Hasta Mitra", 1980, BookCategory.FICTION));
        perpustakaan.addBook(new Book("978-003", "Sapiens", "Yuval Harari", "Gramedia", 2015, BookCategory.SCIENCE));
        perpustakaan.addBook(new Book("978-004", "Sejarah Indonesia", "Ricklefs", "UI Press", 1990, BookCategory.HISTORY));

        // Daftarkan beberapa member
        perpustakaan.registerMember(new Member("M001", "jordan", "jordan@email.com", "08123456789", "Jl. Merdeka 1", MembershipType.STUDENT));
        perpustakaan.registerMember(new Member("M002", "ivan", "ivan@email.com", "08198765432", "Jl. Sudirman 5", MembershipType.FACULTY));
        perpustakaan.registerMember(new Member("M003", "Josch", "josch@email.com", "08111222333", "Jl. Asia Afrika 10", MembershipType.PUBLIC));


        // ===== BOOK OPERATIONS =====
        System.out.println("\\n=== BOOK OPERATIONS ===");

        // Latihan 2: Operasi buku
        // Tambah buku baru
        // Cari buku berdasarkan kriteria
        // Update informasi buku
        System.out.println("Mencari buku dengan kata 'Bumi':");
        ArrayList<Book> hasilCari = perpustakaan.searchBooks("Bumi");
        for (Book b : hasilCari) {
            b.displayBookInfo();
        }
        System.out.println("\nBuku yang tersedia:");
        ArrayList<Book> bukuTersedia = perpustakaan.getAvailableBooks();
        System.out.println("Total buku tersedia: " + bukuTersedia.size());

        // ===== MEMBER OPERATIONS =====
        System.out.println("\\n=== MEMBER OPERATIONS ===");

        // Latihan 3: Operasi member
        // Registrasi member baru
        // Update informasi member
        // Cek status member
        Member member1 = perpustakaan.getMemberById("M001");
        if (member1 != null) {
            System.out.println("Informasi Member:");
            System.out.println("Nama: " + member1.getName());
            System.out.println("Tipe: " + member1.getMembershipType());
            System.out.println("Lama keanggotaan: " + member1.calculateMembershipDuration() + " hari");
            System.out.println("Bisa pinjam lagi? " + (member1.canBorrowMore(3) ? "Ya" : "Tidak"));
        }


        // ===== BORROWING SYSTEM =====
        System.out.println("\\n=== BORROWING SYSTEM ===");

        // Latihan 4: Sistem peminjaman
        // Pinjam buku
        boolean berhasilPinjam = perpustakaan.borrowBook("M001", "978-001");
        if (berhasilPinjam) {
            System.out.println("Peminjaman buku berhasil!");
        }

        perpustakaan.borrowBook("M002", "978-003");
        perpustakaan.borrowBook("M001", "978-002");
        // Kembalikan buku
        // Cek denda
        // Perpanjang peminjaman
        BorrowRecord record = perpustakaan.borrowRecords.get(0);
        record.setDueDate(LocalDate.now().minusDays(5)); // mundurkan tanggal jatuh tempo


        System.out.println("\nCek denda untuk peminjaman pertama:");
        double denda = perpustakaan.calculateFine(record.getRecordId());
        System.out.println("Denda: Rp " + denda);


        System.out.println("\nMengembalikan buku...");
        perpustakaan.returnBook(record.getRecordId());

        // ===== REPORTING =====
        System.out.println("\\n=== REPORTING ===");

        // Latihan 5: Sistem reporting
        // Laporan buku terpopuler
        perpustakaan.generatePopularBooksReport();
        // Laporan member aktif
        perpustakaan.generateActiveMembersReport();
        // Laporan denda
        // Statistik perpustakaan
        System.out.println("\n=== LIBRARY STATISTICS ===");
        perpustakaan.displayLibraryStats();

        // ===== ADMIN FUNCTIONS =====
        System.out.println("\\n=== ADMIN FUNCTIONS ===");
        System.out.println("Melakukan backup data...");
        perpustakaan.backup();

        System.out.println("\nMelakukan maintenance...");
        perpustakaan.maintenance();
    }
}



// Latihan 6: Fungsi admin
        // Backup data
        // Generate reports
        // System maintenance
// Enum untuk kategori buku
enum BookCategory {
    FICTION, NON_FICTION, SCIENCE, HISTORY, BIOGRAPHY, TECHNOLOGY, ARTS
}

// Enum untuk tipe membership
enum MembershipType {
    STUDENT(5), FACULTY(10), PUBLIC(3);

    private int maxBooks;

    MembershipType(int maxBooks) {
        this.maxBooks = maxBooks;
    }

    public int getMaxBooks() {
        return maxBooks;
    }
}



// ===== CLASS DEFINITIONS =====

// Implementasikan class Book dengan encapsulation lengkap
class Book {
    // Private instance variables
    // isbn, title, author, publisher, yearPublished, category, isAvailable, borrowCount
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int yearPublished;
    private BookCategory category;
    private boolean isAvailable;
    private int borrowCount;

    private static int totalBooks = 0;

    public Book(String isbn, String title, String author, String publisher, int yearPublished, BookCategory category) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.category = category;
        this.isAvailable = true;
        this.borrowCount = 0;
        totalBooks++;
    }

    // Static variables
    // static int totalBooks

    // Constructors dengan overloading
    // Multiple constructors

    // Getter/Setter dengan validation
    // All getters and setters dengan appropriate validation
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }
    public int getYearPublished() { return yearPublished; }
    public BookCategory getCategory() { return category; }
    public boolean isAvailable() { return isAvailable; }
    public int getBorrowCount() { return borrowCount; }
    public static int getTotalBooks() { return totalBooks; }
    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
    }

    public void setAuthor(String author) {
        if (author != null && !author.isEmpty()) {
            this.author = author;
        }
    }

    public void setPublisher(String publisher) {
        if (publisher != null && !publisher.isEmpty()) {
            this.publisher = publisher;
        }
    }

    public void setYearPublished(int year) {
        if (year > 1000 && year <= LocalDate.now().getYear()) {
            this.yearPublished = year;
        }
    }

    // Business methods
    // borrowBook(), returnBook(), getPopularityScore()

    // Utility methods
    // displayBookInfo(), isClassic(), getAgeInYears()
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            borrowCount++;
        }
    }

    public void returnBook() {
        isAvailable = true;
    }

    public int getPopularityScore() {
        return borrowCount * 10;
    }

    public void displayBookInfo() {
        System.out.println("---");
        System.out.println("ISBN: " + isbn);
        System.out.println("Judul: " + title);
        System.out.println("Pengarang: " + author);
        System.out.println("Penerbit: " + publisher);
        System.out.println("Tahun: " + yearPublished);
        System.out.println("Kategori: " + category);
        System.out.println("Status: " + (isAvailable ? "Tersedia" : "Dipinjam"));
        System.out.println("Dipinjam: " + borrowCount + " kali");
    }

    public boolean isClassic() {
        return LocalDate.now().getYear() - yearPublished >= 25;
    }

    public int getAgeInYears() {
        return LocalDate.now().getYear() - yearPublished;
    }
}



// Implementasikan class Member
class Member {
    // Private instance variables
    // memberId, name, email, phone, address, joinDate, membershipType, isActive
    private String memberId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private LocalDate joinDate;
    private MembershipType membershipType;
    private boolean isActive;
    private int currentBorrowCount;

    // Static variables
    // static int totalMembers, static final int MAX_BOOKS_ALLOWED
    private static int totalMembers = 0;
    private static final int MAX_BOOKS_ALLOWED = 10;

    // Constructors
    // Constructor dengan validation

    public Member(String memberId, String name, String email, String phone, String address, MembershipType membershipType) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.joinDate = LocalDate.now();
        this.membershipType = membershipType;
        this.isActive = true;
        this.currentBorrowCount = 0;
        totalMembers++;
    }

    // Getter/Setter
    // With appropriate validation
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public LocalDate getJoinDate() { return joinDate; }
    public MembershipType getMembershipType() { return membershipType; }
    public boolean isActive() { return isActive; }
    public int getCurrentBorrowCount() { return currentBorrowCount; }
    public static int getTotalMembers() { return totalMembers; }
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setEmail(String email) {
        if (LibraryUtils.isValidEmail(email)) {
            this.email = email;
        }
    }

    public void setPhone(String phone) {
        if (phone != null && phone.length() >= 10) {
            this.phone = phone;
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public void incrementBorrowCount() {
        currentBorrowCount++;
    }

    public void decrementBorrowCount() {
        if (currentBorrowCount > 0) {
            currentBorrowCount--;
        }
    }

    // Business methods
    // canBorrowMore(), calculateMembershipDuration(), upgradeMembership()
    public boolean canBorrowMore(int maxAllowed) {
        return currentBorrowCount < maxAllowed && currentBorrowCount < membershipType.getMaxBooks();
    }

    public long calculateMembershipDuration() {
        return ChronoUnit.DAYS.between(joinDate, LocalDate.now());
    }

    public void upgradeMembership(MembershipType newType) {
        this.membershipType = newType;
        System.out.println("Membership upgraded to: " + newType);
    }
}


// Implementasikan class BorrowRecord
class BorrowRecord {
    // Private variables
    // recordId, memberId, isbn, borrowDate, dueDate, returnDate, fine
    private String recordId;
    private String memberId;
    private String isbn;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fine;


    // Static variables
    // static int totalRecords
    private static int totalRecords = 0;
    public BorrowRecord(String memberId, String isbn, int loanPeriodDays) {
        this.recordId = "BR" + String.format("%04d", ++totalRecords);
        this.memberId = memberId;
        this.isbn = isbn;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(loanPeriodDays);
        this.returnDate = null;
        this.fine = 0.0;
    }
    // Constructor
    // Constructor dengan auto-calculation due date
    // Getters
    public String getRecordId() { return recordId; }
    public String getMemberId() { return memberId; }
    public String getIsbn() { return isbn; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public double getFine() { return fine; }

    // Setter untuk testing
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


    // Methods
    // calculateFine(), isOverdue(), returnBook(), extendLoan()
    public double calculateFine(double finePerDay) {
        if (returnDate != null) {
            long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
            if (daysLate > 0) {
                fine = daysLate * finePerDay;
            }
        } else {
            long daysLate = ChronoUnit.DAYS.between(dueDate, LocalDate.now());
            if (daysLate > 0) {
                fine = daysLate * finePerDay;
            }
        }
        return fine;
    }

    public boolean isOverdue() {
        if (returnDate != null) {
            return returnDate.isAfter(dueDate);
        }
        return LocalDate.now().isAfter(dueDate);
    }

    public void returnBook() {
        this.returnDate = LocalDate.now();
    }

    public boolean extendLoan(int additionalDays) {
        if (returnDate == null && !isOverdue()) {
            dueDate = dueDate.plusDays(additionalDays);
            return true;
        }
        return false;
    }
}

// Implementasikan class Library
class Library {
    // Private variables untuk collections
    // ArrayList<Book> books, ArrayList<Member> members, ArrayList<BorrowRecord> borrowRecords
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    ArrayList<BorrowRecord> borrowRecords;


    // Static variables
    // static String libraryName, static final double FINE_PER_DAY
    private static String libraryName;
    private static final double FINE_PER_DAY = 1000.0;

    // Private variables untuk business logic
    // maxBooksPerMember, loanPeriodDays
    private int maxBooksPerMember;
    private int loanPeriodDays;


    // Constructor
    // Initialize collections dan set library parameters
    public Library(String name, int maxBooks, int loanDays) {
        libraryName = name;
        this.maxBooksPerMember = maxBooks;
        this.loanPeriodDays = loanDays;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.borrowRecords = new ArrayList<>();
    }

    // Book management methods
    // addBook(), removeBook(), searchBooks(), getAvailableBooks()
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Buku ditambahkan: " + book.getTitle());
    }

    public boolean removeBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.remove(i);
                System.out.println("Buku dihapus dengan ISBN: " + isbn);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Book> searchBooks(String keyword) {
        ArrayList<Book> hasil = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                hasil.add(book);
            }
        }
        return hasil;
    }

    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> tersedia = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                tersedia.add(book);
            }
        }
        return tersedia;
    }


    // Member management methods
    // registerMember(), updateMember(), getMemberById(), getActiveMembers()
    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Member terdaftar: " + member.getName());
    }

    public Member getMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    public ArrayList<Member> getActiveMembers() {
        ArrayList<Member> aktif = new ArrayList<>();
        for (Member member : members) {
            if (member.isActive()) {
                aktif.add(member);
            }
        }
        return aktif;
    }

    // Borrowing methods
    // borrowBook(), returnBook(), extendLoan(), calculateFine()
    public boolean borrowBook(String memberId, String isbn) {
        Member member = getMemberById(memberId);
        if (member == null || !member.isActive()) {
            System.out.println("Member tidak valid atau tidak aktif");
            return false;
        }

        if (!member.canBorrowMore(maxBooksPerMember)) {
            System.out.println("Member sudah mencapai batas peminjaman");
            return false;
        }

        Book book = null;
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                book = b;
                break;
            }
        }

        if (book == null || !book.isAvailable()) {
            System.out.println("Buku tidak tersedia");
            return false;
        }

        book.borrowBook();
        member.incrementBorrowCount();
        BorrowRecord record = new BorrowRecord(memberId, isbn, loanPeriodDays);
        borrowRecords.add(record);

        System.out.println("Buku berhasil dipinjam: " + book.getTitle());
        System.out.println("Tanggal kembali: " + record.getDueDate());
        return true;
    }

    public boolean returnBook(String recordId) {
        for (BorrowRecord record : borrowRecords) {
            if (record.getRecordId().equals(recordId) && record.getReturnDate() == null) {
                record.returnBook();
                double denda = record.calculateFine(FINE_PER_DAY);

                for (Book book : books) {
                    if (book.getIsbn().equals(record.getIsbn())) {
                        book.returnBook();
                        break;
                    }
                }

                Member member = getMemberById(record.getMemberId());
                if (member != null) {
                    member.decrementBorrowCount();
                }

                System.out.println("Buku dikembalikan. Denda: Rp " + denda);
                return true;
            }
        }
        return false;
    }

    public double calculateFine(String recordId) {
        for (BorrowRecord record : borrowRecords) {
            if (record.getRecordId().equals(recordId)) {
                return record.calculateFine(FINE_PER_DAY);
            }
        }
        return 0.0;
    }

    // Reporting methods
    // generatePopularBooksReport(), generateActiveMembersReport(), generateOverdueReport()

    // Utility methods
    // displayLibraryStats(), backup(), maintenance()

    // Private helper methods
    // private boolean isValidMember(), private boolean isBookAvailable()
    public void generatePopularBooksReport() {
        System.out.println("\n--- LAPORAN BUKU POPULER ---");
        ArrayList<Book> sortedBooks = new ArrayList<>(books);

        // Simple bubble sort berdasarkan borrow count
        for (int i = 0; i < sortedBooks.size() - 1; i++) {
            for (int j = 0; j < sortedBooks.size() - i - 1; j++) {
                if (sortedBooks.get(j).getBorrowCount() < sortedBooks.get(j + 1).getBorrowCount()) {
                    Book temp = sortedBooks.get(j);
                    sortedBooks.set(j, sortedBooks.get(j + 1));
                    sortedBooks.set(j + 1, temp);
                }
            }
        }

        int count = 0;
        for (Book book : sortedBooks) {
            if (count >= 5) break;
            System.out.println((count + 1) + ". " + book.getTitle() + " - Dipinjam " + book.getBorrowCount() + " kali");
            count++;
        }
    }

    public void generateActiveMembersReport() {
        System.out.println("\n--- LAPORAN MEMBER AKTIF ---");
        ArrayList<Member> aktif = getActiveMembers();
        System.out.println("Total member aktif: " + aktif.size());
        for (Member member : aktif) {
            System.out.println("- " + member.getName() + " (" + member.getMembershipType() + ") - Meminjam: " + member.getCurrentBorrowCount() + " buku");
        }
    }

    public void displayLibraryStats() {
        System.out.println("Nama Perpustakaan: " + libraryName);
        System.out.println("Total Buku: " + books.size());
        System.out.println("Total Member: " + members.size());
        System.out.println("Total Peminjaman: " + borrowRecords.size());
        System.out.println("Buku Tersedia: " + getAvailableBooks().size());
    }

    public void backup() {
        System.out.println("Backup data perpustakaan...");
        System.out.println("- " + books.size() + " buku");
        System.out.println("- " + members.size() + " member");
        System.out.println("- " + borrowRecords.size() + " record peminjaman");
        System.out.println("Backup selesai!");
    }

    public void maintenance() {
        System.out.println("Menjalankan maintenance...");
        System.out.println("- Checking data integrity");
        System.out.println("- Cleaning old records");
        System.out.println("- Updating statistics");
        System.out.println("Maintenance selesai!");
    }
}


// Implementasikan class LibraryUtils (static utility class)
class LibraryUtils {
    // Constants
    // static final variables untuk berbagai konstanta
    private static final String ISBN_PREFIX = "978";
    private static final int MIN_ISBN_LENGTH = 10;

    // Static utility methods
    // static boolean isValidISBN(), static boolean isValidEmail()
    // static String formatDate(), static double calculateLateFee()

    // Private constructor
    // private LibraryUtils() { }
    private LibraryUtils() {
        // Private constructor
    }
    public static boolean isValidISBN(String isbn) {
        if (isbn == null || isbn.length() < MIN_ISBN_LENGTH) {
            return false;
        }
        return isbn.startsWith(ISBN_PREFIX);
    }

    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }

    public static String formatDate(LocalDate date) {
        return date.toString();
    }

    public static double calculateLateFee(int daysLate, double feePerDay) {
        if (daysLate <= 0) {
            return 0.0;
        }
        return daysLate * feePerDay;
    }
}


