package ControllerServlet;

import java.io.IOException;

import ServicesDB.Conn;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id = req.getParameter("id");
//        String name = req.getParameter("name");
//        String age = req.getParameter("age");
//        String gender = req.getParameter("gender");
//        String dob = req.getParameter("dob");
//        String email = req.getParameter("email");
//        String mobile = req.getParameter("mobile");
//        String address = req.getParameter("address");
//        String studentClass = req.getParameter("class");
//        
//        // Convert to appropriate types
//        int ID = Integer.parseInt(id);
//        int AGE = Integer.parseInt(age);
//        
//        // Create connection and add student
//        Conn c1 = new Conn();
//        System.out.println("update conn se going on");
//        c1.update(ID, name, AGE, gender, dob, email, mobile, address, studentClass);
//        
//        System.out.println("query is updated");
//        // for data update 
//        System.out.println("Registration Details:");
//        System.out.println("ID: " + id);
//        System.out.println("Name: " + name);
//        System.out.println("Age: " + age);
//        System.out.println("Gender: " + gender);
//        System.out.println("DOB: " + dob);
//        System.out.println("Email: " + email);
//        System.out.println("Mobile: " + mobile);
//        System.out.println("Address: " + address);
//        System.out.println("Class: " + studentClass);
//        
//        // Redirect after processing
//        resp.sendRedirect("home.html");
		
		
		
		
		
		
		
		
		
		
		
		  String id = req.getParameter("id");
	        String name = req.getParameter("name");
	        String age = req.getParameter("age");
	        String gender = req.getParameter("gender");
	        String dob = req.getParameter("dob");
	        String email = req.getParameter("email");
	        String mobile = req.getParameter("mobile");
	        String address = req.getParameter("address");
	        String studentClass = req.getParameter("class");
	        
	        // Convert to appropriate types
	        int ID = Integer.parseInt(id);
	        int AGE = Integer.parseInt(age);
	        
	        // Create connection and update student
	        Conn c1 = new Conn();
	        System.out.println("update conn se going on");
	        int result = c1.update(ID, name, AGE, gender, dob, email, mobile, address, studentClass);
	        
	        System.out.println("query is updated");
	        // for data update 
	        System.out.println("Registration Details:");
	        System.out.println("ID: " + id);
	        System.out.println("Name: " + name);
	        System.out.println("Age: " + age);
	        System.out.println("Gender: " + gender);
	        System.out.println("DOB: " + dob);
	        System.out.println("Email: " + email);
	        System.out.println("Mobile: " + mobile);
	        System.out.println("Address: " + address);
	        System.out.println("Class: " + studentClass);
	        
	        // Redirect based on update result
	        if (result > 0) {
	            // Record was updated successfully
	            resp.sendRedirect("edit.html?status=success");
	        } else {
	            // No record found with that ID
	            resp.sendRedirect("edit.html?status=error");
	        }
		
		
		
		
        
	}

}
