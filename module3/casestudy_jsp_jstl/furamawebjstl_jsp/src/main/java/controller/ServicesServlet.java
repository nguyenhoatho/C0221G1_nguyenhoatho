package controller;

import model.bean.Customer;
import model.bean.Services;
import model.service.services.IServices;
import model.service.services.impl.ServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServicesServlet",urlPatterns ="/services")
public class ServicesServlet extends HttpServlet {
    IServices iServices = new ServicesImpl();
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
    private void createRoom(HttpServletRequest request, HttpServletResponse response) {
        String serviceName = request.getParameter("serviceName");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        int rentTypeID = Integer.parseInt(request.getParameter("rentTypeID"));
        int serviceTypeID = 3;
        Services room = new Services(serviceName,serviceArea,serviceCost,serviceMaxPeople,rentTypeID,serviceTypeID);
        boolean check = iServices.createVillaService(room);
        if (check) {
            request.setAttribute("message", "Create successful");
        } else {
            request.setAttribute("message", "Create unsuccessful");
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
        Services house = new Services(serviceName,serviceArea,serviceCost,serviceMaxPeople,rentTypeID,serviceTypeID,standardRoom,descriptionOtherConvenience,numberOfFloors);
        boolean check = iServices.createVillaService(house);
        if (check) {
            request.setAttribute("message", "Create successful");
        } else {
            request.setAttribute("message", "Create unsuccessful");
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
        Services villa = new Services(serviceName,serviceArea,serviceCost,serviceMaxPeople,rentTypeID,serviceTypeID,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors);
        boolean check = iServices.createVillaService(villa);
        if (check) {
            request.setAttribute("message", "Create successful");
        } else {
            request.setAttribute("message", "Create unsuccessful");
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

    private void showCreateRoomForm(HttpServletRequest request, HttpServletResponse response) {
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
