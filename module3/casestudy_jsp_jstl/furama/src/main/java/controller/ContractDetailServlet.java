package controller;

import model.bean.*;
import model.service.IAttachService;
import model.service.impl.AttachServiceImpl;
import model.service.IContractDetail;
import model.service.impl.ContractDetailImpl;
import model.service.IContract;
import model.service.impl.ContractImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet",urlPatterns = "/contract-detail")
public class ContractDetailServlet extends HttpServlet {
    IContractDetail iContractDetail = new ContractDetailImpl();
    IContract iContract = new ContractImpl();
    IAttachService iAttachService = new AttachServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContractDetail(request, response);
                break;
            default:
                break;
        }
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int contractID = Integer.parseInt(request.getParameter("contractID"));
        String attachServiceID = (request.getParameter("attachServiceID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Contract contract = iContract.findContractByID(contractID);
        if(attachServiceID ==""){
            attachServiceID=null;
        }
        ContractDetail contractDetail = new ContractDetail(contract,attachServiceID,quantity);
        List<Contract> contractList = iContract.getAllContract();
        List<AttachService> attachServiceList = iAttachService.getAllAttachService();
        request.setAttribute("contractList", contractList);
        request.setAttribute("attachServiceList", attachServiceList);

        boolean check = iContractDetail.createContractDetail(contractDetail);
        if (check) {
            request.setAttribute("message", "Create successful");
            request.setAttribute("contractList", contractList);
            request.setAttribute("attachServiceList", attachServiceList);
        } else {
            request.setAttribute("message", "Create unsuccessful");
            request.setAttribute("contractList", contractList);
            request.setAttribute("attachServiceList", attachServiceList);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/contract_detail/create-contract-detail.jsp");
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
                showCreateContractDetailForm(request, response);
                break;
            default:
                break;
        }
    }

    private void showCreateContractDetailForm(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = iContract.getAllContract();
        List<AttachService> attachServiceList = iAttachService.getAllAttachService();
        request.setAttribute("contractList", contractList);
        request.setAttribute("attachServiceList", attachServiceList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract_detail/create-contract-detail.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
