package servlet;
import java.io.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/hello")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        if (request.getSession(false) == null || request.getSession(false).getAttribute("authenticated") == null || !(boolean) request.getSession(false).getAttribute("authenticated")) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Hello</h1>");
            if (request.getParameter("error") != null)
                out.println("<h3 style=\"color:red\">" + request.getParameter("error") + "</h3>");
            out.println("<a href=\"login\"><button style=\"background-color:blue\">login</button></a>");
            out.println("<a href=\"register\"><button style=\"background-color:green\">register</button></a>");
            out.println("<a href=\"about\"><button >about</button></a>");
            out.println("</body></html>");
        } else
            response.sendRedirect("welcome");
    }

}