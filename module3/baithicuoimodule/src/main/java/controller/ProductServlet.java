package controller;

import model.bean.Product;
import model.service.CategoryService;
import model.service.ProductService;
import model.service.impl.CategoryServiceimlp;
import model.service.impl.ProductServiceimpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    ProductService productService=new ProductServiceimpl();
    CategoryService categoryService=new CategoryServiceimlp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "search" :
                searchNameProduct(request,response);

            default:
                break;
    }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.getAllProduct();
        request.setAttribute("products",products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/product/list.jsp");
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void searchNameProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        List<Product> productList = new ArrayList<>();
        productList=productService.searchProductByName(name);
        RequestDispatcher requestDispatcher = null;
        if(productList.size() == 0){
            requestDispatcher = request.getRequestDispatcher("/view/product/error-404.jsp");
        }else {
            request.setAttribute("products",productList);
            requestDispatcher = request.getRequestDispatcher("/view/product/show.jsp");

        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();



        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.f(id);
        RequestDispatcher dispatcher ;
        if(product == null){
            dispatcher = request.getRequestDispatcher("/view/product/error-404.jsp");
        }else {
            this.productService.remove(product.getId());
            try {
                response.sendRedirect("/product");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("des");
        String manufacture = request.getParameter("manu");
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("/view/product/error-404.jsp");
        }else {
            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);
            product.setManufacturers(manufacture);
            this.productService.update(id,product);
            request.setAttribute("product",product);
            request.setAttribute("message","Product informantion was updated");
            dispatcher = request.getRequestDispatcher("/view/product/edit.jsp");
        }
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("des");
        String manufacture = request.getParameter("manu");

        Product product = new Product();
        this.productService.createProduct(product);
        request.setAttribute("message","New products was created");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
