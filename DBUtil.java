package iamneo.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {
public static Connection connection;
public static Connection createConnection(){
try{
	Class.forName("com.mysql.cj.jdbc.Driver");  
}catch(ClassNotFoundException e){
e.printStackTrace();
}
System.out.print("sucess");
try{
connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Pushpa29@");
}catch(SQLException e){
e.printStackTrace();
}
return connection;
}}