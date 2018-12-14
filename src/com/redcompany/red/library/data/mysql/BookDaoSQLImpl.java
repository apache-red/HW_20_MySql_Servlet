package com.redcompany.red.library.data.mysql;

import com.redcompany.red.library.entity.Book;
import com.redcompany.red.library.entity.Library;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoSQLImpl implements DBCommand {

    private Library library;

    private String standart_db = "jdbc:mysql://localhost:3306/mysql" +
            "?verifyServerCertificate=false" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";
    // CHANGE PARAMS!
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/library_db" +
                    "?verifyServerCertificate=false" +
                    "&useSSL=false" +
                    "&requireSSL=false" +
                    "&useLegacyDatetimeCode=false" +
                    "&amp" +
                    "&serverTimezone=UTC";
    ;
    private static final String DB_USER = "red";
    private static final String DB_PASS = "root";

    public BookDaoSQLImpl() {
        initBD();
    }

    @Override
    public Library getLibrary() {

        List<Book> bookList = new ArrayList<Book>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM book");
            while (rs.next() == true) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                Book book = new Book(id, title);
                bookList.add(book);
                System.out.println("id: " + id + ", " + "title" + title);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return library;
    }


    private void initBD() {
        if (testDB() == false) {
            try (Connection connection = DriverManager.getConnection(standart_db, DB_USER, DB_PASS)) {
                Statement stmt = connection.createStatement();
                if (fillDBDefaultValues(stmt) == true) {
                    System.out.println("Database was successfully initialized");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Database was created earlier");
        }


    }

    // fill standart values
    private boolean fillDBDefaultValues(Statement stmt ) {
        String sql;
        try {
            sql="CREATE DATABASE library_db; ";
            stmt.execute(sql);
            sql="USE library_db;";
            stmt.execute(sql);
            sql="CREATE TABLE mylibrary(id INT PRIMARY KEY AUTO_INCREMENT,catalog_authors varchar(40) NOT NULL);";
            stmt.execute(sql);
            sql="INSERT INTO `library_db`.`mylibrary` (`catalog_authors`) VALUES ('Ivan Ivanov');";
            stmt.execute(sql);
            sql="INSERT INTO `library_db`.`mylibrary` (`catalog_authors`) VALUES ('Petya Petrov');";
            stmt.execute(sql);
            sql="INSERT INTO `library_db`.`mylibrary` (`catalog_authors`) VALUES ('Vasya Vasiliev');";
            stmt.execute(sql);
            sql="CREATE TABLE catalog_books(id INT PRIMARY KEY AUTO_INCREMENT,book_title varchar(40) NOT NULL, auth_id INT , FOREIGN KEY  (auth_id) REFERENCES mylibrary(id));";
            stmt.execute(sql);
            System.out.println();
            sql="INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A1_BOOK_1',1);";
            stmt.execute(sql);
            sql="INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A1_BOOK_2',1);";
            stmt.execute(sql);
            sql="INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A1_BOOK_3',1);";
            stmt.execute(sql);
            sql="INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A2_BOOK_1',2);";
            stmt.execute(sql);
            sql="INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A2_BOOK_2',2);";
            stmt.execute(sql);
            sql="INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A2_BOOK_3',2);";
            stmt.execute(sql);
            sql="INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A3_BOOK_1',3);";
            stmt.execute(sql);
            sql="INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A3_BOOK_2',3);";
            stmt.execute(sql);
            sql="INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A3_BOOK_3',3);";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error FILL DB !!!!");
            e.printStackTrace();
        }
        return true;
    }

    // поиск БД по названию
    private boolean testDB() {
        String dbNameFind = "library_db";
        try (Connection connection = DriverManager.getConnection(standart_db, DB_USER, DB_PASS)) {
            Statement st = connection.createStatement();
            ResultSet resultSet = connection.getMetaData().getCatalogs();
            while (resultSet.next()) {
                // Get the database name, which is at position 1
                String databaseName = resultSet.getString(1);
                if (databaseName.equals(dbNameFind)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Test
    public void testInitBD() {
        initBD();
    }


}
