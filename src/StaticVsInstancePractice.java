public class StaticVsInstancePractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Static vs Instance
         *
         * Instruksi: Lengkapi semua latihan di bawah ini untuk menguasai
         * perbedaan static dan instance members, kapan menggunakan masing-masing.
         */

        // ===== STATIC VARIABLES DEMO =====
        System.out.println("=== STATIC VARIABLES DEMO ===");

        // Latihan 1: Static variables sebagai shared data
        // Buat beberapa object dari class yang memiliki static counter
        // Tunjukkan bahwa static variable di-share oleh semua object

        // Demonstrasikan static variable sharing
        System.out.println("App Name: " + Counter.APP_NAME);
        System.out.println("Global count awal: " + Counter.getGlobalCount());

        Counter c1 = new Counter("Counter-1");
        Counter c2 = new Counter("Counter-2");
        Counter c3 = new Counter("Counter-3");

        System.out.println("\nSetelah buat 3 object:");
        System.out.println("Global count: " + Counter.getGlobalCount());
        c1.displayCounterInfo();
        c2.displayCounterInfo();
        c3.displayCounterInfo();
        System.out.println("\nIncrement instance counter pada c1:");
        c1.incrementInstance();
        c1.incrementInstance();

        System.out.println("\nSetelah increment c1 saja:");
        c1.displayCounterInfo();
        c2.displayCounterInfo();
        System.out.println("Global count tetap: " + Counter.getGlobalCount());


        // ===== STATIC METHODS DEMO =====
        System.out.println("\\n=== STATIC METHODS DEMO ===");

        // Latihan 2: Static methods sebagai utility functions
        // Implementasikan utility methods yang tidak butuh object
        // Tunjukkan cara memanggil static methods

        // Demonstrasikan static methods usage
        System.out.println("PI = " + MathUtils.PI);
        System.out.println("E = " + MathUtils.E);

        double radius = 7.0;
        double area = MathUtils.calculateCircleArea(radius);
        System.out.println("\nLuas lingkaran dengan radius " + radius + " = " + area);

        double distance = MathUtils.calculateDistance(0, 0, 3, 4);
        System.out.println("Jarak dari (0,0) ke (3,4) = " + distance);

        int num = 17;
        System.out.println("\nApakah " + num + " bilangan prima? " + MathUtils.isPrime(num));

        int n = 5;
        System.out.println("Faktorial dari " + n + " = " + MathUtils.factorial(n));

        double result = MathUtils.power(2, 10);
        System.out.println("2 pangkat 10 = " + result);



        // ===== STATIC VS INSTANCE COMPARISON =====
        System.out.println("\\n=== STATIC VS INSTANCE COMPARISON ===");

        // Latihan 3: Perbandingan langsung static vs instance
        // Tunjukkan memory usage difference
        // Performance comparison

        // Implementasikan perbandingan
        System.out.println("STATIC: Dipanggil langsung dari class, tidak perlu object");
        System.out.println("Contoh: MathUtils.calculateCircleArea(5)");
        System.out.println("Memory: Hanya 1 copy untuk semua");
        System.out.println("\nINSTANCE: Butuh object, setiap object punya data sendiri");
        Counter test1 = new Counter("Test-1");
        Counter test2 = new Counter("Test-2");
        test1.incrementInstance();
        test1.incrementInstance();
        test2.incrementInstance();
        System.out.println("Test-1 instance count: " + test1.getInstanceCount());
        System.out.println("Test-2 instance count: " + test2.getInstanceCount());
        System.out.println("Memory: Setiap object punya copy sendiri");

        // ===== STATIC INITIALIZATION =====
        System.out.println("\\n=== STATIC INITIALIZATION ===");

        // Latihan 4: Static initialization blocks
        // Tunjukkan kapan static variables diinisialisasi
        // Static blocks vs static variable initialization

        // Demonstrasikan static initialization
        System.out.println("DatabaseConnection akan menjalankan static block saat pertama kali diakses:");
        DatabaseConnection conn1 = DatabaseConnection.getConnection();
        System.out.println("Connection 1 dibuat");

        DatabaseConnection conn2 = DatabaseConnection.getConnection();
        System.out.println("Connection 2 dibuat");

        System.out.println("\nActive connections: " + DatabaseConnection.getActiveConnectionCount());

        conn1.connect();
        conn1.executeQuery("SELECT * FROM users");
        conn1.disconnect();

        System.out.println("\nActive connections setelah disconnect: " + DatabaseConnection.getActiveConnectionCount());
        // ===== BEST PRACTICES =====
        System.out.println("\\n=== BEST PRACTICES ===");

        // Latihan 5: Kapan menggunakan static vs instance
        // Constants (static final)
        // Utility methods (static)
        // Counters/global state (static)
        // Object-specific data (instance)

        // Implementasikan best practices examples
        System.out.println("1. CONSTANTS - Gunakan static final:");
        System.out.println("   MathUtils.PI = " + MathUtils.PI);

        System.out.println("\n2. UTILITY METHODS - Gunakan static:");
        System.out.println("   MathUtils.factorial(6) = " + MathUtils.factorial(6));

        System.out.println("\n3. COUNTERS/GLOBAL STATE - Gunakan static:");
        Student.setUniversityName("Universitas Indonesia");
        Student s1 = new Student("S001", "Ahmad", "Computer Science", 3.5);
        Student s2 = new Student("S002", "Budi", "Engineering", 3.7);
        Student s3 = new Student("S003", "Citra", "Medicine", 3.9);
        System.out.println("   Total students: " + Student.getTotalStudents());
        System.out.println("   University: " + Student.getUniversityName());
        System.out.println("\n4. OBJECT-SPECIFIC DATA - Gunakan instance:");
        s1.displayStudentInfo();
        s2.displayStudentInfo();
        s3.displayStudentInfo();

        System.out.println("\n5. UPDATE INSTANCE DATA:");
        s1.updateGPA(3.8);
        s1.displayStudentInfo();
    }
}

