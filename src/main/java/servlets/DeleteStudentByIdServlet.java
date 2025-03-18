package servlets;

import controller.StudentController;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;


import java.io.IOException;

@WebServlet("/deleteStudent")

public class DeleteStudentByIdServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        StudentController controller = new StudentController();
        int id = Integer.parseInt(req.getParameter("id"));
        controller.deleteStudentById(id);
        res.getWriter().println("Student deleted successfully");
    }
}
