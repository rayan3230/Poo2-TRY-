
import java.sql.*;

public class DatabaseTester {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test1?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "wass 2006";

    public static void main(String[] args) {
        System.out.println("🚀 Starting comprehensive database test...\n");
        
        boolean connectionTest = testConnection();
        boolean tableTest = testTableCreation();
        boolean insertTest = testDataInsertion();
        boolean queryTest = testDataRetrieval();

        System.out.println("\n📊 Test Results:");
        System.out.println("✅ Connection Test: " + (connectionTest ? "Passed" : "Failed"));
        System.out.println("✅ Table Creation:  " + (tableTest ? "Passed" : "Failed"));
        System.out.println("✅ Data Insertion:  " + (insertTest ? "Passed" : "Failed"));
        System.out.println("✅ Data Retrieval:  " + (queryTest ? "Passed" : "Failed"));

        if (connectionTest && tableTest && insertTest && queryTest) {
            System.out.println("\n🎉 All tests passed! Database setup is correct!");
        } else {
            System.out.println("\n❌ Some tests failed. Check error messages above.");
        }
    }

    private static boolean testConnection() {
        System.out.println("🔌 Testing database connection...");
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("   ✔️ Connection established successfully");
            return true;
        } catch (Exception e) {
            System.out.println("   ❌ Connection failed: " + e.getMessage());
            return false;
        }
    }

    private static boolean testTableCreation() {
        System.out.println("\n🛠️ Testing table creation...");
        String sql = "CREATE TABLE IF NOT EXISTS test_users (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY," +
                     "username VARCHAR(50) NOT NULL UNIQUE," +
                     "email VARCHAR(100) NOT NULL)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("   ✔️ Test table created successfully");
            return true;
        } catch (SQLException e) {
            System.out.println("   ❌ Table creation failed: " + e.getMessage());
            return false;
        }
    }

    private static boolean testDataInsertion() {
        System.out.println("\n📥 Testing data insertion...");
        String sql = "INSERT INTO test_users (username, email) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "test_user");
            pstmt.setString(2, "test@example.com");
            pstmt.executeUpdate();
            System.out.println("   ✔️ Test data inserted successfully");
            return true;
        } catch (SQLException e) {
            System.out.println("   ❌ Data insertion failed: " + e.getMessage());
            return false;
        }
    }

    private static boolean testDataRetrieval() {
        System.out.println("\n📤 Testing data retrieval...");
        String sql = "SELECT * FROM test_users";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("   📋 Retrieved data:");
            boolean foundData = false;
            while (rs.next()) {
                foundData = true;
                System.out.println("   - ID: " + rs.getInt("id") +
                                 ", Username: " + rs.getString("username") +
                                 ", Email: " + rs.getString("email"));
            }
            
            if (!foundData) {
                System.out.println("   ❌ No data found in table");
                return false;
            }
            return true;
        } catch (SQLException e) {
            System.out.println("   ❌ Data retrieval failed: " + e.getMessage());
            return false;
        }
    }
}