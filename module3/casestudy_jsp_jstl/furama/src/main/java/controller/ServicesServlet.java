package controller;

import model.bean.Customer;
import model.bean.RentType;
import model.bean.ServiceType;
import model.bean.Services;
import model.service.rent_type.IRentType;
import model.service.rent_type.impl.RentTypeImpl;
import model.service.service_type.IServiceType;
import model.service.service_type.impl.ServiceTypeImpl;
import model.service.services.IServices;
import model.service.services.impl.ServicesImpl;

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
            case "villa":
                createVilla(request, response);
                break;
            case "house":
                createHouse(request, response);
                break;
            case "room":
                createRoom(request, response);
                break;
            default:
                break;
        }
    }

    private void createRoom(HttpServletRequest request, HttpServletResponse response) {
        String serviceName = request.getParameter("serviceName");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        int rentTypeID = Integer.parseInt(request.getParameter("rentTypeID"));
        int serviceTypeID = 3;
        RentType rentType = iRentType.findRentTypeByID(rentTypeID);
        ServiceType serviceType = iServiceType.findServiceTypeByID(serviceTypeID);
        List<RentType> rentTypeList = iRentType.getAllRentType();
        Services room = new Services(serviceName, serviceArea, serviceCost, serviceMaxPeople, rentType, serviceType);
        boolean check = iServices.createVillaService(room);
        if (check) {
            request.setAttribute("message", "Create successful");
            request.setAttribute("rentTypeList", rentTypeList);

        } else {
            request.setAttribute("message", "Create unsuccessful");
            request.setAttribute("rentTypeList", rentTypeList);

        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service/create-room.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createHouse(HttpServletRequest request, HttpServletResponse response) {
        String serviceName = request.getParameter("serviceName");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        int rentTypeID = Integer.parseInt(request.getParameter("rentTypeID"));
        int serviceTypeID = 2;
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));

        RentType rentType = iRentType.findRentTypeByID(rentTypeID);
        ServiceType serviceType = iServiceType.findServiceTypeByID(serviceTypeID);
        List<RentType> rentTypeList = iRentType.getAllRentType();
        Services house = new Services(serviceName, serviceArea, serviceCost, serviceMaxPeople, rentType, serviceType, standardRoom, descriptionOtherConvenience, numberOfFloors);
        boolean check = iServices.createVillaService(house);
        if (check) {
            request.setAttribute("message", "Create successful");
            request.setAttribute("rentTypeList", rentTypeList);

        } else {
            request.setAttribute("message", "Create unsuccessful");
            request.setAttribute("rentTypeList", rentTypeList);

        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service/create-house.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createVilla(HttpServletRequest request, HttpServletResponse response) {
        String serviceName = request.getParameter("serviceName");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        int rentTypeID = Integer.parseInt(request.getParameter("rentTypeID"));
        int serviceTypeID = 1;
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        List<RentType> rentTypeList = iRentType.getAllRentType();
        RentType rentType = iRentType.findRentTypeByID(rentTypeID);
        ServiceType serviceType = iServiceType.findServiceTypeByID(serviceTypeID);

        Services villa = new Services(serviceName, serviceArea, serviceCost, serviceMaxPeople, rentType, serviceType, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors);
        boolean check = iServices.createVillaService(villa);
        if (check) {
            request.setAttribute("message", "Create successful");
            request.setAttribute("rentTypeList", rentTypeList);

        } else {
            request.setAttribute("message", "Create unsuccessful");
            request.setAttribute("rentTypeList", rentTypeList);

        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/service/create-villa.jsp");
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
            case "villa":
                showCreateVillaForm(request, response);
                break;
            case "house":
                showCreateHouseForm(request, response);
                break;
            case "room":
                showCreateRoomForm(request, response);
                break;
            default:
                break;
        }
    }

    private void showCreateRoomForm(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypeList = iRentType.getAllRentType();
        request.setAttribute("rentTypeList", rentTypeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/create-room.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateHouseForm(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypeList = iRentType.getAllRentType();
        request.setAttribute("rentTypeList", rentTypeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/create-house.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateVillaForm(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypeList = iRentType.getAllRentType();
        request.setAttribute("rentTypeList", rentTypeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/create-villa.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
