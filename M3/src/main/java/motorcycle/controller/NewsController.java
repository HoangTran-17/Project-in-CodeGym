package motorcycle.controller;

import motorcycle.model.News;
import motorcycle.services.INewsService;
import motorcycle.services.NewsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name = "News", value = "/news")

public class NewsController extends HttpServlet {

        INewsService newsService = new NewsService();

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            try {
                switch (action) {
                    case "create":
                        addNew(request, response);
                        break;
                    case "edit":
                        updateNew(request, response);
                        break;
                }

            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }


        private void updateNew(HttpServletRequest request, HttpServletResponse response) throws
                SQLException, ServletException, IOException {
            long id = Long.parseLong(request.getParameter("id"));
            long userId = Long.parseLong(request.getParameter("userId"));
            String brand = request.getParameter("brand");
            String type = request.getParameter("type");
            String line = request.getParameter("line");
            String color = request.getParameter("color");
            int year = Integer.parseInt(request.getParameter("year"));
            String km = request.getParameter("km");
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");

            try {
                News news = newsService.update(new News(id, userId, brand,type,line,color,year,km, price,description));
                request.setAttribute("news", news);

                request.setAttribute("message", "News information was updated");
                request.setAttribute("classCss", "message success");
            } catch (Exception e) {
                request.setAttribute("message", e.getMessage());
                request.setAttribute("classCss", "message error");
                e.printStackTrace();
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("news/edit.jsp");
            dispatcher.forward(request, response);

        }

        private void addNew(HttpServletRequest request, HttpServletResponse response) throws
                ServletException, IOException {
            long id = Long.parseLong("0912345678");
            if (request.getParameter("userId") != null) {
                 id = Long.parseLong(request.getParameter("userId"));
            }
            long userId = id;
            String brand = request.getParameter("brand").trim();
            String type = request.getParameter("type").trim();
            String line = request.getParameter("line").trim();
            String color = request.getParameter("color").trim();
            int year = Integer.parseInt(request.getParameter("year"));
            String km = request.getParameter("km").trim();
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description").trim();

            News news = new News(id, userId,brand,type,line,color,year,km,price,description);
            try {
                newsService.create(news);
                request.setAttribute("message", "News information was created");
                request.setAttribute("classCss", "message success");
            } catch (Exception e) {
                request.setAttribute("message", e.getMessage());
                request.setAttribute("classCss", "message error");
                e.printStackTrace();
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("news/create.jsp");
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
                    case "create":
                        showNewForm(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    default:
                        listNews(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }

        private void listNews(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
            List<News> listNews = newsService.selectAllNews();
            request.setAttribute("listNews", listNews);
            RequestDispatcher dispatcher = request.getRequestDispatcher("news/list.jsp");
            dispatcher.forward(request, response);
        }

        private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            long id = Long.parseLong(request.getParameter("id"));

            News existingUser = newsService.getById(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("news/edit.jsp");
            request.setAttribute("news", existingUser);
            dispatcher.forward(request, response);
        }

        private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
            dispatcher.forward(request, response);
        }
    }
