package controller;

import model.bean.Customer;
import model.service.customer.ICustomer;
import model.service.customer.impl.CustomerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomer iCustomer = new CustomerImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:

                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreateCustomer(request, response);
                break;
            case "edit":
                showFormEditCustomer(request, response);
                break;
            case "search":
                searchCustomerByName(request, response);
                break;
            default:
                showCustomerList(request, response);
                break;
        }
    }
    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customerTypeID = Integer.parseInt(request.getParameter("customerTypeID"));
        String customerName = request.getParameter("customerName");
        String customerBirthday = request.getParameter("customerBirthday");
        String customerGender = request.getParameter("customerGender");
        String customerIDCard = request.getParameter("customerIDCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        Customer customer = new Customer(customerTypeID, customerName, customerBirthday, customerGender, customerIDCard, customerPhone, customerEmail, customerAddress);
        boolean check = iCustomer.createCustomer(customer);
        if (check) {
            request.setAttribute("message", "Create successful");
        } else {
            request.setAttribute("message", "Create unsuccessful");
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/create-customer.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("customerID"));
        iCustomer.deleteCustomer(id);
        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        int customerTypeID = Integer.parseInt(request.getParameter("customerTypeID"));
        String customerName = request.getParameter("customerName");
        String customerBirthday = request.getParameter("customerBirthday");
        String customerGender = request.getParameter("customerGender");
        String customerIDCard = request.getParameter("customerIDCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        Customer customer = new Customer(customerID, customerTypeID, customerName, customerBirthday, customerGender, customerIDCard, customerPhone, customerEmail, customerAddress);
        boolean check = iCustomer.editCustomer(customer);
        if (check) {
            request.setAttribute("message", "Edit successful");
        } else {
            request.setAttribute("message", "Edit unsuccessful");
        }
        request.setAttribute("customer", customer);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/edit-customer.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void searchCustomerByName(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Customer> customerList = iCustomer.searchCustomerByName(search);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/list-customer.jsp");
        request.setAttribute("customer", customerList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/create-customer.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showFormEditCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("customerID"));
        Customer customer = iCustomer.findCustomerByID(id);
        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/view/customer/edit-customer.jsp");
            request.setAttribute("customer", customer);
        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = iCustomer.getAllCustomer();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/customer/list-customer.jsp");
        request.setAttribute("customer", customerList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
