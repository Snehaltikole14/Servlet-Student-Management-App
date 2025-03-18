package servlets;

import controller.StudentController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/editStudent")
public class EditStudentServlets extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");


        System.out.println("---- Received Parameters ----");
        req.getParameterMap().forEach((key, value) ->
                System.out.println(key + " = " + (value.length > 0 ? value[0] : "NULL"))
        );

        String studentName = req.getParameter("name");
        String gender = req.getParameter("gender");
        int id = Integer.parseInt(req.getParameter("id"));

        String dobString = req.getParameter("dob");

        if (dobString == null || dobString.trim().isEmpty()) {
            System.out.println("Error: DOB is missing from request!");
            res.getWriter().println("Error: Date of Birth is required.");
            return;
        }

        LocalDate dob;
        try {
            dob = LocalDate.parse(dobString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            res.getWriter().println("Error: Invalid Date of Birth format.");
            return;
        }

        Student student = Student.builder()
                .id(id)
                .name(studentName)
                .gender(gender)
                .dob(dob)
                .build();
        StudentController controller = new StudentController();
      controller.editStudent(student);
    }
}
