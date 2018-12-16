package com.redcompany.red.library.controller.command.webCommand.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import com.redcompany.red.library.controller.command.webCommand.BasicCommandWeb;
import com.redcompany.red.library.data.DataBase;
import com.redcompany.red.library.data.mysql.BookDaoSQLImpl;
import com.redcompany.red.library.entity.Catalog;
import com.redcompany.red.library.service.DBService;
import com.redcompany.red.library.service.impl.RegularDBServiceImpl;

import java.io.IOException;
import java.util.List;


public class ViewAllBooksInAllCatalogsWeb implements BasicCommandWeb {

	private DBService dbService;
	private DataBase dataBase;
	private List<Catalog> catalogList;
	private BookDaoSQLImpl bookDaoSQL;

	@Override
	public void performAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		DataBase dataBase = new DataBase();

		bookDaoSQL = dataBase.gedDataBase();

		dbService = new RegularDBServiceImpl();
		catalogList = dbService.getCatalogListFromLibrary(bookDaoSQL);
		System.out.println(catalogList);
		resp.getWriter().println(catalogList);


	}



}



