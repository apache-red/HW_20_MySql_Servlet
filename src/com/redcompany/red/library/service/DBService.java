package com.redcompany.red.library.service;

import com.redcompany.red.library.data.mysql.BookDaoSQLImpl;

import com.redcompany.red.library.entity.Library;



public interface DBService {

    Library getLibrary(BookDaoSQLImpl bookDaoSQL);
}
