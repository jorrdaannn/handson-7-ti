import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class InstanceMembersPractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Instance Variables & Methods
         *
         * Instruksi: Lengkapi semua latihan di bawah ini untuk menguasai
         * instance variables, instance methods, dan perbedaannya dengan static.
         */

        // ===== INSTANCE VARIABLES BASICS =====
        System.out.println("=== INSTANCE VARIABLES BASICS ===");

        // Latihan 1: Memahami instance variables
        // Buat beberapa object dari class BankAccount
        // Tunjukkan bahwa setiap object memiliki data sendiri

        // Buat 3 object BankAccount dengan data berbeda
        BankAccount account1 = new BankAccount("001", "Jordan", 5000000, "Savings");
        BankAccount account2 = new BankAccount("002", "Ivan", 6000000, "Current");
        BankAccount account3 = new BankAccount("003", "Josch", 7000000, "Savings");

        // Tampilkan saldo masing-masing account
        // Tunjukkan bahwa perubahan pada satu object tidak mempengaruhi yang lain

        System.out.println("\nSaldo Awal:");
        account1.displayBalance();
        account2.displayBalance();
        account3.displayBalance();

        // Lakukan transaksi pada masing-masing account
        System.out.println("\nTransaksi:");
        account1.deposit(1000000);
        account2.withdraw(2000000);
        account3.deposit(500000);

        System.out.println("\nSaldo setelah transaksi:");
        account1.displayBalance();
        account2.displayBalance();
        account3.displayBalance();

        // ===== INSTANCE METHODS ADVANCED =====
        System.out.println("\n=== INSTANCE METHODS ADVANCED ===");

        // Latihan 2: Instance methods yang bekerja dengan instance variables
        // Implementasikan berbagai jenis instance methods
        // Methods yang mengubah state object
        // Methods yang mengembalikan nilai berdasarkan state
        // Methods yang berinteraksi dengan object lain

        // Demonstrasikan berbagai jenis instance methods
        System.out.println("\n1. Methods yang mengubah state:");
        account1.calculateInterest(0.05);
        account1.displayBalance();

        System.out.println("\n2. Methods yang mengembalikan nilai:");
        System.out.println("Status Account 1: " + account1.getAccountStatus());
        System.out.println("Info Account 2: " + account2.getAccountInfo());

        System.out.println("\n3. Methods dengan validasi:");
        boolean canWithdraw = account3.canWithdraw(5000000);
        System.out.println("Account 3 dapat withdraw 5 juta? " + canWithdraw);

        // ===== METHOD INTERACTION =====
        System.out.println("\n=== METHOD INTERACTION ===");

        // Latihan 3: Methods yang memanggil methods lain
        // Buat methods yang memanggil methods lain dalam class yang sama
        // Demonstrasikan method chaining

        // Implementasikan method chaining dan interaction
        System.out.println("\nCetak statement Account 1:");
        account1.printStatement();

        System.out.println("\nAktivasi dan Deaktivasi Account:");
        account3.deactivateAccount();
        System.out.println("Status setelah deaktivasi: " + account3.getAccountStatus());
        account3.activateAccount();
        System.out.println("Status setelah aktivasi: " + account3.getAccountStatus());

        // ===== OBJECT COLLABORATION =====
        System.out.println("\n=== OBJECT COLLABORATION ===");

        // Latihan 4: Object yang berinteraksi dengan object lain
        // Implementasikan transfer uang antar account
        // Buat history transaksi

        // Implementasikan object collaboration
        System.out.println("\nTransfer antar Account:");
        System.out.println("Sebelum Transfer:");
        account1.displayBalance();
        account2.displayBalance();

        account1.transfer(account2, 1500000);

        System.out.println("\nSetelah Transfer:");
        account1.displayBalance();
        account2.displayBalance();

        System.out.println("\n=== CUSTOMER WITH MULTIPLE ACCOUNTS ===");
        Customer customer = new Customer("C001", "Dina Mariana", "081234567890", "dina@email.com");
        customer.addAccount(account1);
        customer.addAccount(account3);

        System.out.println("\nCustomer Info:");
        customer.displayCustomerInfo();
        System.out.println("\nTotal Saldo Customer: Rp " + customer.getTotalBalance());
    }
}

// ===== CLASS DEFINITIONS =====

// Class BankAccount
class BankAccount {
    // Instance variables
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;
    private boolean isActive;
    private ArrayList<Transaction> transactions;

    // Constructor lengkap dengan 4 parameter
    public BankAccount(String accountNumber, String accountHolderName, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
        this.isActive = true;
        this.transactions = new ArrayList<>();

        Transaction openTrans = new Transaction("OPEN", balance, "Account Opening");
        transactions.add(openTrans);
    }

