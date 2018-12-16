package com.redcompany.red.library.controller.command.webCommand.impl;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.redcompany.red.library.controller.command.webCommand.BasicCommandWeb;
import com.redcompany.red.library.data.DataBase;
import com.redcompany.red.library.service.DBService;
import com.redcompany.red.library.service.impl.RegularDBServiceImpl;

public class TwoActionImpl implements BasicCommandWeb {
	
	private DBService dbService;
	private DataBase dataBase;

	@Override
	public void performAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {


//		dbService = new RegularDBServiceImpl();
//
//
//		System.out.println("two perf");
//		resp.getWriter().println(books);
	}

}
