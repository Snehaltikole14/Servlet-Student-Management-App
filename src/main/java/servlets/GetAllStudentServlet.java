package servlets;

import controller.StudentController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;
import java.util.List;

@WebServlet("/getAllStudent")

public class GetAllStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        res.setCharacterEncoding("UTF-8");

        System.out.println("Fetching all students...");

        StudentController controller = new StudentController();
        List<Student> students = controller.getAllStudent();

        if (students.isEmpty()) {
            res.getWriter().println("No students found.");
            return;
        }

        for (Student student : students) {
            res.getWriter().println("ID: " + student.getId() +
                    ", Name: " + student.getName() +
                    ", Gender: " + student.getGender() +
                    ", DOB: " + student.getDob());
        }
    }
}
