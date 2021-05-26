import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ProductDiscountCalculator")
public class ProductDiscountCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("productDescription");
        request.setAttribute("productDescription",productDescription);
        double listPrice = Double.parseDouble(request.getParameter("listPrice"));
        request.setAttribute("listPrice",listPrice);
        double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));
        request.setAttribute("discountPercent",discountPercent);
        double discountAmount = listPrice * discountPercent * 0.01;
        request.setAttribute("discountAmount",discountAmount);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(request,response);



    }
}