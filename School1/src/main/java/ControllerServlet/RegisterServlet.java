package ControllerServlet;

import java.io.IOException;
import ServicesDB.Conn;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
//        // Get all form parameters
//        String id = req.getParameter("id");
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
//        int res = c1.add(ID, name, AGE, gender, dob, email, mobile, address, studentClass);
//        
//        // Log the received data (for debugging)
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
    	
    	
    	
    	
    	
    	  
        // Get all form parameters
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
        
        // Create connection and check if ID exists
        Conn c1 = new Conn();
        
        // First check if ID already exists
        if (c1.idExists(ID)) {
            // Redirect back with error message
            resp.sendRedirect("register.html?error=duplicate_id");
        } else {
            // Add student if ID doesn't exist
            int res = c1.add(ID, name, AGE, gender, dob, email, mobile, address, studentClass);
            
            // Log the received data (for debugging)
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
            
            // Redirect with success message
            resp.sendRedirect("register.html?success=registered");
        }
    	
    }
}