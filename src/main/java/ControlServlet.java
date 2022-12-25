import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    private String currentUser;
    private HttpSession session = null;

    public ControlServlet() {
    }

    @Override
    public void init() {
        userDAO = new UserDAO();
        currentUser = "";
    }

    // No post handling
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    // Handle recieved action
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println("Got action: " + action);

        try {
            switch (action) {
                case "/login":
                    login(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        System.out.println("Page loaded - now trying to connect.");
        userDAO.test();
        System.out.println("Connection established!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("test.jsp");
        dispatcher.forward(request, response);
    }
}
