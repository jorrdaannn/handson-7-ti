public class AccessModifiersPractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Access Modifiers & Encapsulation
         *
         * Instruksi: Lengkapi semua latihan di bawah ini untuk menguasai
         * access modifiers, encapsulation, dan data protection.
         */

        // ===== MASALAH DENGAN PUBLIC VARIABLES =====
        System.out.println("=== MASALAH DENGAN PUBLIC VARIABLES ===");

        // Latihan 1: Tunjukkan masalah dengan public instance variables
        // Buat object dengan public variables
        // Tunjukkan bagaimana data bisa dirusak dari luar

        // Demonstrasikan masalah public variables
        BadExample bad = new BadExample("Jordan", 20, 5000000, "girsang@email.com");
        System.out.println("Data awal:");
        bad.displayInfo();

        System.out.println("\nMengubah data secara langsung (tanpa validasi):");
        bad.age = -5;
        bad.salary = -1000000;
        bad.email = "email_tidak_valid";
        bad.name = "";

        System.out.println("\nData setelah dirusak:");
        bad.displayInfo();
        System.out.println("^ DATA RUSAK! Tidak ada validasi!");


        // ===== ENCAPSULATION SOLUTION =====
        System.out.println("\\n=== ENCAPSULATION SOLUTION ===");

        // Latihan 2: Implementasi encapsulation
        // Gunakan private variables dengan getter/setter
        // Tambahkan validasi dalam setter

        // Demonstrasikan encapsulation dengan class yang proper
        GoodExample good = new GoodExample("Jordan", 30, 7000000, "jordan@email.com");
        System.out.println("Data awal:");
        System.out.println("Name: " + good.getName());
        System.out.println("Age: " + good.getAge());
        System.out.println("Salary: " + good.getSalary());
        System.out.println("Email: " + good.getEmail());

        System.out.println("\nMencoba mengubah data dengan nilai tidak valid:");
        good.setAge(-5);  // Ditolak!
        good.setSalary(-1000000);  // Ditolak!
        good.setEmail("email_tidak_valid");  // Ditolak!
        good.setName("");  // Ditolak!

        System.out.println("\nData tetap aman:");
        System.out.println("Name: " + good.getName());
        System.out.println("Age: " + good.getAge());
        System.out.println("Salary: " + good.getSalary());
        System.out.println("Email: " + good.getEmail());

        System.out.println("\nMengubah dengan nilai valid:");
        good.setAge(35);
        good.setSalary(8000000);
        good.setEmail("jordan.new@email.com");
        System.out.println("Age: " + good.getAge());
        System.out.println("Salary: " + good.getSalary());
        System.out.println("Email: " + good.getEmail());

        // ===== ACCESS MODIFIER COMBINATIONS =====
        System.out.println("\\n=== ACCESS MODIFIER COMBINATIONS ===");

        // Latihan 3: Berbagai kombinasi access modifiers
        // Tunjukkan perbedaan private, public, protected, default

        // Implementasikan class dengan berbagai access modifiers
        AccessModifierDemo demo = new AccessModifierDemo();

        System.out.println("Mengakses dari main method (class yang sama/package yang sama):");
        System.out.println("Public field: " + demo.publicField);
        demo.publicMethod();
        System.out.println("Default field: " + demo.defaultField);
        demo.defaultMethod();
        System.out.println("Protected field: " + demo.protectedField);
        demo.protectedMethod();
        System.out.println("Private field: TIDAK BISA DIAKSES langsung dari luar class");

        System.out.println("\nTest akses dari dalam class:");
        demo.testAccess();



        // ===== GETTER/SETTER BEST PRACTICES =====
        System.out.println("\\n=== GETTER/SETTER BEST PRACTICES ===");

        // Latihan 4: Implementasi getter/setter yang proper
        // Naming conventions
        // Validation dalam setter
        // Read-only dan write-only properties

        // Implementasikan getter/setter yang proper
        BankAccountSecure account = new BankAccountSecure("ACC001", 1000000, "1234");

        System.out.println("Account Number (Read-only): " + account.getAccountNumber());
        System.out.println("Account Status: " + account.getAccountStatus());

        System.out.println("\nMelakukan deposit:");
        account.deposit(500000);

        System.out.println("\nCheck balance dengan PIN benar:");
        account.checkBalance("1234");

        System.out.println("\nCheck balance dengan PIN salah:");
        account.checkBalance("0000");

        System.out.println("\nWithdraw dengan PIN benar:");
        account.withdraw(200000, "1234");

        System.out.println("\nWithdraw dengan PIN salah:");
        account.withdraw(100000, "9999");

        System.out.println("\nGanti PIN:");
        account.changePin("1234", "5678");

        System.out.println("\nCheck balance dengan PIN baru:");
        account.checkBalance("5678");

        System.out.println("\nSet security level (Write-only):");
        account.setSecurityLevel(3);
    }
}

