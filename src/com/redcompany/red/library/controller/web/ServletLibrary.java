package com.redcompany.red.library.controller.web;

import com.redcompany.red.library.controller.command.webCommand.BasicCommandWeb;
import com.redcompany.red.library.controller.command.webCommand.CommandManagerWeb;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletLibrary")
public class ServletLibrary  extends HttpServlet {

        public ServletLibrary() {
            super();

            System.out.println("constructor");
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            String action = req.getParameter("action");
            System.out.println("action: " + action);
            if(action!=null){
                BasicCommandWeb basicCommandWeb = CommandManagerWeb.defineAction(action);
                basicCommandWeb.performAction(req, resp);
            }


        }

        @Override
        protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
                throws ServletException, IOException {
            super.service(arg0, arg1);
            System.out.println("service");
        }

        @Override
        public void destroy() {
            super.destroy();
            System.out.println("destroy");
        }

        @Override
        public void init() throws ServletException {
            super.init();
            System.out.println("init");
        }

    }

