package controller;

import model.bean.AttachService;
import model.bean.CustomerUsingService;
import model.service.IAttachService;
import model.service.impl.AttachServiceImpl;
import model.service.ICustomerUsingService;
import model.service.impl.CustomerUsingServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerUsingServiceServlet" ,urlPatterns = "/customer-using-service")
public class CustomerUsingServiceServlet extends HttpServlet {
    ICustomerUsingService iCustomerUsingService = new CustomerUsingServiceImpl();
    IAttachService iAttachService = new AttachServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "search":
                searchCustomerUsingServiceByName(request, response);
                break;
            default:
                showListCustomerUsingService(request,response);
                break;
        }
    }

    private void searchCustomerUsingServiceByName(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<CustomerUsingService> customerUsingServiceList = iCustomerUsingService.searchCustomerUsingServiceByName(search);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer_using_service/list-customer-using-service.jsp");
        request.setAttribute("customerUsingServiceList", customerUsingServiceList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomerUsingService(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerUsingService> customerUsingServiceList = iCustomerUsingService.getAllCustomerUsingService();
        List<CustomerUsingService> attachServiceList = iCustomerUsingService.getAllAttachServiceUsing();
        request.setAttribute("customerUsingServiceList", customerUsingServiceList);
        request.setAttribute("attachServiceList", attachServiceList);
        try {
            RequestDispatcher requestDispatcher =request.getRequestDispatcher("/view/customer_using_service/list-customer-using-service.jsp");
            requestDispatcher.forward(request,response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
