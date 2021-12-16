package motorcycle.controller;

import motorcycle.model.User;
import motorcycle.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "HomeController", value = "/homePage")
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HomeController() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("signIn")) {
            checkSignIn(request, response);
        }
    }
    private void checkSignIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");

        UserService userService = new UserService();
        User user = userService.getUserByPhoneNumberAndPassword(phoneNumber, password);

        if (user == null) {
            String message = "Bạn đã nhập sai số điện thoại hoặc mật khẩu!";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/signIn.jsp");
            dispatcher.forward(request, response);

        } else {
            String role = String.valueOf(user.getRole());
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            request.setAttribute("user", user.getName());
            String next;
            switch (role) {
                case "SUPPER ADMIN":
                     next = "/view/supperAdmin.jsp";
                    break;
                case "ADMIN":
                    next = "/view/admin.jsp";
                    break;
                default:
                    next = "/view/home.jsp";
                    break;
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(next);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        System.out.println(action);
        switch (action) {
            case "signIn":
                signIn(request, response);
                break;
            case "logOut":
                logOut(request, response);
                break;
            default:
                homePage(request, response);
        }
    }

    private void signIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/signIn.jsp");
        dispatcher.forward(request, response);

    }

    private void logOut(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/home.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }



    private void homePage(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/home.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


}
