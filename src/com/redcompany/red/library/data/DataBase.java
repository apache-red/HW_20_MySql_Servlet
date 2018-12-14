package com.redcompany.red.library.data;

import com.redcompany.red.library.data.collection.LibraryCommand;
import com.redcompany.red.library.data.collection.LibraryData;
import com.redcompany.red.library.data.mysql.BookDaoSQLImpl;

public class DataBase {

    LibraryCommand libraryData = new LibraryData();
    BookDaoSQLImpl bookDaoSQL = new BookDaoSQLImpl();



    public LibraryCommand gedLibraryData(){
        return libraryData;
    }

    public BookDaoSQLImpl gedDataBase(){
        return bookDaoSQL;
    }

}
