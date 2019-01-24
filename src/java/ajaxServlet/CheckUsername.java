package ajaxServlet;

import dao.DaoManager;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CheckUsername", urlPatterns = {"/user/username-available"})
public class CheckUsername extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao dao = DaoManager.getUserDao();
        String username = request.getParameter("username");

        //testing ajax
        if (username.equals("sagar")) {
            response.getWriter().print(true);
        } else {
            response.getWriter().print(false);
        }

        //boolean status = dao.usernameExist(username);
        //PrintWriter out = response.getWriter();
        //out.print(status);
    }

}
