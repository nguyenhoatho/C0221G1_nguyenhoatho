import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DictionaryServlet",urlPatterns = "/dictionary")
public class DictionaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("One", "Một");
        dictionary.put("Two", "Hai");
        dictionary.put("Three", "Ba");
        dictionary.put("Four", "Bốn");
        dictionary.put("Five", "Năm");
        dictionary.put("Six", "Sáu");
        dictionary.put("Seven", "Bảy");
        dictionary.put("Eight", "Tám");
        dictionary.put("Nine", "Chín");
        dictionary.put("Ten", "Mười");

        String input = request.getParameter("txtInput");

        PrintWriter writer = response.getWriter();
        String result = dictionary.get(input);
        if(result!=null){
            writer.println("Word: " + input+"");
            writer.println("Result: " + result+"");
        } else {
            writer.println("Not found");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
