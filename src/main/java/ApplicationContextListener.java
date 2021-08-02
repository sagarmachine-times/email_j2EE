
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.sql.Connection;
import java.sql.SQLException;

@WebListener
public class ApplicationContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc= sce.getServletContext();
        try {
        	String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/emailersystem";
			String u="root";
			String p="";
            DBManager dbManager= new DBManager(url,u,p);
            Connection connection= dbManager.getConnection();
            sc.setAttribute("connection", connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext= sce.getServletContext();
        if(servletContext.getAttribute("connection")!=null) {
            Connection connection = (Connection) servletContext.getAttribute("connection");
            try {
                connection.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
}
