package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/welcome")
public class WelcomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");



        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<h1>Welcome "+req.getSession(false).getAttribute("name")+"</h1>");
        out.println("<a href=\"compose\"><button>compose</button></a>");
        out.println("<a href=\"inbox\"><button>inbox</button></a>");
        out.println("<a href=\"sent\"><button>sent</button></a>");
        out.println("<a href=\"draft\"><button>draft</button></a>");
        out.println("<a href=\"about\"><button >about</button></a>");
        out.println("<a href=\"logout\"><button style=\"color:red\">logout</button></a>");
        out.println("</body></html>");
    }

}