// ===== CLASS DEFINITIONS =====

// Implementasikan class Counter dengan static dan instance counters
class Counter {
    // Static variables
    static int globalCount = 0;
    static final String APP_NAME = "Counter Application v1.0";
    // static int globalCount
    // static final String APP_NAME

    // Instance variables
    // int instanceCount
    // String counterName
    int instanceCount;
    String counterName;

    // Static initialization block
    // static { ... }
    static {
        System.out.println("Static block dijalankan saat class Counter pertama kali dimuat");
        globalCount = 0;
    }

    // Constructor
    // Increment both static dan instance counters
    public Counter(String counterName) {
        this.counterName = counterName;
        this.instanceCount = 0;
        globalCount++;
        System.out.println("Counter '" + counterName + "' dibuat (global count: " + globalCount + ")");
    }

    // Static methods
    // static int getGlobalCount()
    // static void resetGlobalCount()
    // static void displayAppInfo()
    static int getGlobalCount() {
        return globalCount;
    }

    static void resetGlobalCount() {
        globalCount = 0;
        System.out.println("Global count direset ke 0");
    }

    static void displayAppInfo() {
        System.out.println("Application: " + APP_NAME);
        System.out.println("Total counters created: " + globalCount);
    }


    // Instance methods
    // int getInstanceCount()
    // void incrementInstance()
    // void displayCounterInfo()
    int getInstanceCount() {
        return instanceCount;
    }

    void incrementInstance() {
        instanceCount++;
        System.out.println(counterName + " instance count: " + instanceCount);
    }

    void displayCounterInfo() {
        System.out.println(counterName + " - Instance: " + instanceCount + ", Global: " + globalCount);
    }
}

// Implementasikan class MathUtils dengan static utility methods
class MathUtils {
    // Constants
    // static final double PI
    // static final double E
    static final double PI = 3.14159265359;
    static final double E = 2.71828182846;
    // Private constructor (utility class)
    private MathUtils() {
        // Prevent instantiation
    }

    // Static utility methods
    // static double calculateCircleArea(double radius)
    // static double calculateDistance(double x1, double y1, double x2, double y2)
    // static boolean isPrime(int number)
    // static int factorial(int n)
    // static double power(double base, int exponent)

