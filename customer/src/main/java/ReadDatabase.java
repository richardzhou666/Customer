import java.sql.*;
import java.util.HashMap;
import java.util.Objects;

public class ReadDatabase {
    final static String DB_URL = "jdbc:mysql://13.57.13.193:3306/bankdb";
    final static String USER = "root";
    final static String PASS = "password";
    static ResultSet rs;
    static Connection conn;

    public static HashMap<Integer, Customer> read() {
        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM contacts_tbl";
            rs = stmt.executeQuery(sql);
            HashMap<Integer, Customer> customerHashMap = new HashMap<>();
            while (rs.next()) {
                int id = rs.getInt("contactID");
                String FirstName = rs.getString("contact_name");
                String LastName = rs.getString("contact_lastname");
                String phone = rs.getString("contact_phoneNume");
                String email = rs.getString("contact_email");
                customerHashMap.put(id, new Customer(id, FirstName, LastName, phone, email));
            }
            return customerHashMap;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void remove(int id) {
        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();
            String query = "DELETE FROM contacts_tbl WHERE contactID =" + id;
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void add(String firstName, String lastName, String phoneNumber, String email) {
        try {
            firstName = "\'" + firstName + "\'";
            lastName = "\'" + lastName + "\'";
            phoneNumber = "\'" + phoneNumber + "\'";
            email = "\'" + email + "\'";
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO contacts_tbl" +
                    " (contact_name, contact_lastname, contact_phoneNume, contact_email)" +
                    "VALUES" +
                    "(" + firstName + ", " + lastName +", "+ phoneNumber + ", " + email + ");";
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void add(int id, String firstName, String lastName, String phoneNumber, String email) {
        try {
            firstName = "\'" + firstName + "\'";
            lastName = "\'" + lastName + "\'";
            phoneNumber = "\'" + phoneNumber + "\'";
            email = "\'" + email + "\'";
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO contacts_tbl" +
                    " (contact_name, contact_lastname, contact_phoneNume, contact_email)" +
                    "VALUES" +
                    "(" + id + ", " + firstName + ", " +
                    lastName +", "+ phoneNumber + ", " + email + ");";
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(int id, String firstName, String lastName, String phoneNumber, String email) {
        HashMap<Integer, Customer> customerHashMap = read();
        assert customerHashMap != null;
        if (!customerHashMap.containsKey(id)) {
            throw new IllegalArgumentException("ID does not exist in database!");
        }
        remove(id);
        add(firstName, lastName, phoneNumber, email);
    }

    public static void printAll() {
        for (Customer a: Objects.requireNonNull(read()).values()) {
            System.out.println(a.id + " " + a.firstName + " " +
                    a.lastName + " " + a.phoneNumber + " " + a.email);
        }
    }
}