// ===== CLASS DEFINITIONS =====

// Implementasikan class BadExample (dengan public variables)
class BadExample {
    // Semua variables public - tunjukkan masalahnya
    public String name;
    public int age;
    public double salary;
    public String email;

    // Constructor sederhana
    public BadExample(String name, int age, double salary, String email) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.email = email;
    }

    // Method untuk menunjukkan data corruption
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Email: " + email);
    }
}

// Implementasikan class GoodExample (dengan encapsulation)
class GoodExample {
    // Private instance variables
    // private String name, age, salary, email
    private String name;
    private int age;
    private double salary;
    private String email;

    // Constructor
    // Constructor dengan parameter validation
    public GoodExample(String name, int age, double salary, String email) {
        setName(name);
        setAge(age);
        setSalary(salary);
        setEmail(email);
    }

    // Getter methods
    // Implementasikan getter methods yang proper
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    // Setter methods dengan validation
    // setName() - tidak boleh null/kosong
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("ERROR: Name tidak boleh kosong!");
            return;
        }
        this.name = name;
    }
    // setAge() - harus antara 17-65
    public void setAge(int age) {
        if (age < 17 || age > 65) {
            System.out.println("ERROR: Age harus antara 17-65!");
            return;
        }
        this.age = age;
    }
    // setSalary() - harus positif
    public void setSalary(double salary) {
        if (salary < 0) {
            System.out.println("ERROR: Salary harus positif!");
            return;
        }
        this.salary = salary;
    }

    // setEmail() - format email yang valid
    public void setEmail(String email) {
        if (!validateEmail(email)) {
            System.out.println("ERROR: Format email tidak valid!");
            return;
        }
        this.email = email;
    }

    // Business methods
    // validateEmail(String email)
    // isRetirementAge()
    // calculateTax()
    private boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }

    public boolean isRetirementAge() {
        return age >= 55;
    }

    public double calculateTax() {
        if (salary < 5000000) {
            return salary * 0.05;
        } else if (salary < 10000000) {
            return salary * 0.15;
        } else {
            return salary * 0.25;
        }
    }
}

// Implementasikan class BankAccountSecure
class BankAccountSecure {
    // Private variables
    // accountNumber, balance, pin, isLocked
    private String accountNumber;
    private double balance;
    private String pin;
    private boolean isLocked;
    private int securityLevel;
    private int failedAttempts;

    // Constructor
    // Constructor dengan validation
    public BankAccountSecure(String accountNumber, double balance, String pin) {
        this.accountNumber = accountNumber;
        this.balance = balance >= 0 ? balance : 0;
        this.pin = pin;
        this.isLocked = false;
        this.securityLevel = 1;
        this.failedAttempts = 0;
    }

