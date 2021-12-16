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

@WebServlet(name = "User", value = "/users")
public class UserController extends HttpServlet {
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
                case "editUser":
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
        String phoneNumber = "0" + String.valueOf(userId);
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        if (password.equals(password2)) {
            try {
            User user = userService.updateUser(new User(userId, userName,AVAILABLE,Role.USER, phoneNumber, address,password));
            request.setAttribute("user", user);
            request.setAttribute("statusList", UserStatus.values());
            request.setAttribute("message", "Cập nhật tài khoản thành công!");
            request.setAttribute("classCss", "message success");
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.setAttribute("classCss", "message error");
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/editUser.jsp");
        dispatcher.forward(request, response);
        }else {
            request.setAttribute("message","Mật khẩu không khớp!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("users/editUser.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String userName = request.getParameter("userName");
        String phoneNumber = request.getParameter("phoneNumber");
        long userId = Long.parseLong(phoneNumber.substring(phoneNumber.length()-10));
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");

        if (password.equals(password2)) {
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
        else {
            request.setAttribute("message","Mật khẩu không khớp!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("users/createUser.jsp");
            dispatcher.forward(request, response);
        }

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
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                default:
                    home(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void home(HttpServletRequest request, HttpServletResponse response) {
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        User existingUser = userService.getById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/editUser.jsp");
        request.setAttribute("user", existingUser);
        request.setAttribute("statusList", UserStatus.values());
        dispatcher.forward(request, response);
    }

    private void showNewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/createUser.jsp");
        dispatcher.forward(request, response);
    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        long id = Long.parseLong(request.getParameter("userId"));
        userService.deleteUser(id);
        List<User> listUser = userService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/home.jsp");
        dispatcher.forward(request, response);
    }
}
