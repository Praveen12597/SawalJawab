
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForgetPassword extends HttpServlet {

    public void doGet (HttpServletRequest request, HttpServletResponse response) {
        
        int id = Integer.parseInt(request.getParameter("fpid"));
        
        // if (isValid (id))
        
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/view/forget_password.jsp");
        
        //else raise Exception
    }

}
