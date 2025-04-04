package ServicesDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Student;

public class Conn {
	private static String url="jdbc:postgresql://localhost:5432/school1result?user=postgres&password=123";
	private static  Connection con;
	static {
		try {
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection(url);
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			
			System.out.println("Class not found postgresql Driver");
			
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			
			System.out.println("Database not connected !!!");
		}
	}
	
	
	

	public boolean idExists(int id) {
	    String sql = "SELECT 1 FROM register WHERE \"ID\"=?";
	    try (PreparedStatement pstm = con.prepareStatement(sql)) {
	        pstm.setInt(1, id);
	        try (ResultSet rs = pstm.executeQuery()) {
	            return rs.next(); // Returns true if ID exists
	        }
	    } catch (SQLException e) {
	        System.err.println("Error checking ID existence");
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	public int add(int id, String name, int age, String gender, String dob, 
               String email, String mobile, String address, String studentClass) {
    int res = 0;
    String sql = "INSERT INTO register VALUES(?,?,?,?,?,?,?,?,?)";
    
    try (PreparedStatement pstm = con.prepareStatement(sql)) {
    	System.out.println("data is adding");
        pstm.setInt(1, id);
        pstm.setString(2, name);
        pstm.setInt(3, age);
        pstm.setString(4, gender);
        pstm.setString(5, dob);
        pstm.setString(6, email);
        pstm.setString(7, mobile);
        pstm.setString(8, address);
        pstm.setString(9, studentClass);
        
        res = pstm.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Error inserting student record");
        e.printStackTrace();
    }
    return res;
}
	public static List<Student> getAllStudents() {
	    List<Student> students = new ArrayList<>();
	    String sql = "SELECT * FROM register ORDER BY \"ID\" ASC";
	    
	    try (PreparedStatement stmt = con.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {
	        
	        System.out.println("Fetching all student records...");
	        
	        while (rs.next()) {
	            students.add(new Student(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getInt("age"),
	                rs.getString("gender"),
	                rs.getString("dob"),
	                rs.getString("email"),
	                rs.getString("mobile"),
	                rs.getString("address"),
	                rs.getString("studentClass")
	            ));
	        }
	    } catch (SQLException e) {
	        System.err.println("Error fetching students: " + e.getMessage());
	        e.printStackTrace();
	        throw new RuntimeException("Database error while fetching students", e);
	    }
	    
	    System.out.println("Fetched " + students.size() + " student records");
	    return students;
	}
	
	public int update(int id, String name, int age, String gender, String dob, 
            String email, String mobile, String address, String studentClass)
	{
		int res = 0;
//		String sql = "UPDATE register SET name=?, age=?, gender=?, dob=?, email=?, mobile=?, address=?, StudentClass=? WHERE ID=?";
		String sql = "UPDATE register\n" +
	             "SET name=?, age=?, gender=?, dob=?,\n" +
	             "    email=?, mobile=?, address=?, \"studentClass\"=?\n" +
	             "WHERE \"ID\"=?";

		try (PreparedStatement pstm = con.prepareStatement(sql)) {
			System.out.println("Updating student record with ID: " + id);
   
			pstm.setString(1, name);
			System.out.println(name);
			pstm.setInt(2, age);
			pstm.setString(3, gender);
			pstm.setString(4, dob);
			pstm.setString(5, email);
			pstm.setString(6, mobile);
			System.out.println(mobile);
			pstm.setString(7, address);
			pstm.setString(8, studentClass);
			System.out.println(id);
			pstm.setInt(9, id);  // WHERE condition
   
			res = pstm.executeUpdate();
   
			if (res > 0) {
				System.out.println("Student record updated successfully");
			}
			else {
				System.out.println("No student record found with ID: " + id);
			}
	}
		catch (SQLException e) {
			System.err.println("Error updating student record");
			e.printStackTrace();
	}
		return res;
}
	
	public int delete(int id) {
	    int res = 0;
	    String sql = "DELETE FROM register WHERE \"ID\"=?";
	    
	    try (PreparedStatement pstm = con.prepareStatement(sql)) {
	        System.out.println("Deleting student record with ID: " + id);
	        
	        pstm.setInt(1, id);
	        res = pstm.executeUpdate();
	        
	        if (res > 0) {
	            System.out.println("Student record deleted successfully");
	        } else {
	            System.out.println("No student record found with ID: " + id);
	        }
	    } catch (SQLException e) {
	        System.err.println("Error deleting student record");
	        e.printStackTrace();
	    }
	    return res;
	}
	
	
	
	
	
	
}
