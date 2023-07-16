package iamneo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import iamneo.dao.ProjectDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");

        ProjectDAO projectDAO = new ProjectDAO();
        try {
            boolean result = projectDAO.deleteData(email);
            if (result) {
                response.sendRedirect("deletesuccess.html");
            } else {
                response.sendRedirect("deletefailure.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("deletefailure.html");
        }
    }
}