    // Private constructor (utility class)
    // private MathUtils() { ... }
    static double calculateCircleArea(double radius) {
        return PI * radius * radius;
    }

    static double calculateDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    static int factorial(int n) {
        if (n <= 1) return 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    static double power(double base, int exponent) {
        if (exponent == 0) return 1;
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}


// Implementasikan class DatabaseConnection dengan static connection pool
class DatabaseConnection {
    // Static variables untuk connection pool
    // static int maxConnections
    // static int activeConnections
    // static boolean isInitialized
    static int maxConnections = 10;
    static int activeConnections = 0;
    static boolean isInitialized = false;
    static int connectionCounter = 0;

    // Instance variables
    // String connectionId
    // boolean isConnected
    // String database
    String connectionId;
    boolean isConnected;
    String database;

    // Static initialization
    // static block untuk setup connection pool
    static {
        System.out.println("=== Database Connection Pool Initialization ===");
        System.out.println("Max connections: " + maxConnections);
        isInitialized = true;
    }
    private DatabaseConnection() {
        this.connectionId = "CONN-" + (++connectionCounter);
        this.isConnected = false;
        this.database = "default_db";
        activeConnections++;
    }

    // Static methods untuk connection management
    // static DatabaseConnection getConnection()
    // static void closeAllConnections()
    // static int getActiveConnectionCount()
    static DatabaseConnection getConnection() {
        if (!isInitialized) {
            System.out.println("Connection pool belum diinisialisasi!");
            return null;
        }

        if (activeConnections >= maxConnections) {
            System.out.println("Max connections reached!");
            return null;
        }

        return new DatabaseConnection();
    }

    static void closeAllConnections() {
        activeConnections = 0;
        System.out.println("Semua connections ditutup");
    }

    static int getActiveConnectionCount() {
        return activeConnections;
    }

    // Instance methods
    // void connect()
    // void disconnect()
    // void executeQuery(String query)
    void connect() {
        if (!isConnected) {
            isConnected = true;
            System.out.println(connectionId + " connected to " + database);
        }
    }

    void disconnect() {
        if (isConnected) {
            isConnected = false;
            activeConnections--;
            System.out.println(connectionId + " disconnected");
        }
    }

    void executeQuery(String query) {
        if (isConnected) {
            System.out.println(connectionId + " executing: " + query);
        } else {
            System.out.println("Not connected!");
        }
    }
}



// Implementasikan class Student dengan mixed static/instance
class Student {
    // Static variables
    // static String universityName
    // static int totalStudents
    static String universityName = "Unknown University";
    static int totalStudents = 0;


    // Instance variables
    // String studentId, name, major
    // double gpa
    String studentId;
    String name;
    String major;
    double gpa;


    // Constructor
    // Increment totalStudents
    public Student(String studentId, String name, String major, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.gpa = gpa;
        totalStudents++;
    }

    // Static methods
    // static int getTotalStudents()
    // static void setUniversityName(String name)
    // static String getUniversityName()
    static int getTotalStudents() {
        return totalStudents;
    }

    static void setUniversityName(String name) {
        universityName = name;
    }

    static String getUniversityName() {
        return universityName;
    }

    // Instance methods
    // void updateGPA(double newGPA)
    // void displayStudentInfo()
    // boolean isHonorStudent()
    void updateGPA(double newGPA) {
        if (newGPA >= 0.0 && newGPA <= 4.0) {
            this.gpa = newGPA;
            System.out.println(name + " GPA updated to " + gpa);
        } else {
            System.out.println("Invalid GPA!");
        }
    }

    void displayStudentInfo() {
        System.out.println("Student: " + name + " (" + studentId + ")");
        System.out.println("  Major: " + major);
        System.out.println("  GPA: " + gpa);
        System.out.println("  University: " + universityName);
        System.out.println("  Honor Student: " + (isHonorStudent() ? "Yes" : "No"));
    }

    boolean isHonorStudent() {
        return gpa >= 3.5;
    }
}

