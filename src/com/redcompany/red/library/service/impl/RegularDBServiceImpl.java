package com.redcompany.red.library.service.impl;

import com.redcompany.red.library.data.mysql.BookDaoSQLImpl;
import com.redcompany.red.library.data.mysql.DBCommand;
import com.redcompany.red.library.entity.Book;
import com.redcompany.red.library.entity.Catalog;
import com.redcompany.red.library.entity.Library;
import com.redcompany.red.library.service.DBService;
import javafx.scene.LightBase;

import java.util.List;

public class RegularDBServiceImpl implements DBService {
   private DBCommand dbCommand;
   private Library library;
   private List<Book> bookList;


    @Override
    public Library getLibrary(BookDaoSQLImpl bookDaoSQL) {
       return library = bookDaoSQL.getLibrary();
    }

}
