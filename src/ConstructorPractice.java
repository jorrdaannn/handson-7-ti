import java.time.LocalDate;

public class ConstructorPractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Constructors
         *
         * Instruksi: Lengkapi semua latihan di bawah ini untuk menguasai
         * constructors, constructor overloading, dan keyword this.
         */

        // ===== DEFAULT VS CUSTOM CONSTRUCTOR =====
        System.out.println("=== DEFAULT VS CUSTOM CONSTRUCTOR ===");

        // Latihan 1: Memahami default constructor
        // Buat class dengan dan tanpa custom constructor
        // Tunjukkan perbedaan penggunaan default constructor

        // Demonstrasikan penggunaan default constructor
        SimpleClass obj1 = new SimpleClass();
        System.out.println("SimleClass object dibut");
        System.out.println("Nilai x: " + obj1.x);
        System.out.println("Nilai y: " + obj1.y);
        System.out.println("Nilai name: " + obj1.name);

        // ===== CONSTRUCTOR OVERLOADING =====
        System.out.println("\\n=== CONSTRUCTOR OVERLOADING ===");

        // Latihan 2: Multiple constructors untuk berbagai skenario
        // Implementasikan class Product dengan multiple constructors
        // Setiap constructor untuk kasus penggunaan yang berbeda

        // Buat object Product menggunakan berbagai constructors
        Product p1 =new Product("P001", "Laptop", "Laptop Gaming", 15000000, "Electronics", 10, "Tech Supplier");
        Product p2 =new Product("P002", "Mouse", 15000);
        Product p3 = new Product();
        Product p4 = new Product(p1);

        System.out.println("Product 1:");
        p1.displayProductInfo();

        System.out.println("\nProduct 2:");
        p2.displayProductInfo();

        System.out.println("\nProduct 3 (default):");
        p3.displayProductInfo();

        System.out.println("\nProduct 4 (copy dari p1):");
        p4.displayProductInfo();

        // ===== KEYWORD THIS =====
        System.out.println("\\n=== KEYWORD THIS ===");

        // Latihan 3: Penggunaan this dalam constructor dan methods
        // Demonstrasikan this untuk menghindari name collision
        // Gunakan this untuk memanggil constructor lain
        // Gunakan this untuk mereferensikan current object

        // Demonstrasikan berbagai penggunaan this
        Product p5 = new Product("P005", "Keyboard", 500000);
        p5.updateStock(5);
        System.out.println("Stok tersedia? " + p5.isAvailable());
        p5.applyDiscount(10);

        // ===== CONSTRUCTOR CHAINING =====
        System.out.println("\\n=== CONSTRUCTOR CHAINING ===");

        // Latihan 4: Constructor yang memanggil constructor lain
        // Implementasikan constructor chaining dengan this()
        // Tunjukkan keuntungan constructor chaining

        // Implementasikan constructor chaining
        Employee e1 = new Employee("E001", "Jordan", "Girsang", "IT" ,"Developer" ,8000000, LocalDate.of(2020, 5, 15) );
        Employee e2 = new Employee("E002", "Ivan", "Halim", "HR");
        Employee e3 = new Employee("E003", "Josch", "Fanwell");

        System.out.println("Employee 1:");
        e1.getEmployeeInfo();

        System.out.println("\nEmployee 2:");
        e2.getEmployeeInfo();

        System.out.println("\nEmployee 3:");
        e3.getEmployeeInfo();
        // ===== INITIALIZATION ORDER =====
        System.out.println("\\n=== INITIALIZATION ORDER ===");

        // Latihan 5: Urutan inisialisasi object
        // Tunjukkan urutan eksekusi saat object dibuat
        // Instance variable initialization vs constructor

        // Demonstrasikan urutan inisialisasi
        System.out.println("Membuat InitializationDemo Onject: ");
        InitializationDemo demo = new InitializationDemo("Test Value");
    }
}

// ===== CLASS DEFINITIONS =====

// Implementasikan class SimpleClass (tanpa custom constructor)
class SimpleClass {
    // Hanya instance variables, tanpa constructor
    int x;
    int y;
    String name;
}

// Implementasikan class Product dengan constructor overloading
class Product {
    // Instance variables
    // productId, name, description, price, category, inStock, supplier
    String productID;
    String name;
    String desecription;
    double price;
    String category;
    int inStock;
    String supplier;

