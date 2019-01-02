
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
        
        User user = null;
        UserDao dao = DaoManager.getUserDao();
        
        if (dao.insertUser(user)){
            //success
        }
        else {
            //failed
        }
        
        RequestDispatcher view = request.getRequestDispatcher ("WEB-INF/index.jsp");
        view.forward(request, response);
        
    }
}
