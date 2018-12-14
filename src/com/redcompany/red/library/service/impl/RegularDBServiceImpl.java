package com.redcompany.red.library.service.impl;

import com.redcompany.red.library.data.mysql.DBCommand;
import com.redcompany.red.library.entity.Catalog;
import com.redcompany.red.library.entity.Library;
import com.redcompany.red.library.service.DBService;

import java.util.List;

public class RegularDBServiceImpl implements DBService {
   private DBCommand dbCommand;
   private Library library;




    @Override
    public List<Catalog> getCatalogListFromLibrary(DBCommand dbCommand) {
        library = dbCommand.getLibrary();
        return library.getCatalogList();

    }



}
