package motorcycle.controller;

import motorcycle.model.SampleProduct;
import motorcycle.services.ISampleProductServices;
import motorcycle.services.SampleProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name = "SampleProduct", value = "/sampleProduct")

public class SampleProductController extends HttpServlet {

    ISampleProductServices sampleProductServices = new SampleProductService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    addSampleProduct(request, response);
                    break;
                case "edit":
                    updateSampleProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    private void updateSampleProduct(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String brand = request.getParameter("brand");
        String type = request.getParameter("type");
        String line = request.getParameter("line");
        String color = request.getParameter("color");
        String year = request.getParameter("year");
        try {
            SampleProduct sampleProduct = sampleProductServices.updateSampleProduct(
                    new SampleProduct(id, brand, type, line,color,year));
            request.setAttribute("sampleProduct", sampleProduct);

            request.setAttribute("message", "Sample product information was updated");
            request.setAttribute("classCss", "message success");
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.setAttribute("classCss", "message error");
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("sampleProduct/edit.jsp");
        dispatcher.forward(request, response);

    }

    private void addSampleProduct(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String brand = request.getParameter("brand").trim();
        String type = request.getParameter("type").trim();
        String line = request.getParameter("line").trim();
        String color = request.getParameter("color").trim();
        String year = request.getParameter("year").trim();
        SampleProduct newSampleProduct = new SampleProduct(id, brand, type,line,color,year);
        try {
            sampleProductServices.addSampleProduct(newSampleProduct);
            request.setAttribute("message", "Sample product information was created");
            request.setAttribute("classCss", "message success");
        } catch (Exception e) {
            request.setAttribute("message", e.getMessage());
            request.setAttribute("classCss", "message error");
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("sampleProduct/create.jsp");
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
                    listSampleProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listSampleProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<SampleProduct> listSampleProduct = sampleProductServices.selectAllSampleProduct();
        request.setAttribute("listSampleProduct", listSampleProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sampleProduct/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        SampleProduct existingSampleProduct = sampleProductServices.getById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sampleProduct/edit.jsp");
        request.setAttribute("sampleProduct", existingSampleProduct);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("sampleProduct/create.jsp");
        dispatcher.forward(request, response);
    }

}
