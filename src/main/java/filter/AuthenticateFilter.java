package filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/welcome", "/inbox", "/compose", "/draft", "/sent", "/logout"})
public class AuthenticateFilter extends HttpFilter {

    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if(req.getSession(false)==null||req.getSession(false).getAttribute("authenticated")==null||!(boolean)req.getSession(false).getAttribute("authenticated")) {
            res.sendRedirect("hello?error=please login or register");
            return;
        }
            chain.doFilter(req, res);
    }
}
