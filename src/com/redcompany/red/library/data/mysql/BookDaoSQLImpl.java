package com.redcompany.red.library.data.mysql;

import com.redcompany.red.library.entity.Book;
import com.redcompany.red.library.entity.Catalog;
import com.redcompany.red.library.entity.Library;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookDaoSQLImpl implements DBCommand {

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

        try {
            Class.forName("com.mysql.jdbc.Driver");

        initBD();

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public Library getLibrary() {
        Library libraryDB = new Library();
        List<Catalog> catalogList = libraryDB.createNewCatalogList();


        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement st = connection.createStatement();
            collectCatalogsFromRS(st, catalogList);
            collectBooksFromRS(st, catalogList);
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }



        return libraryDB;
    }


    private void collectCatalogsFromRS(Statement st, List<Catalog> catalogList) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM mylibrary;");
        while (rs.next() == true) {
            Catalog catalog = new Catalog();
            String author_name = rs.getString("catalog_authors");
            catalog.setResponsiblePerson(author_name);
            catalog.setCreationData(new Date());
            catalogList.add(catalog);
        }
        rs.close();
    }

    private void collectBooksFromRS(Statement st, List<Catalog> catalogList) throws SQLException {
        for (int i = 0; i <catalogList.size(); i++) {
            Catalog catalog = catalogList.get(i);
            List<Book> bookList= new ArrayList<>();
            String find = String.valueOf(i+1);
            ResultSet rs = st.executeQuery("SELECT id, book_title FROM catalog_books\n" +
                    "WHERE auth_id =" + find + ";");
            while (rs.next() == true) {
                int id_book = rs.getInt("id");
                String title = rs.getString("book_title");
                Book book = new Book(id_book, title);
               bookList.add(book);
            }
            catalog.setBooks(bookList);
        }
    }


//     rs.close();
//
//            int author_size = showLibrary.getCatalogList().size();
//
//            List<Book> bookList = new ArrayList<Book>();
//            for (int i = 0; i < author_size; i++) {
//                ResultSet rs2 = st.executeQuery("SELECT id, book_title FROM catalog_books\n" +
//                        "WHERE auth_id ="+i+";");
//                while (rs.next() == true) {
//                    int id_book = rs2.getInt("id");
//                    String title = rs2.getString("book_title");
//                    Book book = new Book(id_book, title);
//                    bookList.add(book);
//                }
//                rs2.close();
//                showLibrary.getCatalogList().get(i).setBooks(bookList);
//            }


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
        } else {
            System.out.println("Database was created earlier");
        }


    }

    // fill standart values
    private boolean fillDBDefaultValues(Statement stmt) {
        String sql;
        try {
            sql = "CREATE DATABASE library_db; ";
            stmt.execute(sql);
            sql = "USE library_db;";
            stmt.execute(sql);
            sql = "CREATE TABLE mylibrary(id INT PRIMARY KEY AUTO_INCREMENT,catalog_authors varchar(40) NOT NULL);";
            stmt.execute(sql);
            sql = "INSERT INTO `library_db`.`mylibrary` (`catalog_authors`) VALUES ('Ivan Ivanov');";
            stmt.execute(sql);
            sql = "INSERT INTO `library_db`.`mylibrary` (`catalog_authors`) VALUES ('Petya Petrov');";
            stmt.execute(sql);
            sql = "INSERT INTO `library_db`.`mylibrary` (`catalog_authors`) VALUES ('Vasya Vasiliev');";
            stmt.execute(sql);
            sql = "CREATE TABLE catalog_books(id INT PRIMARY KEY AUTO_INCREMENT,book_title varchar(40) NOT NULL, auth_id INT , FOREIGN KEY  (auth_id) REFERENCES mylibrary(id));";
            stmt.execute(sql);
            System.out.println();
            sql = "INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A1_BOOK_1',1);";
            stmt.execute(sql);
            sql = "INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A1_BOOK_2',1);";
            stmt.execute(sql);
            sql = "INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A1_BOOK_3',1);";
            stmt.execute(sql);
            sql = "INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A2_BOOK_1',2);";
            stmt.execute(sql);
            sql = "INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A2_BOOK_2',2);";
            stmt.execute(sql);
            sql = "INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A2_BOOK_3',2);";
            stmt.execute(sql);
            sql = "INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A3_BOOK_1',3);";
            stmt.execute(sql);
            sql = "INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A3_BOOK_2',3);";
            stmt.execute(sql);
            sql = "INSERT INTO `library_db`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A3_BOOK_3',3);";
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
