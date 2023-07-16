package iamneo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kce.model.RegisterForm;

import iamneo.model.Project;
import iamneo.util.DBUtil;

public class ProjectDAO {
 
    public boolean insertData(Project p) throws SQLException{
    	Connection con=DBUtil.createConnection();
    	String query = "insert into Project values(?,?,?,?,?,?)";
    	//String query = "insert into RegisterForm(Name,Email,RegisterNo,PhoneNo,password) values(?,?,?,?,?)";
    	try {
    	PreparedStatement pstmt = con.prepareStatement(query);
    	pstmt.setString(1, p.getName());
        pstmt.setString(2, p.getEmail());
        pstmt.setString(3, p.getDob());
        pstmt.setString(4, p.getAddress());
        pstmt.setString(5, p.getPhoneNo());
        pstmt.setString(6, p.getPassword());
    
    	int count = pstmt.executeUpdate();
    	
    	System.out.println(count);
    	if (count>0) {
     return true;
    	}else {
    		return false;
    	}
    	}catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    	return false;
    	}
    
    public List<Project> Display() throws SQLException {
        List<Project> projectList = new ArrayList<>();
        Connection con = DBUtil.createConnection();
        String query = "SELECT * FROM Project";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                String email = rs.getString("Email");
                String dob = rs.getString("DOB");
                String address = rs.getString("Address");
                String phoneNo = rs.getString("PhoneNo");
                String password = rs.getString("Password");
               
                Project project = new Project(name, email, dob, address, phoneNo, password);
                projectList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return projectList;
    }

    public boolean deleteData(String email) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBUtil.createConnection();
            String query = "DELETE FROM Project WHERE email=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,email);

            int count = pstmt.executeUpdate();

            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // Close resources in the finally block
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

public static boolean updateData(Project p) throws SQLException {
    Connection con = null;
    PreparedStatement pstmt = null;
    boolean success = false;

    try {
        con = DBUtil.createConnection();
        String query = "UPDATE Project SET Name=?, DOB=?,Address=?, PhoneNo=?, Password=? WHERE Email=?";
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, p.getName());
        pstmt.setString(2, p.getDob());
        pstmt.setString(3, p.getAddress());
        pstmt.setString(4, p.getPhoneNo());
        pstmt.setString(5, p.getPassword());
        pstmt.setString(6, p.getEmail());

        int count = pstmt.executeUpdate();

        if (count > 0) {
            success = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (pstmt != null) {
            pstmt.close();
        }
        if (con != null) {
            con.close();
        }
    }

    return success;
}

    
}
