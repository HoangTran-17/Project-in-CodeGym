package motorcycle.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Home", value = "/home")
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/homePage.jsp");
            dispatcher.forward(request, response);
        }

    }
}