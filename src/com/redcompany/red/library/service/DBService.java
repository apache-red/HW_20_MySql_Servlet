package com.redcompany.red.library.service;

import com.redcompany.red.library.data.mysql.BookDaoSQLImpl;

import com.redcompany.red.library.data.mysql.DBCommand;
import com.redcompany.red.library.entity.Catalog;
import com.redcompany.red.library.entity.Library;

import java.util.List;


public interface DBService {


    List<Catalog> getCatalogListFromLibrary(DBCommand dbCommand);
}