    // Public interface methods
    // deposit(double amount)
    // withdraw(double amount, String pin)
    // checkBalance(String pin)
    // changePin(String oldPin, String newPin)
    public void deposit(double amount) {
        if (isLocked) {
            System.out.println("Account terkunci!");
            return;
        }

        if (!isValidAmount(amount)) {
            System.out.println("Jumlah deposit tidak valid!");
            return;
        }

        balance += amount;
        System.out.println("Deposit berhasil: Rp " + amount);
        System.out.println("Saldo sekarang: Rp " + balance);
    }

    public void withdraw(double amount, String pin) {
        if (isLocked) {
            System.out.println("Account terkunci!");
            return;
        }

        if (!validatePin(pin)) {
            return;
        }

        if (!isValidAmount(amount)) {
            System.out.println("Jumlah withdraw tidak valid!");
            return;
        }

        if (amount > balance) {
            System.out.println("Saldo tidak cukup!");
            return;
        }

        balance -= amount;
        System.out.println("Withdraw berhasil: Rp " + amount);
        System.out.println("Saldo sekarang: Rp " + balance);
    }

    public void checkBalance(String pin) {
        if (isLocked) {
            System.out.println("Account terkunci!");
            return;
        }

        if (!validatePin(pin)) {
            return;
        }

        System.out.println("Saldo Anda: Rp " + balance);
        failedAttempts = 0;  // Reset failed attempts
    }

    public void changePin(String oldPin, String newPin) {
        if (isLocked) {
            System.out.println("Account terkunci!");
            return;
        }

        if (!validatePin(oldPin)) {
            return;
        }

        if (newPin == null || newPin.length() < 4) {
            System.out.println("PIN baru harus minimal 4 digit!");
            return;
        }

        this.pin = newPin;
        System.out.println("PIN berhasil diubah!");
        failedAttempts = 0;
    }

    // Private helper methods
    // private boolean validatePin(String pin)
    // private void lockAccount()
    // private boolean isValidAmount(double amount)

    // Read-only properties
    // getAccountNumber() - tanpa setter
    // getAccountStatus()
    private boolean validatePin(String pin) {
        if (!this.pin.equals(pin)) {
            failedAttempts++;
            System.out.println("PIN salah! Percobaan ke-" + failedAttempts);

            if (failedAttempts >= 3) {
                lockAccount();
            }
            return false;
        }
        return true;
    }

    private void lockAccount() {
        isLocked = true;
        System.out.println("ACCOUNT DIKUNCI karena terlalu banyak percobaan salah!");
    }

    private boolean isValidAmount(double amount) {
        return amount > 0;
    }

    // Read-only properties (getter tanpa setter)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountStatus() {
        if (isLocked) {
            return "LOCKED";
        } else if (balance < 50000) {
            return "LOW BALANCE";
        } else {
            return "ACTIVE";
        }
    }

    // Write-only properties (jarang digunakan)
    // setSecurityLevel(int level) - tanpa getter
    public void setSecurityLevel(int level) {
        if (level >= 1 && level <= 5) {
            this.securityLevel = level;
            System.out.println("Security level diset ke: " + level);
        } else {
            System.out.println("Security level harus antara 1-5!");
        }
    }
}

// Implementasikan class AccessModifierDemo
class AccessModifierDemo {
    private String privateField = "Private";
    protected String protectedField = "Protected";
    String defaultField = "Default";
    public String publicField = "Public";

    private void privateMethod() {
        System.out.println("Private method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    void defaultMethod() {
        System.out.println("Default method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    // Method untuk test accessibility dari dalam class
    public void testAccess() {
        // Panggil semua methods dan akses semua fields
        System.out.println("Dari dalam class, semua bisa diakses:");
        System.out.println("Private field: " + privateField);
        System.out.println("Protected field: " + protectedField);
        System.out.println("Default field: " + defaultField);
        System.out.println("Public field: " + publicField);

        privateMethod();
        protectedMethod();
        defaultMethod();
        publicMethod();
    }
}
