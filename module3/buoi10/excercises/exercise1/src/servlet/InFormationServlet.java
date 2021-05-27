package servlet;

import models.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "InFormationServlet", urlPatterns = "/information")
public class InFormationServlet extends HttpServlet {
    List<Customer> customerList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "https://static2.yan.vn/YanNews/2167221/201704/20170412-053503-mickey_mouse_as_mike_brady_600x654.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "https://static2.yan.vn/YanNews/2167221/201704/20170412-053503-mickey_mouse_as_mike_brady_600x654.jpg"));
        customerList.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "https://1.bp.blogspot.com/-ZpB2jsY0Ozg/XVUb38NxumI/AAAAAAAADk8/DTcG-fHF670Y-tUQ0AxfWjSfZdWmMNTBACLcBGAs/s1600/chia-se-stock-bo-anh-chan-dung-em-va-sen-cua-nhiep-anh-gia-tran-thai-son1.jpg"));
        customerList.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hà tây", "https://buistudio.vn/wp-content/uploads/2019/07/chup-anh-chan-dung-dep-9.jpg"));
        customerList.add(new Customer("Nguyễn Đình Thi", "1983-08-19", "Hà Nội", "https://static2.yan.vn/YanNews/2167221/201704/20170412-053503-mickey_mouse_as_mike_brady_600x654.jpg"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customers", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/page/information.jsp");
        requestDispatcher.forward(request, response);
    }
}
