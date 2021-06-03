package controller;

import model.bean.Customer;
import model.service.CustomerService;
import model.service.lmlp.CustomerServicelmlp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns ={"","/customer"} )
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerServicelmlp();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

            switch (action) {
                case "create":
                    createCustomer(request,response);
                    break;
                case "edit":
                    try {
                        updateCustomerFurama(request,response);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case "search":
                    searchCustomerFurama(request,response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            case "delete":

                    deleteCustomer(request, response);
                    break;
            case "view":
                viewCustomer(request,response);
            default:
                listCustomer(request, response);
                break;
        } } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {

    }

    private void searchCustomerFurama(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameSearch=request.getParameter("name");
        List<Customer> customers=customerService.searchCustomer(nameSearch);
        request.setAttribute("cusotmers",customers);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/customer/list-customer.jsp");
        requestDispatcher.forward(request,response);

    }
    private void updateCustomerFurama(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
            int customerId=Integer.parseInt(request.getParameter("customerId"));
            int customerTypeId=Integer.parseInt(request.getParameter("customerTypeId"));
            String customerName=request.getParameter("customerName");
            String customerBirthday=request.getParameter("customerBirthday");
            int customerGender =Integer.parseInt(request.getParameter("customerGender"));
            String customerIdCard=request.getParameter("customerIdCard");
            String customerPhone =request.getParameter("customerPhone");
            String customerEmail=request.getParameter("customerEmail");
            String customerAddress=request.getParameter("customerAddress");
            Customer customer1=new Customer(customerId,customerName,customerBirthday,customerGender,customerIdCard,
                    customerPhone,customerEmail,customerTypeId,customerAddress);
            customerService.updateCustomer(customer1);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/customer/edit-customer.jsp");
             requestDispatcher.forward(request,response);


    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {

    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers =customerService.selectAll();
        request.setAttribute("customers",customers);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/customer/list-customer.jsp");
        requestDispatcher.forward(request,response);

    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int customerId=Integer.parseInt(request.getParameter("id"));
        customerService.deleteCustomer(customerId);
        List<Customer> customers=customerService.selectAll();
        request.setAttribute("customers",customers);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/customer/list-customer.jsp");
        requestDispatcher.forward(request,response);

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerService.selectCustomer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit-customer.jsp");
        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("view/customer/create-customer.jsp");
        requestDispatcher.forward(request,response);
    }
}
