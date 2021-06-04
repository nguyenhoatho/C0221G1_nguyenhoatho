package controller;

import model.bean.Employee;
import model.service.employee.IEmployee;
import model.service.employee.impl.EmployeeImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployee iEmployee = new EmployeeImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
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
                showFormCreateEmployee(request, response);
                break;
            case "edit":
                showFormEditEmployee(request, response);
                break;
            case "search":
                SearchEmployeeByName(request, response);
                break;
            default:
                showEmployeeList(request, response);
                break;
        }
    }
    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        String employeeIDCard = request.getParameter("employeeIDCard");
        Double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionID = Integer.parseInt(request.getParameter("positionID"));
        int educationDegreeID = Integer.parseInt(request.getParameter("educationDegreeID"));
        int divisionID = Integer.parseInt(request.getParameter("divisionID"));
        Employee employee = new Employee(employeeName, employeeBirthday, employeeIDCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionID, educationDegreeID, divisionID);
        boolean check = iEmployee.createEmployee(employee);
        if (check) {
            request.setAttribute("message", "Create successful");
        } else {
            request.setAttribute("message", "Create unsuccessful");
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/employee/create-employee.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int employeeID = Integer.parseInt(request.getParameter("employeeID"));
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        String employeeIDCard = request.getParameter("employeeIDCard");
        Double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionID = Integer.parseInt(request.getParameter("positionID"));
        int educationDegreeID = Integer.parseInt(request.getParameter("educationDegreeID"));
        int divisionID = Integer.parseInt(request.getParameter("divisionID"));
        Employee employee = new Employee(employeeID, employeeName, employeeBirthday, employeeIDCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionID, educationDegreeID, divisionID);
        boolean check = iEmployee.editEmployee(employee);
        if (check) {
            request.setAttribute("message", "Edit successful");
        } else {
            request.setAttribute("message", "Edit unsuccessful");
        }
        request.setAttribute("employee", employee);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/employee/edit-employee.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("employeeID"));
        iEmployee.deleteEmployee(id);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SearchEmployeeByName(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        List<Employee> employeeList = iEmployee.searchEmployeeByName(search);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/employee/list-employee.jsp");
        request.setAttribute("employee", employeeList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreateEmployee(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/create-employee.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEditEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("employeeID"));
        Employee employee = iEmployee.findEmployeeByID(id);
        RequestDispatcher requestDispatcher;
        if (employee == null) {
            requestDispatcher = request.getRequestDispatcher("/view/error-404.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("/view/employee/edit-employee.jsp");
            request.setAttribute("employee", employee);
        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = iEmployee.getAllEmployee();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/employee/list-employee.jsp");
        request.setAttribute("employee", employeeList);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
