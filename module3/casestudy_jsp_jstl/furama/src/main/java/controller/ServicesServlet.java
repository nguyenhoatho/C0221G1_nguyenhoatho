package controller;

import model.bean.RentType;
import model.bean.ServiceType;
import model.bean.Services;
import model.service.IRentType;
import model.service.impl.RentTypeImpl;
import model.service.IServiceType;
import model.service.impl.ServiceTypeImpl;
import model.service.IServices;
import model.service.impl.ServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServicesServlet", urlPatterns = "/services")
public class ServicesServlet extends HttpServlet {
    IServices iServices = new ServicesImpl();
    IRentType iRentType = new RentTypeImpl();
    IServiceType iServiceType = new ServiceTypeImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request, response);
                break;
            default:
                break;
        }
    }


    private void createService(HttpServletRequest request, HttpServletResponse response) {
        String serviceID = request.getParameter("serviceID");
        String serviceName = request.getParameter("serviceName");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        int rentTypeID = Integer.parseInt(request.getParameter("rentTypeID"));
        int serviceTypeID = Integer.parseInt(request.getParameter("serviceTypeID"));;
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        String poolArea = request.getParameter("poolArea");
        String numberOfFloors = request.getParameter("numberOfFloors");
        if(standardRoom==""){
            standardRoom=null;
        }
        if(descriptionOtherConvenience==""){
            descriptionOtherConvenience=null;
        }
        if(poolArea==""){
            poolArea=null;
        }
        if(numberOfFloors==""){
            numberOfFloors=null;
        }

        List<RentType> rentTypeList = iRentType.getAllRentType();
        List<ServiceType> serviceTypeList = iServiceType.getAllServiceType();
        RentType rentType = iRentType.findRentTypeByID(rentTypeID);
        ServiceType serviceType = iServiceType.findServiceTypeByID(serviceTypeID);

        Services services = new Services(serviceID,serviceName, serviceArea, serviceCost, serviceMaxPeople, rentType, serviceType, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors);
        boolean check = iServices.createService(services);
        if (check) {
            request.setAttribute("message", "Create successful");
            request.setAttribute("rentTypeList", rentTypeList);
            request.setAttribute("serviceTypeList", serviceTypeList);
        } else {
            request.setAttribute("message", "Create unsuccessful");
            request.setAttribute("rentTypeList", rentTypeList);
            request.setAttribute("serviceTypeList", serviceTypeList);

        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service/create-service.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateServiceForm(request, response);
                break;
            default:
                break;
        }
    }


    private void showCreateServiceForm(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypeList = iRentType.getAllRentType();
        List<ServiceType> serviceTypeList = iServiceType.getAllServiceType();
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/create-service.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
