package controller;

import model.bean.Product;
import model.service.ProductService;
import model.service.impl.ProductImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = {"","/product"})
public class ProductServlet extends HttpServlet {
    private ProductService productService=new ProductImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case"create":
                creatProduct(request,response);
                break;
            case"edit":
                updateProduct(request,response);
                break;
            case"delete":
                deleteProduct(request,response);
                break;
            case"search":
                searchProduct(request,response);
            default:
                break;


        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String dateOfManufacture=request.getParameter("dateOfManufacture");
        String expiryDate=request.getParameter("expiryDate");
        String origin=request.getParameter("origin");
        Product product =productService.findById(id);
        RequestDispatcher requestDispatcher = null;


        if (product==null){
            requestDispatcher=request.getRequestDispatcher("/view/product/error.jsp");
        }
        else {
            product.setName(name);
            product.setDateOfManufacture(dateOfManufacture);
            product.setExpiryDate(expiryDate);
            product.setOrigin(origin);
            productService.update(id,product);
            request.setAttribute("product",product);
            request.setAttribute("message","update success");
            requestDispatcher = request.getRequestDispatcher("/view/product/edit.jsp");

        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        List<Product> productList=productService.findByName(name);
        RequestDispatcher requestDispatcher=null;
        if (productList.size()==0){
            requestDispatcher = request.getRequestDispatcher("/view/product/error.jsp");
        }
        else {
            request.setAttribute("productList",productList);
            requestDispatcher=request.getRequestDispatcher("/view/product/show.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        Product product=productService.findById(id);
        RequestDispatcher requestDispatcher;
        if (product==null){
            requestDispatcher=request.getRequestDispatcher("/view/product/error.jsp");
        }
        else {
            this.productService.remove(product.getId());
            try {
                response.sendRedirect("/product");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private void creatProduct(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String dateOfManufacture=request.getParameter("dateOfManufacture");
        String expiryDate=request.getParameter("expiryDate");
        String origin=request.getParameter("origin");
        Product product=new Product(id,name,dateOfManufacture,expiryDate,origin);

       this.productService.save(product);
        request.setAttribute("message","creat product success");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/product/creatProduct.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreate(request,response);
                break;
            case"delete":
                showDelete(request,response);
                break;
            case"view":
                showView(request,response);
                break;
            case"search":
                showSearch(request,response);
                break;
            case"edit":
                showEdit(request,response);
            default:
                productList(request,response);
                break;
        }

    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("/view/product/error.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/view/product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showView(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        Product product=productService.findById(id);
        RequestDispatcher requestDispatcher;
        if (product==null){
            requestDispatcher=request.getRequestDispatcher("/view/product/error.jsp");
        }
        else {
            request.setAttribute("product",product);
            requestDispatcher=request.getRequestDispatcher("/view/product/view.jsp");
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void productList(HttpServletRequest request, HttpServletResponse response) {
        List<Product>productList=productService.findAll();
        request.setAttribute("productList",productList);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/product/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/product/search.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product=productService.findById(id);
        RequestDispatcher requestDispatcher;
        if (product==null){
            requestDispatcher=request.getRequestDispatcher("/view/product/error.jsp");

        }else {
            requestDispatcher=request.getRequestDispatcher("/view/product/delete.jsp");
        }
        try{
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher requestDispatcher;
        if (product==null){
            requestDispatcher=request.getRequestDispatcher("/view/product/error.jsp");
        }else {
            request.setAttribute("product",product);
            requestDispatcher=request.getRequestDispatcher("/view/product/create.jsp");
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
