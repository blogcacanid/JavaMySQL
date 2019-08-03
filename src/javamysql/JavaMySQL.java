/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql;

// import dependencies
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author cacan
 */
public class JavaMySQL {

    // Menyiapkan paramter JDBC untuk koneksi ke datbase
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/java_db";
    static final String USER = "root";
    static final String PASS = "";

    // Menyiapkan objek yang diperlukan untuk mengelola database
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Melakukan koneksi ke database
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);
            
            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // buat objek statement
            stmt = conn.createStatement();
            
            // buat query ke database
            String sql = "SELECT * FROM pegawai";
            
            // eksekusi query dan simpan hasilnya di obj ResultSet
            rs = stmt.executeQuery(sql);
            
            // tampilkan hasil query
            while(rs.next()){
                System.out.println("NIP: " + rs.getInt("nip"));
                System.out.println("Nama Pegawai: " + rs.getString("nama_pegawai"));
                System.out.println("Alamat: " + rs.getString("alamat") + "\n");
            }
            
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
    
}
