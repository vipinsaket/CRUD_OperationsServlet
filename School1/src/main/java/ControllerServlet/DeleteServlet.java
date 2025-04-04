package ControllerServlet;

import java.io.IOException;

import ServicesDB.Conn;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id=req.getParameter("id");
//		int ID=Integer.parseInt(id);
//		
//		Conn c=new Conn();
//		int res=c.delete(ID);
//		
//		
//		
//		System.out.println("deleted");
//		resp.sendRedirect("home.html");
//		
		
		
String idParam = req.getParameter("id");
        
        try {
            int ID = Integer.parseInt(idParam.trim());
            Conn c = new Conn();
            int res = c.delete(ID);
            
            if (res > 0) {
                resp.getWriter().write("deleted");
            } else {
                resp.getWriter().write("not_found");
            }
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error processing request");
        }
		
				
	}

}
