package service;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

@WebServlet(name = "HomeCards", urlPatterns = {"/home/cards"})
public class HomeCards extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        //int cardNumber = Integer.parseInt(request.getParameter("cnum"));

        String card[] = {"The first option the tool allows you to adjust is the number of random words to be generated.",
             "The first option the tool allows you to adjust is the number of random words to be generated.",
             "The first option the tool allows you to adjust is the number of random words to be generated.",
             "The first option the tool allows you to adjust is the number of random words to be generated."};

        String json = new Gson().toJson(card);
        
        response.getWriter().print(json);
        
        //ignore
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HomeCards.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
