import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ConverterServlet")
public class ConverterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        request.setAttribute("rate",rate);
        float usd = Float.parseFloat(request.getParameter("usd"));
        request.setAttribute("usd",usd);
        float vnd = rate * usd;
        request.setAttribute("vnd",vnd);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("rate.jsp");
        requestDispatcher.forward(request,response);
    }
}
