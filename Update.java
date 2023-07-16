package iamneo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.kce.dao.RegisterFormDAO;
import com.kce.model.RegisterForm;

import iamneo.dao.ProjectDAO;
import iamneo.model.Project;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Update")
public class Update extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the form data
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String phoneNo = request.getParameter("phoneNo");
        String password = request.getParameter("password");

        // Create a RegisterForm object
        
        Project project = new Project(name, email, dob, address, phoneNo,password);

        // Create an instance of RegisterFormDAO
        ProjectDAO projectDAO = new ProjectDAO();

        // Update the data in the database
		boolean result=true;
		try {
			result = ProjectDAO.updateData(project);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result) {
		    // Redirect to success page
		    response.sendRedirect("updatesuccess.html");
		} else {
		    // Redirect to failure page
		    response.sendRedirect("updatefailure.html");
		}
    }
}
