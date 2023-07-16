package iamneo.servlet;
import java.io.IOException;
import java.sql.SQLException;
import iamneo.dao.ProjectDAO;
import iamneo.model.Project;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		Project robj=new Project();
		robj.setName(req.getParameter("name"));
		robj.setEmail(req.getParameter("email"));
		robj.setDob(req.getParameter("dob"));
		robj.setAddress(req.getParameter("address"));
		robj.setPhoneNo(req.getParameter("pno"));
		robj.setPassword(req.getParameter("password"));
		
		ProjectDAO rdao=new ProjectDAO();
		boolean result=false;
		try {
			result = rdao.insertData(robj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		res.setContentType("text/html");
		if(result==true) {
			res.sendRedirect("addsuccess.html");
		}
		else {
			res.sendRedirect("addfailure.html");

		}
		}
		
}
