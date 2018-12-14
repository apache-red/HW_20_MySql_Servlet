package com.redcompany.red.library.controller.command.webCommand.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.redcompany.red.library.controller.command.webCommand.BasicCommandWeb;

public class OneActionImpl implements BasicCommandWeb {

	@Override
	public void performAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("one perf");	
	}

}
