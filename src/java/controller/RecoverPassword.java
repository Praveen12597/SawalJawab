package controller;

import dao.DaoManager;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utility.MailUtil;

@WebServlet(name = "RecoverPassword", urlPatterns = {"/user/recover-password"})
public class RecoverPassword extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String rid = request.getParameter("recoverId");
        UserDao dao = DaoManager.getUserDao();

        if (rid == null) {
            String username = request.getParameter("username");

            String email = dao.getEmailByUsername(username);

            //generate recover id and store it do db and then send email
            String recoverId = "";//randomString

            //dao.insertRecoverId(recoverId);

            //send email
            String mailTxt = "<!DOCTYPE HTML>"
                    + "<html>"
                    + "<body>"
                    + "<p>To Reset your password visit <a href='localhost:8080/user/recover-password" + recoverId + "'>."
                    + "</p>"
                    + "</body>"
                    + "</html>";

            String mailSubject = "Reset Your Password";

            MailUtil.sendMail(email, mailTxt, mailSubject);

            response.sendRedirect("/");
        } 
        
        else {
            //check if rid valid
            //show reset page
        }

    }

}
