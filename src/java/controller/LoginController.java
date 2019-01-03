
package controller;

import dao.DaoManager;
import dao.UserDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

public class LoginController extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String userId = request.getParameter("user");
        User user = null;
        UserDao dao = DaoManager.getUserDao();  // new UserDaoSql();
        
        user = dao.getUser(userId);
        
        if (user != null){
            //success
            request.getSession().setAttribute("user", new User("...", "..."));
        }
        else {
            //failed
        }
        
        //request.getSession().setAttribute("user", new User("sagar", ""));
        System.out.println (request.getContextPath());
        response.sendRedirect("/");
        
    }
}
