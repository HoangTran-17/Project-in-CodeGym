package motorcycle.controller;

import motorcycle.model.Role;
import motorcycle.model.User;
import motorcycle.model.UserStatus;
import motorcycle.services.IUserService;
import motorcycle.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static motorcycle.model.UserStatus.AVAILABLE;

@WebServlet(name = "Admin", value = "/admin")
public class AdminController extends HttpServlet {
    IUserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createUser":
                    addUser(request, response);
                    break;
                case "createAdmin":
                    addAdmin(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, ServletException, IOException {
        long userId = Long.parseLong(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        Role role = Role.fromValue(request.getParameter("role"));
        UserStatus status = UserStatus.fromValue(request.getParameter("status"));
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String password = request.getParameter("password");

        try {
            User user = userService.updateUser(new User(userId, userName,status,role, phoneNumber, address,password));
            request.setAttribute("user", user);
            request.setAttribute("statusList", UserStatus.values());
            request.setAttribute("message", "Customer information was updated");
            request.setAttribute("classCss", "message success");
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.setAttribute("classCss", "message error");
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String userName = request.getParameter("userName").trim();
        String phoneNumber = request.getParameter("phoneNumber").trim();
        long userId = Long.parseLong(phoneNumber.substring(phoneNumber.length()-10));
        String address = request.getParameter("address").trim();
        String password = request.getParameter("password".trim());

        User newUser = new User(userId, userName, AVAILABLE, Role.USER, phoneNumber, address, password);
        try {
            userService.addUser(newUser);
            request.setAttribute("message", "Tài khoản người dùng đã được tạo");
            request.setAttribute("classCss", "message success");
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.setAttribute("classCss", "message error");
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/createUser.jsp");
        dispatcher.forward(request, response);
    }
    private void addAdmin(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String name = request.getParameter("adminName").trim();
        String phoneNumber = request.getParameter("phoneNumber").trim();
        long id = Long.parseLong(phoneNumber);
        String password = request.getParameter("password".trim());

        User newUser = new User(id,name, AVAILABLE, Role.ADMIN, phoneNumber, "CodeGym", password);
        try {
            userService.addUser(newUser);
            request.setAttribute("message", "Tài khoản admin đã được tạo");
            request.setAttribute("classCss", "message success");
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.setAttribute("classCss", "message error");
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/createAdmin.jsp");
        dispatcher.forward(request, response);
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createUser":
                    showNewUser(request, response);
                    break;
                case "createAdmin":
                    showNewAdmin(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "listAdmin":
                    listAdmin(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<User> listUser = userService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/listUser.jsp");
        dispatcher.forward(request, response);
    }

    private void listAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<User> listAdmin = userService.selectAllAdmins();
        request.setAttribute("listAdmin", listAdmin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/listAdmin.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        User existingUser = userService.getById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/edit.jsp");
        request.setAttribute("user", existingUser);
        request.setAttribute("statusList", UserStatus.values());
        dispatcher.forward(request, response);
    }

    private void showNewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/createUser.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/createAdmin.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        userService.deleteUser(id);
        List<User> listUser = userService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/list.jsp");
        dispatcher.forward(request, response);
    }
}
