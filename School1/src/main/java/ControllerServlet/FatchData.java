package ControllerServlet;

import java.util.List;
import Entity.Student;
import ServicesDB.Conn;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FetchData")
public class FatchData extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        try {
            // Get student data from DAO
            List<Student> students = Conn.getAllStudents();
            
            // Generate HTML response
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Student Data</title>");
            out.println("<style>");
            out.println("body { ");
            out.println("    font-family: Arial, sans-serif;  user-select: none; ");
            out.println("    margin: 20px; ");
            out.println("    background-image: url(https://cdn.pixabay.com/photo/2018/07/05/16/59/students-3518726_1280.jpg);");
            out.println("    background-size: cover;");
            out.println("    background-attachment: fixed;");
            out.println("}");
            out.println(".container {");
            out.println("    max-width: 1200px;");
            out.println("    margin: 20px auto;");
            out.println("    padding: 20px;");
            out.println("    background-color: rgba(255, 255, 255, 0.95);");
            out.println("    border-radius: 10px;");
            out.println("    box-shadow: 0 0 15px rgba(0,0,0,0.2);");
            out.println("}");
            out.println("h1 { ");
            out.println("    color: #2c3e50; ");
            out.println("    text-align: center; ");
            out.println("    margin-bottom: 30px;");
            out.println("}");
            out.println("table { ");
            out.println("    width: 100%; ");
            out.println("    border-collapse: collapse; ");
            out.println("    margin-top: 20px;");
            out.println("    box-shadow: 0 0 10px rgba(0,0,0,0.1);");
            out.println("}");
            out.println("th { ");
            out.println("    background-color: #87CEEB; /* Sky blue */");
            out.println("    color: #2c3e50; ");
            out.println("    padding: 12px; ");
            out.println("    text-align: left; ");
            out.println("    border-bottom: 2px solid #4682B4;");
            out.println("}");
            out.println("td { ");
            out.println("    padding: 10px; ");
            out.println("    border-bottom: 1px solid #ddd;");
            out.println("}");
            out.println("tr { ");
            out.println("    background-color: #E0F7FA; /* Light sky blue */");
            out.println("}");
            out.println("tr:hover { ");
            out.println("    background-color: #81D4FA; /* Hover color */");
            out.println("}");
            out.println(".btn { ");
            out.println("    display: inline-block; ");
            out.println("    padding: 10px 15px; ");
            out.println("    background: #2c3e50; ");
            out.println("    color: white; ");
            out.println("    text-decoration: none; ");
            out.println("    border-radius: 5px; ");
            out.println("    margin-top: 20px; ");
            out.println("}");
            out.println(".btn:hover { ");
            out.println("    background: #1a252f; ");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body >");
            out.println("<div class='container'>");
            out.println("<h1>Student Records</h1>");
            
            if (students.isEmpty()) {
                out.println("<p>No student records found.</p>");
            } else {
                out.println("<table  >");
                out.println("<tr>");
                out.println("<th>ID</th>");
                out.println("<th>Name</th>");
                out.println("<th>Age</th>");
                out.println("<th>Gender</th>");
                out.println("<th>Date of Birth</th>");
                out.println("<th>Email</th>");
                out.println("<th>Mobile</th>");
                out.println("<th>Address</th>");
                out.println("<th>Class</th>");
                out.println("</tr>");
                
                for (Student student : students) {
                    out.println("<tr>");
                    out.println("<td>" + student.getId() + "</td>");
                    out.println("<td>" + student.getName() + "</td>");
                    out.println("<td>" + student.getAge() + "</td>");
                    out.println("<td>" + student.getGender() + "</td>");
                    out.println("<td>" + student.getDob() + "</td>");
                    out.println("<td>" + student.getEmail() + "</td>");
                    out.println("<td>" + student.getMobile() + "</td>");
                    out.println("<td>" + student.getAddress() + "</td>");
                    out.println("<td>" + student.getStudentClass() + "</td>");
                    out.println("</tr>");
                }
                
                out.println("</table>");
            }
            
            out.println("<a href='home.html' class='btn' >Back to Home</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
        } catch (Exception e) {
            out.println("<div class='container'><h2>Error retrieving student data</h2>");
            out.println("<p>" + e.getMessage() + "</p></div>");
            e.printStackTrace();
        }
    }
}