    // Constructor 1: Full parameters
    // public Product(String productId, String name, String description, double price, String category, int inStock, String supplier)
    public Product(String productID, String name, String desecription, double price, String category, int inStock, String supplier) {
        this.productID = productID;
        this.name = name;
        this.desecription = desecription;
        this.price = price;
        this.category = category;
        this.inStock = inStock;
        this.supplier = supplier;
    }


    // Constructor 2: Essential parameters only
    // public Product(String productId, String name, double price)
    public Product(String productId, String name, double price) {
        this.productID= productId;
        this.name = name;
        this.price = price;
        this.desecription = "No description";
        this.category = "General";
        this.inStock = 0;
        this.supplier = "Unknown";
    }

    // Constructor 3: Copy constructor
    // public Product(Product other)
    public Product(Product other) {
        this.productID = other.productID;
        this.name = other.name;
        this.desecription = other.desecription;
        this.price = other.price;
        this.category = other.category;
        this.inStock = other.inStock;
        this.supplier = other.supplier;
    }

    // Constructor 4: Default constructor with default values
    // public Product()
    public Product() {
        this.productID = "P000";
        this.name = "Unknown Product";
        this.desecription = "No description";
        this.price = 0.0;
        this.category = "General";
        this.inStock = 0;
        this.supplier = "Unknown";
    }


    // Methods
    void displayProductInfo(){
        System.out.println("ID: " + productID);
        System.out.println("Name: " + name);
        System.out.println("Description: " + desecription);
        System.out.println("Price: Rp " + price);
        System.out.println("Category: " + category);
        System.out.println("Stock: " + inStock);
        System.out.println("Supplier: " + supplier);
    }
    void updateStock(int quantity){
        this.inStock+=quantity;
        System.out.println("Stock updated. New stock: " + this.inStock);
    }
    void applyDiscount(double percentage) {
        double discount = this.price * percentage / 100;
        this.price = this.price - discount;
        System.out.println("Discount applied: " + percentage + "%");
        System.out.println("New price: Rp " + this.price);
    }
    boolean isAvailable() {
        return this.inStock > 0;
    }
}
    // displayProductInfo()
    // updateStock(int quantity)
    // applyDiscount(double percentage)
    // isAvailable()


// Implementasikan class Employee dengan constructor chaining
class Employee {
    // Instance variables
    // employeeId, firstName, lastName, department, position, salary, hireDate
    String employeeid;
    String firstName;
    String lastName;
    String departement;
    String position;
    double salary;
    LocalDate hireDate;

    // Constructor chaining examples
    // Buat multiple constructors yang saling memanggil dengan this()
    public Employee(String employeeId, String firstName, String lastName, String department, String position, double salary, LocalDate hireDate) {
        this.employeeid = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departement = department;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
    }
    public Employee(String employeeId, String firstName, String lastName, String department) {
        this(employeeId, firstName, lastName, department, "Staff", 5000000, LocalDate.now());
    }
    public Employee(String employeeId, String firstName, String lastName) {
        this(employeeId, firstName, lastName, "General");
    }




    // Methods
    // getFullName()
    // calculateYearsOfService()
    // getEmployeeInfo()
    // giveRaise(double percentage)
    String getFullName() {
        return firstName + " " + lastName;
    }

    int calculateYearsOfService() {
        return LocalDate.now().getYear() - hireDate.getYear();
    }

    void getEmployeeInfo() {
        System.out.println("ID: " + employeeid);
        System.out.println("Name: " + getFullName());
        System.out.println("Department: " + departement);
        System.out.println("Position: " + position);
        System.out.println("Salary: Rp " + salary);
        System.out.println("Hire Date: " + hireDate);
        System.out.println("Years of Service: " + calculateYearsOfService());
    }

    void giveRaise(double percentage) {
        double raise = salary * percentage / 100;
        salary += raise;
        System.out.println("Raise given: " + percentage + "%");
        System.out.println("New salary: Rp " + salary);
    }
}


// Implementasikan class InitializationDemo
class InitializationDemo {
    // Tunjukkan instance variable initialization
    // Tunjukkan urutan eksekusi constructor
    int number = 10;
    String text="Initial";
    // Tambahkan System.out.println di berbagai tempat untuk tracking
    public InitializationDemo(String input) {
        System.out.println("1. Instance variable 'number' sudah diinisialisasi: " + number);
        System.out.println("2. Instance variable 'text' sudah diinisialisasi: " + text);
        System.out.println("3. Constructor dijalankan dengan parameter: " + input);

        text = input;
        number = 100;

        System.out.println("4. Instance variables diubah di constructor");
        System.out.println("5. Nilai akhir number: " + number);
        System.out.println("6. Nilai akhir text: " + text);
    }
}