    // Constructor 2: Tanpa accountType (default ke Savings)
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this(accountNumber, accountHolderName, balance, "Savings");
    }

    // Constructor 3: Constructor minimal
    public BankAccount(String accountNumber, String accountHolderName) {
        this(accountNumber, accountHolderName, 0, "Savings");
    }

    // Instance methods untuk account operations
    public void deposit(double amount) {
        if (!isActive) {
            System.out.println("Account tidak aktif. Tidak dapat melakukan deposit.");
            return;
        }

        if (amount <= 0) {
            System.out.println("Jumlah deposit harus lebih dari 0.");
            return;
        }

        balance += amount;
        Transaction trans = new Transaction("DEPOSIT", amount, "Deposit to account");
        transactions.add(trans);
        System.out.println("Deposit berhasil: Rp " + amount);
    }

    public boolean withdraw(double amount) {
        if (!isActive) {
            System.out.println("Account tidak aktif. Tidak dapat melakukan withdraw.");
            return false;
        }

        if (!canWithdraw(amount)) {
            System.out.println("Withdraw gagal: Saldo tidak mencukupi.");
            return false;
        }

        if (amount <= 0) {
            System.out.println("Jumlah withdraw harus lebih dari 0.");
            return false;
        }

        balance -= amount;
        Transaction trans = new Transaction("WITHDRAW", amount, "Withdrawal from account");
        transactions.add(trans);
        System.out.println("Withdraw berhasil: Rp " + amount);
        return true;
    }

    public boolean transfer(BankAccount target, double amount) {
        if (!isActive) {
            System.out.println("Account tidak aktif. Tidak dapat melakukan transfer.");
            return false;
        }

        if (target == null || !target.isActive) {
            System.out.println("Target account tidak valid atau tidak aktif.");
            return false;
        }

        if (!canWithdraw(amount)) {
            System.out.println("Transfer gagal: Saldo tidak mencukupi.");
            return false;
        }

        // Kurangi dari account ini
        balance -= amount;
        Transaction debitTrans = new Transaction("TRANSFER_OUT", amount,
                "Transfer to " + target.accountNumber);
        transactions.add(debitTrans);

        // Tambah ke target account
        target.balance += amount;
        Transaction creditTrans = new Transaction("TRANSFER_IN", amount,
                "Transfer from " + this.accountNumber);
        target.transactions.add(creditTrans);

        System.out.println("Transfer berhasil: Rp " + amount + " ke account " + target.accountNumber);
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountInfo() {
        return String.format("Account [%s] - %s | Type: %s | Balance: Rp %.2f | Status: %s",
                accountNumber, accountHolderName, accountType, balance,
                isActive ? "Active" : "Inactive");
    }

    public void activateAccount() {
        isActive = true;
        System.out.println("Account " + accountNumber + " telah diaktifkan.");
    }

    public void deactivateAccount() {
        isActive = false;
        System.out.println("Account " + accountNumber + " telah dinonaktifkan.");
    }

    // Instance methods untuk business logic
    public void calculateInterest(double rate) {
        if (!isActive) {
            System.out.println("Account tidak aktif. Tidak dapat menghitung bunga.");
            return;
        }

        double interest = balance * rate;
        balance += interest;
        Transaction trans = new Transaction("INTEREST", interest,
                "Interest " + (rate * 100) + "%");
        transactions.add(trans);
        System.out.println("Bunga ditambahkan: Rp " + interest + " (" + (rate * 100) + "%)");
    }

    public boolean canWithdraw(double amount) {
        return isActive && balance >= amount && amount > 0;
    }

    public String getAccountStatus() {
        if (isActive) {
            if (balance >= 10000000) {
                return "Active - Premium";
            } else if (balance >= 1000000) {
                return "Active - Standard";
            } else {
                return "Active - Basic";
            }
        } else {
            return "Inactive";
        }
    }

    // Instance methods untuk formatting/display
    public void displayBalance() {
        System.out.printf("%s (%s): Rp %.2f%n",
                accountHolderName, accountNumber, balance);
    }

    public void printStatement() {
        System.out.println("=====================================");
        System.out.println("       BANK STATEMENT");
        System.out.println("=====================================");
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + accountHolderName);
        System.out.println("Type: " + accountType);
        System.out.println("Status: " + getAccountStatus());
        System.out.println("-------------------------------------");
        System.out.println("Transaction History:");

        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (Transaction trans : transactions) {
                System.out.println(trans.getTransactionInfo());
            }
        }

        System.out.println("-------------------------------------");
        System.out.printf("Current Balance: Rp %.2f%n", balance);
        System.out.println("=====================================");
    }

    // Getter untuk account number (untuk keperluan transfer)
    public String getAccountNumber() {
        return accountNumber;
    }
}

// Class Transaction
class Transaction {
    private String transactionId;
    private String type;
    private double amount;
    private LocalDateTime timestamp;
    private String description;
    private static int transactionCounter = 1000;

    public Transaction(String type, double amount, String description) {
        this.transactionId = "TRX" + (++transactionCounter);
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.description = description;
    }

    public String getTransactionInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return String.format("[%s] %s | %s | Rp %.2f | %s",
                transactionId, timestamp.format(formatter), type, amount, description);
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

// Class Customer
class Customer {
    private String customerId;
    private String name;
    private String phone;
    private String email;
    private ArrayList<BankAccount> accounts;

    public Customer(String customerId, String name, String phone, String email) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.accounts = new ArrayList<>();
    }

    // Methods untuk mengelola multiple accounts
    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account " + account.getAccountNumber() + " ditambahkan ke customer " + name);
    }

    public void removeAccount(String accountNumber) {
        accounts.removeIf(acc -> acc.getAccountNumber().equals(accountNumber));
        System.out.println("Account " + accountNumber + " dihapus dari customer " + name);
    }

    public double getTotalBalance() {
        double total = 0;
        for (BankAccount account : accounts) {
            total += account.getBalance();
        }
        return total;
    }

    public void displayCustomerInfo() {
        System.out.println("=====================================");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("-------------------------------------");
        System.out.println("Accounts (" + accounts.size() + "):");

        if (accounts.isEmpty()) {
            System.out.println("No accounts registered.");
        } else {
            for (BankAccount account : accounts) {
                System.out.println("  - " + account.getAccountInfo());
            }
        }
        System.out.println("=====================================");
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }
}